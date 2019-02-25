package com.example.nux.flickpro.remote;


public class ApiUtils {
    private static final String BASE_URL="https://api.flickr.com/services/rest/";

    public static FlickrService getFlickrService(){
        return RetrofitClient.getClient(BASE_URL).create(FlickrService.class);
    }
}
