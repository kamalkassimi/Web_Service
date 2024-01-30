package com.example.web_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.web_service.Model.Todo;
import com.example.web_service.Service.ApiService;

import java.util.List;

import okhttp3.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    protected ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        ArrayAdapter<Todo> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getTodo().enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(@NonNull retrofit2.Call<List<Todo>> call, @NonNull Response<List<Todo>> response) {
                adapter.addAll( response.body());
                listView.setAdapter(adapter);
                Toast.makeText(MainActivity.this, "successfully", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(retrofit2.Call<List<Todo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}