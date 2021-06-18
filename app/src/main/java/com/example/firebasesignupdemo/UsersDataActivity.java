package com.example.firebasesignupdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.firebasesignupdemo.adapter.UsersRecyclerAdapter;
import com.example.firebasesignupdemo.modle.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersDataActivity extends AppCompatActivity {

    RecyclerView main_recyclerview;

    private UsersRecyclerAdapter UsersRecyclerAdapter;
    UsersApiInterface UsersApiInterface;
//    List<Users> model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_data);

        main_recyclerview = findViewById(R.id.main_recyclerview);
        main_recyclerview.setLayoutManager(new LinearLayoutManager(UsersDataActivity.this));

        UsersApiInterface = UsersRetrofitInstance.getRetrofitInstance().create(UsersApiInterface.class);

        UsersApiInterface.getUsers().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                Data(response.body());
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

            }
        });

    }

    private void Data(List<Users> body) {

        UsersRecyclerAdapter = new UsersRecyclerAdapter(body,getApplicationContext());
        main_recyclerview.setAdapter(UsersRecyclerAdapter);

    }

}
