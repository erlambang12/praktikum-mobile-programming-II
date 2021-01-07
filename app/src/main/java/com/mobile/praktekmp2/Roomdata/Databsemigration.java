package com.mobile.praktekmp2.Roomdata;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class Databsemigration {
    public static final Migration MIGRATION_1_TO_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE mahasiswa ADD COLUMN gambar TEXT DEFAULT ''");
        }
    };
}
