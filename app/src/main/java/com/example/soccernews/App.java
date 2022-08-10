package com.example.soccernews;

import android.app.Application;

public class App extends Application {
    private static App instance;

    public static App getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
