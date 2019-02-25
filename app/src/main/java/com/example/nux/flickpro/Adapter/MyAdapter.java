package com.example.nux.flickpro.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nux.flickpro.R;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<PhotoHolder> {
    private List<PhotoInfo> listPhoto;

    public MyAdapter(List<PhotoInfo> listPhoto) {
        this.listPhoto = listPhoto;
    }


    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.list_item_photo, viewGroup, false);
        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder photoHolder, int i) {
        PhotoInfo photoInfo =listPhoto.get(i);
        photoHolder.bind(photoInfo);
    }

    @Override
    public int getItemCount() {
        return listPhoto.size();
    }
}
