package com.gustavo.project_rxjava_retrofit_mark00.Anime.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.gustavo.project_rxjava_retrofit_mark00.Data.Maper.AnimeMapper;
import com.gustavo.project_rxjava_retrofit_mark00.Data.Model.Anime;
import com.gustavo.project_rxjava_retrofit_mark00.Data.network.response.AnimeApi;
import com.gustavo.project_rxjava_retrofit_mark00.Data.network.response.AnimeResult;
import com.gustavo.project_rxjava_retrofit_mark00.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnClickAnime{

    private RecyclerView recyclerAnimeList;
    private AnimeAdapter animeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView txtCharacterRickMortyTitle = findViewById(R.id.anime_title);

        setupAdapter();
        setupApi();

    }

    private void setupAdapter() {
        recyclerAnimeList = findViewById(R.id.recyclerList);

        animeAdapter = new AnimeAdapter(this);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerAnimeList.setLayoutManager(linearLayoutManager);
        recyclerAnimeList.setAdapter(animeAdapter);
    }

    private void setupApi() {
        AnimeApi.getInstance().listRepos().enqueue(new Callback<AnimeResult>() {
            @Override
            public void onResponse(Call<AnimeResult> call, Response<AnimeResult> response) {
                if (response.isSuccessful()) {
                    animeAdapter.setContentApi(AnimeMapper.responseToDomain(response.body().getApiData()));
                }
            }
            @Override
            public void onFailure(Call<AnimeResult> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(Anime anime) {

    }
}