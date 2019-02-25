package com.example.nux.flickpro.Paging;

import android.annotation.SuppressLint;
import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nux.flickpro.R;
import com.example.nux.flickpro.model.photoinfo.PhotoInfo;
import com.example.nux.flickpro.model.photorecent.Photo;
import com.squareup.picasso.Picasso;

public class ItemAdapter extends PagedListAdapter<Photo, ItemAdapter.ItemViewHolder> {
    private Context context;

    public ItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.list_item_photo, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Photo photoInfo=getItem(i);
        if(photoInfo!=null){
            itemViewHolder.bind(photoInfo);
        }
    }
    //This callback is used to differentiate two items in a List.
    private static DiffUtil.ItemCallback<Photo> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Photo>() {
                @Override
                public boolean areItemsTheSame(@NonNull Photo photoInfo, @NonNull Photo t1) {
                    return photoInfo.getId() == t1.getId();
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull Photo photoInfo, @NonNull Photo t1) {
                    return photoInfo.equals(t1);
                }
            };

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        private ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView= itemView.findViewById(R.id.photo);
        }
        public void bind(Photo item){
            Picasso.get().load(item.getUrlC()).into(mImageView);
        }
    }
}
