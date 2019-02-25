package com.example.nux.flickpro.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nux.flickpro.R;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;
import com.example.nux.flickpro.model.photorecent.Photo;

import java.util.List;

public class PhotoSearchAdapter extends RecyclerView.Adapter<PhotoSearchHolder> {
    private List<Photo>mListPhoto;

    public PhotoSearchAdapter(List<Photo>mListPhoto){
        this.mListPhoto=mListPhoto;
    }
    @NonNull
    @Override
    public PhotoSearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.list_item_photo_search,viewGroup,false);
        return new PhotoSearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoSearchHolder photoSearchHolder, int i) {
        Photo photo=mListPhoto.get(i);
        photoSearchHolder.bind(photo);
    }

    @Override
    public int getItemCount() {
        return mListPhoto.size();
    }
}
