package com.gustavo.project_rxjava_retrofit_mark00.Data.network.response;

import android.os.strictmode.InstanceCountViolation;

import com.gustavo.project_rxjava_retrofit_mark00.Data.Model.Anime;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class AnimeApi {

    public static AnimeService INSTANCE;

    public static AnimeService getInstance() {
        if (INSTANCE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/api/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
            INSTANCE = retrofit.create(AnimeService.class);
        }
        return INSTANCE;
    }
}
