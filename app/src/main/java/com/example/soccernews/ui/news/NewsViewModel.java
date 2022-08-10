package com.example.soccernews.ui.news;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccernews.data.Repository;
import com.example.soccernews.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {
    private final MutableLiveData<List<News>> news;

    public  NewsViewModel() {
        this.news = new MutableLiveData<>();
        findNews();
    }
    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }

    private void findNews() {
        Repository.getInstance().getRemoteApi().findNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(@NonNull Call<List<News>> call, @NonNull Response<List<News>> response) {
                if (response.isSuccessful()){
                    news.setValue(response.body());
                }else {
                    Log.d("Error on response ", "response is not successful");
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<News>> call, @NonNull Throwable t) {
                Log.d("Error on failure ", t.getMessage());
            }
        });
    }

    public void save(News news) {
        Repository.getInstance().getLocalDataBase().NewsDao().save(news);
    }

}