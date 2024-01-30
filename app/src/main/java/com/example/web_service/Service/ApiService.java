package com.example.web_service.Service;

import com.example.web_service.Model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService {
    @GET("todos")
    public Call<List<Todo>> getTodo();

}
