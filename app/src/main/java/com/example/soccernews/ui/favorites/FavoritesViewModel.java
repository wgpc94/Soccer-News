package com.example.soccernews.ui.favorites;

import androidx.lifecycle.ViewModel;

import com.example.soccernews.data.Repository;
import com.example.soccernews.domain.News;

public class FavoritesViewModel extends ViewModel {
    public void save(News newsSave) {
        Repository.getInstance().getLocalDataBase().NewsDao().save(newsSave);
    }
}

