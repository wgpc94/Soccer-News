package com.example.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.soccernews.data.Repository;
import com.example.soccernews.databinding.FragmentFavoritesBinding;
import com.example.soccernews.domain.News;
import com.example.soccernews.ui.NewsAdapter;

import java.util.List;

public class FavoritesFragment extends Fragment  {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FavoritesViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);

        binding = FragmentFavoritesBinding.inflate(inflater, container, false);
        loadFavoriteNews(favoritesViewModel);
        return binding.getRoot();
    }

    private void loadFavoriteNews(FavoritesViewModel favoritesViewModel) {
            List<News> newsList;
            newsList = Repository.getInstance().getLocalDataBase().NewsDao().getFavoritesNews();
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            binding.rvNews.setAdapter(new NewsAdapter(newsList, news -> {
                favoritesViewModel.save(news);
                loadFavoriteNews(favoritesViewModel);
            }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}