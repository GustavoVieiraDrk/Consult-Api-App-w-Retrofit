package com.gustavo.project_rxjava_retrofit_mark00.Data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class AnimeResult {

    @Json(name = "results")
    private final List<AnimeResponse> ApiData;

    public List<AnimeResponse> getApiData() {
        return ApiData;
    }

    public AnimeResult(List<AnimeResponse> ApiData) {
        this.ApiData = ApiData;
    }
}
