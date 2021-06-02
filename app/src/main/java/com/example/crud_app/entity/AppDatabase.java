package com.example.crud_app.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = DataMovie.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataMovieDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase inidb(Context context){
        if (appDatabase==null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dbMovie").allowMainThreadQueries().build();
        return appDatabase;
    }
}
