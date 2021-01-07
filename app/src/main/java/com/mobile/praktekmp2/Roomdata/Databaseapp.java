package com.mobile.praktekmp2.Roomdata;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mobile.praktekmp2.Entity.Mahasiswa;

@Database(entities = {Mahasiswa.class},version = 11)
public abstract class Databaseapp extends RoomDatabase {

    public abstract mahasiswaDAO userDao();

}
