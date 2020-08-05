package com.linda.mvvmex01;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {User.class}, version = 2) //엄격해서 컬럼 추가 하고 나면 version 바꿔줘야 하더라구요
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserRepository userRepository();


}
