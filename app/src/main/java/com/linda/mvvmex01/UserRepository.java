package com.linda.mvvmex01;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserRepository {

    //select할 때만 쿼리 적고 나머지 insert, update, delete어노테이션 걸면 됨.

    @Query("SELECT * FROM user")
    List<User> findAll();

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user where uid = :uid")
    User findById(int uid);






}
