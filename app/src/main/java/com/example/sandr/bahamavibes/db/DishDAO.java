package com.example.sandr.bahamavibes.db;

/*
 This is the data access object that interacts with the database
 */


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.sandr.bahamavibes.Dishes;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface DishDAO {

    //Queries


    @Query("SELECT * FROM  Dishes")
    List<Dishes> findAllDishes(); // find all dishes in the dish array list

    @Query("SELECT * FROM Dishes WHERE primaryKey = :ID")
    Dishes loadDishesByID(int ID);  // fins dishes by id

    @Query("SELECT * FROM Dishes WHERE dishName = :name")
    Dishes loadDishByName(String name); // load dish by its name

    @Query("DELETE FROM Dishes")
    void deleteAll();  // delete dishes

    @Insert(onConflict = IGNORE)
    void insertDish(Dishes dish); //insert a dish

    @Update(onConflict = REPLACE)
    void updateDish(Dishes dish); //replace dish

}
