package com.example.nux.flickpro.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nux.flickpro.R;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;
import com.squareup.picasso.Picasso;

public class PhotoHolder extends RecyclerView.ViewHolder {
    public TextView mTitle;
    public ImageView mImageView;
    public TextView mOwner;
    public TextView mComments;
    public PhotoHolder(@NonNull View itemView) {
        super(itemView);
        mTitle=itemView.findViewById(R.id.title);
        mImageView=itemView.findViewById(R.id.photo);
        mOwner=itemView.findViewById(R.id.owner);
        mComments=itemView.findViewById(R.id.number_comment);
    }
    public void bind(PhotoInfo item){
       mTitle.setText(item.getTitle().getContent());
        Picasso.get()
                .load(item.getUrl())
                .placeholder(R.drawable.background_load_image)
                .into(mImageView);
        mOwner.setText(item.getOwner().getUsername());
        mComments.setText(String.valueOf(item.getComments().getContent()));
    }
}
