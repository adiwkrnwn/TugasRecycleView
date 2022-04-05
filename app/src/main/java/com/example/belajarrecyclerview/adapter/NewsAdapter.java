package com.example.belajarrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.belajarrecyclerview.R;
import com.example.belajarrecyclerview.model.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private List<Article> article;

    public NewsAdapter(Context context, List<Article> article) {
        this.context = context;
        this.article = article;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout_detail_news,parent,false);
        return new NewsAdapter.NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsHolder holder, int position) {
        holder.txtAuthorNews.setText(article.get(position).getAuthor());
        holder.txtTitleNews.setText(article.get(position).getTitle());
        holder.txtPublishedAtNews.setText(article.get(position).getPublishedAt());
        Glide.with(context).load(article.get(position).getUrlToImage()).into(holder.imageNews);

    }

    @Override
    public int getItemCount() {
        return article.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{

        ImageView imageNews;
        TextView txtTitleNews,txtAuthorNews,txtPublishedAtNews;
        CardView cardButton;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imageNews = itemView.findViewById(R.id.imageNews);
            cardButton = itemView.findViewById(R.id.cardButton);
            txtTitleNews = itemView.findViewById(R.id.txtTitleNews);
            txtAuthorNews = itemView.findViewById(R.id.txtAuthorNews);
            txtPublishedAtNews = itemView.findViewById(R.id.txtPublishedAtNews);
        }
    }

}
