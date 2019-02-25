package com.example.nux.flickpro.Paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;
import android.util.Log;

import com.example.nux.flickpro.model.photorecent.Photo;

public class ItemDataSourceFactory extends DataSource.Factory {
    private static final String TAG = "ItemDataSourceFactory";
    //creating the mutable live data
    private MutableLiveData<PageKeyedDataSource<Integer, Photo>> itemLiveDataSource=new MutableLiveData<>();

    @Override
    public DataSource<Integer,Photo> create() {
        //getting our data source object
        ItemDataSource itemDataSource=new ItemDataSource();
        //posting the datasource to get the values
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Photo>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
