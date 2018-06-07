package com.example.asus.projectfinish;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Asus on 06/06/2018.
 */

public class adapter_home extends RecyclerView.Adapter<adapter_home.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public adapter_home(HomeActivity homeActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = homeActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*Glide.with(context())
                .load("https://databases-auth.000webhost.com/id6017007_daml/data_barang" + list_data.get(0).get("file"))
                .into(img_brng);*/
        holder.txt_nama_brg.setText(list_data.get(position).get("nama"));
        holder.txt_harga.setText(list_data.get(position).get("harga"));
        holder.txt_stok.setText(list_data.get(position).get("stok"));
        holder.id.setText(list_data.get(position).get("id"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_brng;
        TextView txt_nama_brg, txt_harga, txt_stok, id;

        public ViewHolder(View itemView) {
            super(itemView);

            txt_harga = (TextView) itemView.findViewById(R.id.harga);
            txt_nama_brg = (TextView) itemView.findViewById(R.id.nama_barang);
            txt_stok = (TextView) itemView.findViewById(R.id.stok);
            id = (TextView) itemView.findViewById(R.id.id_barang);
        }
    }
}