package com.example.soccernews.ui.news;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.soccernews.data.remote.NewsApi;
import com.example.soccernews.domain.News;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final NewsApi api;
    private final MutableLiveData<List<News>> news;

    public  NewsViewModel() {
        this.news = new MutableLiveData<>();
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://wgpc94.github.io/soccer_news_api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(NewsApi.class);
        findNews();
    }

    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }

    private void findNews() {
        api.findNews().enqueue(new Callback<List<News>>() {
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
}