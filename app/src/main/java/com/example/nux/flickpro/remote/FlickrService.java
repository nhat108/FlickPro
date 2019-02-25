package com.example.nux.flickpro.remote;

import com.example.nux.flickpro.model.photoinfo.PhotoInfoResponse;
import com.example.nux.flickpro.model.photorecent.PhotosReponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickrService {
    @GET("?method=flickr.photos.getRecent")
    Call<PhotosReponse> getPhotosRecent();

    @GET("?method=flickr.photos.getInfo")
    Call<PhotoInfoResponse> getPhotosInfo(@Query("photo_id") String photoId);

    @GET("?method=flickr.photos.search")
    Call<PhotosReponse> getPhotosSearch(@Query("text") String query);

    @GET("?method=flickr.photos.getRecent")
    Call<PhotosReponse> getPhotosRecent(
            @Query("page") int page,
            @Query("per_page") int perpage
    );
}
