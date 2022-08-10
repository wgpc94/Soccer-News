package com.example.soccernews.data;

import androidx.room.Room;

import com.example.soccernews.App;
import com.example.soccernews.data.local.AppDataBase;
import com.example.soccernews.data.remote.NewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Repository{

    private static final String REMOTE_API_URL = "https://wgpc94.github.io/soccer_news_api/";
    private static final String DATA_BASE  = "soccer-news";

    private final NewsApi remoteApi;
    private final AppDataBase localDataBase;

    public NewsApi getRemoteApi() {
        return remoteApi;
    }
    public AppDataBase getLocalDataBase() {
        return localDataBase;
    }

    private Repository(){
        remoteApi = new  Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApi.class);

        localDataBase = Room.databaseBuilder(App.getInstance(), AppDataBase.class, DATA_BASE)
                .allowMainThreadQueries()
                .build();
    }

    public static Repository getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Repository INSTANCE = new Repository();
    }

}
