package com.example.kartkowka_room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Sprawdzian.class}, version = 1)
public abstract class dbSpr extends RoomDatabase {
    public abstract SprawdzianDAO getSprawdzianDAO();

    private static dbSpr element;
    public static dbSpr zwrocElement(Context context){
        if(element == null){
            element = Room.databaseBuilder(context.getApplicationContext(), dbSpr.class,"sprawdzianyDB")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return element;
    }
}
