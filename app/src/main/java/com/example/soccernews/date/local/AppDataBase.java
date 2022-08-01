package com.example.soccernews.date.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.soccernews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract NewsDao  NewsDao();
}
