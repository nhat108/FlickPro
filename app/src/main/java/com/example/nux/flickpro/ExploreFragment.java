package com.example.nux.flickpro;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.nux.flickpro.Adapter.MyAdapter;
import com.example.nux.flickpro.Paging.ItemAdapter;
import com.example.nux.flickpro.Paging.PhotoViewModel;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;
import com.example.nux.flickpro.model.photoinfo.PhotoInfoResponse;
import com.example.nux.flickpro.model.photorecent.Photo;
import com.example.nux.flickpro.model.photorecent.PhotosReponse;
import com.example.nux.flickpro.remote.ApiUtils;
import com.example.nux.flickpro.remote.FlickrService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreFragment extends Fragment {
    private static final String TAG = "ExploreFragment";
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private ItemAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        mRecyclerView = view.findViewById(R.id.recyclerView);
        mProgressBar = view.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerView.setHasFixedSize(true);
        adapter = new ItemAdapter(getContext());
        PhotoViewModel model = ViewModelProviders.of(this).get(PhotoViewModel.class);

        model.itemPagedList.observe(this, new Observer<PagedList<Photo>>() {
            @Override
            public void onChanged(@Nullable PagedList<Photo> photos) {
               adapter.submitList(photos);

            }
        });
        mRecyclerView.setAdapter(adapter);
        return view;
    }


}
