package com.linda.mvvmex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main_Activity";

    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //각자의 앱에 저장하는 곳 예) 장바구니, 노래 담기, 등등
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "db-cos")
        //데이터베이스 cos가 생성되고 repository에 연결되어있음.
        .fallbackToDestructiveMigration()// 스키마의 버전 변경 가능
                .allowMainThreadQueries() //메인스레드에서 DB에 IO를 가능하게 해준다.
                .build();

        userRepository = db.userRepository();
        
        User user = new User("JOOHO", "CHOI");
        userRepository.insert(user);

        Log.d(TAG, "onCreate: 데이터가 잘 저장 되었습니다");

        List<User> users = userRepository.findAll();


        User userEntity = userRepository.findById(1);
        Log.d(TAG, "onCreate: "+userEntity);
    }
}