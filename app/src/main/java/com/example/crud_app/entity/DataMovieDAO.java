package com.example.crud_app.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao

public interface DataMovieDAO {
    @Insert
    Long insertData(DataMovie dataMovie);

    @Query("Select * from movie_db")
    List<DataMovie> getData();

    @Update
    int updateData(DataMovie item);

    @Delete
    void deleteData(DataMovie item);

}
