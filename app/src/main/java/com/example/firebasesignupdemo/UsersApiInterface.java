package com.example.firebasesignupdemo;

import android.view.View;

import com.example.firebasesignupdemo.modle.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersApiInterface {

    @GET("/users")
    Call<List<Users>> getUsers();

}
