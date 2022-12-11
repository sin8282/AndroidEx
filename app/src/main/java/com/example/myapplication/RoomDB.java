package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RoomDataDto.class}, version = 1) // Dto가 추가되거나 변경될거를 생각해서 버전으로 관리를 한다.
public abstract class RoomDB extends RoomDatabase {
    public abstract RoomDataDao roomDataDao();
}
