package com.example.nux.flickpro.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.nux.flickpro.R;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;
import com.example.nux.flickpro.model.photorecent.Photo;
import com.squareup.picasso.Picasso;

public class PhotoSearchHolder extends RecyclerView.ViewHolder {
    ImageView mImageView;
    public PhotoSearchHolder(@NonNull View itemView) {
        super(itemView);
        mImageView= itemView.findViewById(R.id.imageviewSearch);
    }
    public void bind(Photo photo){
        Picasso.get().load(photo.getUrlC()).into(mImageView);
    }


}
