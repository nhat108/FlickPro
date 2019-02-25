package com.example.nux.flickpro.Paging;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import com.example.nux.flickpro.model.photorecent.Photo;

import android.arch.paging.LivePagedListBuilder;


public class PhotoViewModel extends ViewModel {
    private static final String TAG = "PhotoViewModel";


    public LiveData<PageKeyedDataSource<Integer,Photo>>liveDataPhoto;
    public LiveData<PagedList<Photo>> itemPagedList;
    public PhotoViewModel(){
        //getting our data source factory
        ItemDataSourceFactory itemDataSourceFactory=new ItemDataSourceFactory();
        //getting the live data source from data source factory
        liveDataPhoto=itemDataSourceFactory.getItemLiveDataSource();
        //Getting PagedList config
        PagedList.Config pagedListConfig=
                (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();
        //Building the paged list

        itemPagedList=(new LivePagedListBuilder(itemDataSourceFactory,pagedListConfig))
                .build();


    }
//    public LiveData<PagedList<PhotoInfo>> getPhotoInfos() {
//        if (photoInfoList == null) {
//            photoInfoList = new MutableLiveData<>();
//            photoList=new MutableLiveData<>();
//           // mFlickrService = ApiUtils.getFlickrService();
//           // loadPhoto();
//        }
//        return photoInfoList;
//    }
//
//
//    private void loadPhoto() {
//        mFlickrService = ApiUtils.getFlickrService();
//        mFlickrService.getPhotosRecent().enqueue(new Callback<PhotosReponse>() {
//            @Override
//            public void onResponse(Call<PhotosReponse> call, Response<PhotosReponse> response) {
//                if (response.isSuccessful()) {
//                    Log.d(TAG, "load list photos  success:" + response.raw().request().url());
//                    photoList.setValue(response.body().getPhotos().getPhoto());
//
//                    for (final Photo photo : Objects.requireNonNull(photoList.getValue())) {
//                            String photoId = photo.getId();
//                            String url = photo.getUrlC();
//                            if (url != null && photoId != null) {
//                                loadPhotoInfo(photoId, url);
//                            }
//
//
//                    }
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PhotosReponse> call, Throwable t) {
//                //Log.d(TAG, "Photo: why do we fall?");
//            }
//        });
//
//    }
//
//    private void loadPhotoInfo(String photoId,  String url) {
//        mFlickrService = ApiUtils.getFlickrService();
//        mFlickrService.getPhotosInfo(photoId).enqueue(new Callback<PhotoInfoResponse>() {
//            @Override
//            public void onResponse(Call<PhotoInfoResponse> call, Response<PhotoInfoResponse> response) {
//                if (response.isSuccessful()) {
//                    Log.d(TAG, "load photo info success: " + response.raw().request().url());
//                    assert response.body() != null;
//                    PhotoInfo photoInfo = response.body().getPhoto();
//                    photoInfo.setUrl(url);
//                    photoInfos.add(0,response.body().getPhoto());
//                    photoInfoList= (LiveData<PagedList<PhotoInfo>>) photoInfos;
//                } else {
//                    Log.d(TAG, "load photo info not success");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PhotoInfoResponse> call, Throwable t) {
//            //    Log.d(TAG, "Photo info:Why do we fall?");
//            }
//        });
//
//
 //   }
}
