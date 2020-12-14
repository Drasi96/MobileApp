package com.example.foodhollow;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {loginData.class}, version = 1)
public abstract class LoginDatabase extends RoomDatabase {

    public abstract loginDataDao loginDataDao();

    private static LoginDatabase INSTANCE = null;

    public static LoginDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (LoginDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, LoginDatabase.class ,  "login_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
