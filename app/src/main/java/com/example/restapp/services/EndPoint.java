package com.example.restapp.services;

import com.example.restapp.entidades.Post;
import com.example.restapp.entidades.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPoint {
    @GET("users")
    Call<List<User>> obterUsuarios();

    @POST("posts")
    Call<Post> criarPost(@Body Post post);
}
