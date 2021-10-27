package com.gustavo.project_rxjava_retrofit_mark00.Anime.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gustavo.project_rxjava_retrofit_mark00.Data.Model.Anime;
import com.gustavo.project_rxjava_retrofit_mark00.R;
import com.squareup.picasso.Picasso;

public class ShowCharacterDetailsActivity extends AppCompatActivity {

    private Anime anime;
    private TextView txtCharacterName;
    private TextView txtCharacterId;
    private TextView txtCharacterGender;
    private TextView txtCharacterSpecies;
    private TextView txtIsAlive;
    private ImageView character_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details_of_character);

        anime = getIntent().getParcelableExtra("SHOW_CHARACTER_DETAIL");

        setUpViews();
    }

    public void setUpViews(){
        txtCharacterName = findViewById(R.id.character_detail_name);
        txtCharacterId = findViewById(R.id.character_detail_id);
        txtCharacterGender = findViewById(R.id.character_detail_gender);
        txtCharacterSpecies = findViewById(R.id.character_detail_species);
        txtIsAlive = findViewById(R.id.character_detail_isAlive);
        character_image = findViewById(R.id.image_show_detail);


        Picasso.get().load(anime.getCharacterImage()).into(character_image);
        txtCharacterName.setText(anime.getCharacterName());
        txtCharacterId.setText("Id: " + Integer.toString(anime.getId()));
        txtCharacterGender.setText("Gender: " + anime.getGender());
        txtCharacterSpecies.setText("Species: " + anime.getSpecies());
        txtCharacterSpecies.setText(getString(R.string.foo, anime.getSpecies()));
        txtIsAlive.setText("Alive: " + anime.getIsAlive());

    }
}