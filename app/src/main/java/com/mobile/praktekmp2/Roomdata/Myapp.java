package com.mobile.praktekmp2.Roomdata;

import android.app.Application;

import androidx.room.Room;

public class Myapp extends Application {
    public static Databaseapp db;

    public void onCreate() {
        super.onCreate();
        db= Room.databaseBuilder(getApplicationContext(),
                Databaseapp.class,"mahasiswa").allowMainThreadQueries().build();
    }
}
