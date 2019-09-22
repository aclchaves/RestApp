package com.example.restapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.restapp.R;
import com.example.restapp.entidades.User;
import com.example.restapp.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo = findViewById(R.id.viewJSON);
        buscaDados();

    }

    private void buscaDados() {
        RetrofitService.getServico().obterUsuarios().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> lista = response.body();
                for (User user : lista) {
                    campo.append("\n\nid: " +user.getId()+
                            "\nNome: "+ user.getName()+
                            "\nUsername: "+ user.getUsername()+
                            "\nemail: "+ user.getEmail()+
                            "\nWebsite: "+ user.getWebsite());
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("RestApp", t.getStackTrace().toString());
            }
        });
    }

    public void navegar(View view) {
        startActivity(new Intent(this, PostActivity.class));
    }
}
