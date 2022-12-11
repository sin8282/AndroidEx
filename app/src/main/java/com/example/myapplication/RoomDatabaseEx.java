package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class RoomDatabaseEx extends AppCompatActivity {
    private RoomDataDao roomDataDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database);

        RoomDB database = Room.databaseBuilder(getApplicationContext(), RoomDB.class, "shinDatabase")
                .fallbackToDestructiveMigration() // 데이터베이스 버전 변경 관리
                .allowMainThreadQueries()   // IO입출력 가능
                .build();

        // 인서트
        roomDataDao = database.roomDataDao();
        RoomDataDto dataDto = new RoomDataDto();
        dataDto.setName("김빵빵");
        dataDto.setAge("29");
        dataDto.setPhoneNumber("1010101010");

        roomDataDao.setInsertUser(dataDto);

         //업데이트
        RoomDataDto dataDto2 = new RoomDataDto();
        dataDto2.setId(1);
        dataDto2.setName("김응애");
        dataDto2.setAge("1");
        dataDto2.setPhoneNumber("8732098902");

        roomDataDao.setUpdateUser(dataDto2);


    }
}