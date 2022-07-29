package com.example.soccernews.data.remote;
import com.example.soccernews.domain.News;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("news.json")
    Call<List<News>> findNews();
}