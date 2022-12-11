package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity //Room에서 지원하는 어노테이션
public class RoomDataDto {

    @PrimaryKey(autoGenerate = true) // autoGenerate : 카운팅되면서 알아서 관리하게 해준다
    private int id = 0;
    private String name;
    private String age;
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
