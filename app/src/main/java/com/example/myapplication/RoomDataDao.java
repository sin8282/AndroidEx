package com.example.myapplication;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDataDao {

    @Insert
    void setInsertUser(RoomDataDto user);

    @Update
    void setUpdateUser(RoomDataDto user);

    @Delete
    void setDeleteUser(RoomDataDto user);

    @Query("SELECT * FROM RoomDataDto")
    List<RoomDataDto> getUserAll();

}
