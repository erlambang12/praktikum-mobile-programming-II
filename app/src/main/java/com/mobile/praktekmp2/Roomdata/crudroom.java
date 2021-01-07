package com.mobile.praktekmp2.Roomdata;

import android.app.Application;

import androidx.room.Room;

public class crudroom  extends Application {
    private static crudroom INSTANCE;
    private Databaseapp databaseapp;

    public static crudroom getInstance(){return INSTANCE;}

    @Override
    public void onCreate() {
        super.onCreate();
        databaseapp = Room.databaseBuilder(this,Databaseapp.class,"database_maha")
            .addMigrations(Databsemigration.MIGRATION_1_TO_2)
            .allowMainThreadQueries()
            .build();

        INSTANCE = this;
    }
    public Databaseapp getDatabaseapp(){return databaseapp;}
}
