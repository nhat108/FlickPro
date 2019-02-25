package com.example.nux.flickpro.remote;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    private static final String API_KEY = "e8ec27091d8aa891e8d64c9124f167a1";
    private static final String FORMAT="json";
    private static final String EXTRAS_URL="url_c";

    public static Retrofit getClient(String baseUrl){
         OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original=chain.request();
                        HttpUrl httpUrl=original.url();

                        HttpUrl newHttpUrl=httpUrl.newBuilder().addQueryParameter("api_key",API_KEY)
                                .addQueryParameter("extras",EXTRAS_URL)
                                .addQueryParameter("format",FORMAT)
                                .addQueryParameter("nojsoncallback","1")
                                .build();
                        Request.Builder requestBuilder=original.newBuilder().url(newHttpUrl);

                        Request request=requestBuilder.build();
                        return chain.proceed(request);

                    }
                })
                .build();

                retrofit=new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


            return retrofit;
    }

    }

