package com.example.belajarrecyclerview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarrecyclerview.DetailBeritaActivity;
import com.example.belajarrecyclerview.R;
import com.example.belajarrecyclerview.model.BeritaModel;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {

    private List<BeritaModel> listBerita;
    private Context context;

    public BeritaAdapter (List<BeritaModel> listBerita, Context context) {
        this.listBerita = listBerita;
        this.context = context;
    }

    @NonNull
    @Override
    public BeritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout,parent, false);
        return new BeritaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.BeritaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(listBerita.get(position).getImages()).into(holder.imageBerita);
        holder.textJudul.setText(listBerita.get(position).getJudul());
        holder.textKategori.setText(listBerita.get(position).getKategori());
        if (listBerita.get(position).getKategori().equalsIgnoreCase("Health")) {
            holder.textList.setTextColor(ColorStateList.valueOf(Color.RED));
        } else if (listBerita.get(position).getKategori().equalsIgnoreCase("Sports")) {
            holder.textList.setTextColor(ColorStateList.valueOf(Color.GREEN));
        }

        holder.textJudul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailBeritaActivity.class);
                intent.putExtra("beritaModel", listBerita.get(position));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listBerita.size();
    }

    public class BeritaViewHolder extends RecyclerView.ViewHolder {

        ImageView imageBerita;
        TextView textJudul, textList, textKategori, textDeskripsi;

        public BeritaViewHolder (@NonNull View itemView) {
            super(itemView);
            imageBerita = itemView.findViewById(R.id.imageBerita);
            textJudul = itemView.findViewById(R.id.textJudul);
            textList = itemView.findViewById(R.id.textList);
            textKategori = itemView.findViewById(R.id.textKategori);
            textDeskripsi = itemView.findViewById(R.id.textDeskripsi);

        }
    }
}
