package com.example.belajarrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.belajarrecyclerview.model.BeritaModel;

public class DetailBeritaActivity extends AppCompatActivity {

    ImageView imageBerita;
    TextView textTitle, textDetailKategori, textDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        imageBerita = findViewById(R.id.imageBeritaDetail);
        textDetailKategori = findViewById(R.id.textKategoriDetail);
        textTitle = findViewById(R.id.textTitle);
        textDeskripsi = findViewById(R.id.textDeskripsi);

        BeritaModel berita = getIntent().getExtras().getParcelable("beritaModel");

        Glide.with(this).load(berita.getImages()).into(imageBerita);
        textDetailKategori.setText(berita.getKategori());
        textTitle.setText(berita.getJudul());
        textDeskripsi.setText(berita.getDeskripsi());
    }
}