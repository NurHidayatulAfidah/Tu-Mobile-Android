package com.example.asus.projectfinish;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 16/05/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Barang> mData;

    public RecyclerViewAdapter(Context mContext, List<Barang> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_barang_title.setText(mData.get(position).getNamabarang());
        holder.img_barang_thumbnail.setImageResource(mData.get(position).getThumbnail() );
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_barang_title;
        ImageView img_barang_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_barang_title = (TextView) itemView.findViewById(R.id.nama_barang_id);
            img_barang_thumbnail = (ImageView) itemView.findViewById(R.id.barang_img_id);


            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
