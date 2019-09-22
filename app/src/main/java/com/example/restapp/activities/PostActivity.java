package com.example.restapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.restapp.R;
import com.example.restapp.entidades.Post;
import com.example.restapp.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        enviarConsultaRest();
    }

    private void enviarConsultaRest() {
        Post post = new Post(1,"teste",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut scelerisque nisi auctor, varius dolor vehicula, varius sapien. Duis aliquet felis tristique tortor ultricies, in accumsan arcu fermentum. Vestibulum quis sollicitudin leo. Nulla molestie semper massa quis lobortis. In lacus leo, ultrices suscipit sem quis, suscipit volutpat mi. Vivamus iaculis, magna at ullamcorper euismod," +
                        " felis libero aliquet mi, id pharetra tortor nibh posuere erat. Integer convallis luctus hendrerit. Proin vestibulum, massa a venenatis facilisis, libero quam lobortis libero, sed pellentesque felis magna et nisl. Aenean vitae finibus magna. ");
        RetrofitService.getServico().criarPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int cod = response.code();
                int id = response.body().getId();
                TextView textViewid = findViewById(R.id.textViewNovoIdCriado);
                TextView textViewcod = findViewById(R.id.textViewCodigodeRetorno);

                textViewcod.setText(String.valueOf(cod));
                textViewid.setText(""+id);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
