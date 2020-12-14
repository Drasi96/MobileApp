package com.example.foodhollow;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface loginDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(loginData loginData);

    @Update
    public void update(loginData loginData);

    @Delete
    public void delete(loginData loginData);

    @Query("SELECT * from loginData where dataEmail like :email and dataPass like :pass")
    public loginData getLoginInfo(String email, String pass);

  // @Query(("UPDATE loginData SET dataName = (:newDataName), dataEmail = (:newDataEmail) , dataPass = (:) "))

  /*  @Query("SELECT * from loginData where dataName like :name and dataImage like :image")
    public loginData getNameAndPic(String name, byte[] image);*/

    @Query("SELECT * from loginData")
    public List<loginData> getAll();
}
