package com.example.soccernews.ui.news;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.soccernews.domain.News;
import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public  NewsViewModel() {
        this.news = new MutableLiveData<>();
        ArrayList<News> listNewsMock  = new ArrayList<>();
        listNewsMock.add(new News("Lorem Ipsum", "é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos."));
        listNewsMock.add(new News("Lorem Ipsum", "é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos."));
        listNewsMock.add(new News("Lorem Ipsum", "é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos."));
        this.news.setValue(listNewsMock);
    }

    public MutableLiveData<List<News>> getNews() {
        return this.news;
    }
}