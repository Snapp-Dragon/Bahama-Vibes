package com.example.sandr.bahamavibes.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.sandr.bahamavibes.Dishes;
import com.example.sandr.bahamavibes.Monuments;

/*
 The database will accept entities of type Dishes.
 */
@Database(entities = {Dishes.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;  // data base instance

    public abstract DishDAO dishesModel(); // data access object

    private static final String DATABASE_NAME = "Dish_Database";







    public static AppDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE  = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DATABASE_NAME)
                    .build();

                    /*
                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                            .allowMainThreadQueries()
                            .build();
                            */

        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }
}
