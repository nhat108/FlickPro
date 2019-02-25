package com.example.nux.flickpro;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.SearchView;

import com.example.nux.flickpro.Adapter.GridSpacingItemDecoration;
import com.example.nux.flickpro.Adapter.MyAdapter;
import com.example.nux.flickpro.Adapter.PhotoSearchAdapter;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;
import com.example.nux.flickpro.model.photorecent.Photo;
import com.example.nux.flickpro.model.photorecent.PhotosReponse;
import com.example.nux.flickpro.remote.ApiUtils;
import com.example.nux.flickpro.remote.FlickrService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchQueryFragment extends Fragment {
    private static final String TAG = "SearchQueryFragment";
    private RecyclerView mRecyclerView;
    private static final String QUERY = "query";
    private FlickrService mFlickrService;
    private List<Photo>mListPhoto=new ArrayList<>();
    private PhotoSearchAdapter myAdapter;

    public static SearchQueryFragment newInstance(String query) {
        Bundle args = new Bundle();
        args.putString(QUERY, query);
        SearchQueryFragment fragment = new SearchQueryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String query = getArguments().getString(QUERY);
        mFlickrService = ApiUtils.getFlickrService();
        if (query != null) {
            searchWithQuery(query);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_query, container, false);
        final SearchView mSearchView = view.findViewById(R.id.search_view);
        mRecyclerView = view.findViewById(R.id.recyclerViewSearch);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myAdapter=new PhotoSearchAdapter(mListPhoto);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mSearchView.clearFocus();
                searchWithQuery(query);
                Log.d(TAG, "onQueryTextSubmit: " + query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return view;
    }

    private void updateUI(){
        if(isAdded()){
            mRecyclerView.setAdapter(new PhotoSearchAdapter(mListPhoto));
        }
    }
    private void searchWithQuery(String query) {
     mFlickrService.getPhotosSearch(query).enqueue(new Callback<PhotosReponse>() {
         @Override
         public void onResponse(Call<PhotosReponse> call, Response<PhotosReponse> response) {
             if(response.isSuccessful()){
                 Log.d(TAG, "Response search photo success!");
                 Log.d(TAG, "onResponse: size"+response.body().getPhotos().getPhoto().size());
                 mListPhoto=response.body().getPhotos().getPhoto();
                 updateUI();
             }

         }

         @Override
         public void onFailure(Call<PhotosReponse> call, Throwable t) {

         }
     });
    }



    //Converting dp to pixel
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }

}
