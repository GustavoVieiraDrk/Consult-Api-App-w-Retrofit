package com.gustavo.project_rxjava_retrofit_mark00.Data.network.response;

import com.squareup.moshi.Json;

public class AnimeResponse {

    @Json(name = "id")
    private final int id;

    @Json(name = "name")
    private final String titleAnime;

    @Json(name = "status")
    private final String stillAlive;

    @Json(name = "species")
    private final String race;

    @Json(name = "gender")
    private final String sex;


    @Json(name = "image")
    private final String characterImage;

    public AnimeResponse(String titleAnime, String stillAlive, String race, String sex, int id, String characterImage) {
        this.titleAnime = titleAnime;
        this.stillAlive = stillAlive;
        this.race = race;
        this.sex = sex;
        this.id = id;
        this.characterImage = characterImage;
    }

    public String getTitleAnime() {
        return titleAnime;
    }

    public String getStillAlive() {
        return stillAlive;
    }

    public String getRace() {
        return race;
    }

    public String getSex() {
        return sex;
    }

    public int getId() {
        return id;
    }

    public String getCharacterImage() {
        return characterImage;
    }
}
