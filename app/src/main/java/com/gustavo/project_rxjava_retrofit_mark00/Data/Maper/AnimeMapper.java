package com.gustavo.project_rxjava_retrofit_mark00.Data.Maper;

import com.gustavo.project_rxjava_retrofit_mark00.Data.Model.Anime;
import com.gustavo.project_rxjava_retrofit_mark00.Data.network.response.AnimeResponse;

import java.util.ArrayList;
import java.util.List;

public class AnimeMapper {
    public static List<Anime> responseToDomain(List<AnimeResponse> animeResponseList) {
        List<Anime> animeList = new ArrayList<>();

        for (AnimeResponse animeResponse : animeResponseList) {
            final Anime anime = new Anime(animeResponse.getTitleAnime(),
                    animeResponse.getStillAlive(),
                    animeResponse.getRace(),
                    animeResponse.getSex(),
                    animeResponse.getId(),
                    animeResponse.getCharacterImage());
            animeList.add(anime);
        }
        return animeList;
    }
}
