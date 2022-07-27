package com.example.soccernews.ui;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.soccernews.databinding.NewsItemBinding;
import com.example.soccernews.domain.News;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private List<News> newsList;
    public NewsAdapter(List<News> newsList){
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(inflater, parent, false);
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTile;
        private TextView textViewDescription;

        public NewsViewHolder(NewsItemBinding binding){
            super(binding.getRoot());
            textViewTile = binding.tvTitle;
            textViewDescription = binding.tvDescription;
        }

        public void bind(News news) {
            textViewTile.setText(news.getTitle());
            textViewDescription.setText(news.getDescription());
        }
    }

}
