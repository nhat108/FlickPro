package com.example.nux.flickpro.Paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.nux.flickpro.model.photorecent.Photo;
import com.example.nux.flickpro.model.photorecent.PhotosReponse;
import com.example.nux.flickpro.remote.ApiUtils;
import com.example.nux.flickpro.remote.FlickrService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Photo> {
    private static final String TAG = "ItemDataSource";
    //the size of a page that we want
    public static final int PAGE_SIZE = 15;
    //we will start from the first page which is 1
    private static final int FIRST_PAGE = 1;
  

    //this will be called once to load the initial data
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Photo> callback) {
        FlickrService mFlickrService=ApiUtils.getFlickrService();
        mFlickrService.getPhotosRecent(FIRST_PAGE, PAGE_SIZE)
                .enqueue(new Callback<PhotosReponse>() {
                    @Override
                    public void onResponse(Call<PhotosReponse> call, Response<PhotosReponse> response) {
                        Log.d(TAG, "onResponse: "+response.raw().request().url());
                        if (response.body() != null) {
                            callback.onResult(response.body().getPhotos().getPhoto(), null, FIRST_PAGE + 1);

                            Log.d(TAG, "onResponse: "+response.body().getPhotos().getPhoto().size());
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotosReponse> call, Throwable t) {
                        Log.d(TAG, "onFailure:why do we fall ");
                    }
                });
    }

    //this will load the previous page
    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Photo> callback) {
        ApiUtils.getFlickrService()
                .getPhotosRecent(params.key, PAGE_SIZE)
                .enqueue(new Callback<PhotosReponse>() {
                    @Override
                    public void onResponse(Call<PhotosReponse> call, Response<PhotosReponse> response) {

                        //if the current page is greater than one
                        //we are decrementing the page number
                        //else there is no previous page
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
                            //passing the loaded data
                            //and the previous page key
                            callback.onResult(response.body().getPhotos().getPhoto(), adjacentKey);

                        }
                        Log.d(TAG, "onResponse: loadBefore:"+response.raw().request().url());
                    }

                    @Override
                    public void onFailure(Call<PhotosReponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: Why do we fall?");
                    }
                });
    }

    //this will load next page
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Photo> callback) {
        ApiUtils.getFlickrService()
                .getPhotosRecent(params.key,PAGE_SIZE)
                .enqueue(new Callback<PhotosReponse>() {
                    @Override
                    public void onResponse(Call<PhotosReponse> call, Response<PhotosReponse> response) {
                        if(response.body()!=null){
                            Log.d(TAG, "onResponse: load next page: "+response.raw().request().url());
                            //if the response has next page
                            //incrementing the next page number
                            Integer key=params.key+1;
                            //passing the loaded data and next page value
                            callback.onResult(response.body().getPhotos().getPhoto(),key);
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotosReponse> call, Throwable t) {

                    }
                });
    }
}
