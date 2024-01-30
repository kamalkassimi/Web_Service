package com.example.web_service.Service;

import com.example.web_service.Model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("todos")
    public Call<List<Todo>> getTodo();
    @GET("todos/{id}")
    public  Call<Todo> getID(@Path("id") int id);
}
