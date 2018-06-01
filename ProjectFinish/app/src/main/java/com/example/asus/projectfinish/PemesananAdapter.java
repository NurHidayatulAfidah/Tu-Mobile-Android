package com.example.asus.projectfinish;

import android.content.Context;
import android.provider.VoicemailContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by user on 23/05/2018.
 */

public class PemesananAdapter extends RecyclerView.Adapter<PemesananAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelPemesanan> mList;

    PemesananAdapter(Context context, ArrayList<ModelPemesanan> list){
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.rv_pemesanan_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        ModelPemesanan pemesananItem = mList.get(position);

        ImageView image = holder.item_image;
        TextView tanggal, nama, jumlah, status;

        tanggal = holder.item_tanggal;
        nama = holder.item_nama;
        jumlah = holder.item_jumlah;
        status = holder.item_status;

        image.setImageResource(pemesananItem.getImage());

       tanggal.setText(pemesananItem.getTanggal());
        nama.setText(pemesananItem.getNama());
        jumlah.setText(pemesananItem.getJumlah());
        status.setText(pemesananItem.getStatus());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_tanggal, item_nama, item_jumlah , item_status;

        public ViewHolder(View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);

            item_tanggal = itemView.findViewById(R.id.item_tanggal);

            item_nama = itemView.findViewById(R.id.item_nama);

            item_jumlah = itemView.findViewById(R.id.item_jumlah);

            item_status = itemView.findViewById(R.id.item_status);
        }
    }
}
