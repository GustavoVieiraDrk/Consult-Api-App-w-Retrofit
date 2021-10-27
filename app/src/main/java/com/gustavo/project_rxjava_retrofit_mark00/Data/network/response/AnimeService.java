package com.gustavo.project_rxjava_retrofit_mark00.Data.network.response;

import androidx.lifecycle.ReportFragment;

import com.gustavo.project_rxjava_retrofit_mark00.Data.Model.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {
    @GET("character")
    Call<AnimeResult> listRepos();
}
