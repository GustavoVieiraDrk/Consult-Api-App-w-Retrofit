package com.gustavo.project_rxjava_retrofit_mark00.Anime.Activities;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gustavo.project_rxjava_retrofit_mark00.Data.Model.Anime;
import com.gustavo.project_rxjava_retrofit_mark00.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeListViewHolder> {

    private List<Anime> animes;
    private OnClickAnime onClickAnime;

    public AnimeAdapter(OnClickAnime onClickAnime) {
        animes = new ArrayList<>();
        this.onClickAnime = onClickAnime;
    }

    public static class AnimeListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageCharacter;
        private TextView txtCharacter;
        private TextView txtSpecies;
        private TextView txtId;
        private TextView txtGender;
        private Anime anime;

        public AnimeListViewHolder(View itemView, OnClickAnime onClickAnime) {
            super(itemView);
            itemView.setOnClickListener(v -> {
                onClickAnime.onClick(anime);

                Intent intent = new Intent(v.getContext(), ShowCharacterDetailsActivity.class)
                        .putExtra("SHOW_CHARACTER_DETAIL", anime);
                v.getContext().startActivity(intent);
            });
            imageCharacter = itemView.findViewById(R.id.character_image);
            txtCharacter = itemView.findViewById(R.id.character_name);
            txtSpecies = itemView.findViewById(R.id.character_species);
            txtGender = itemView.findViewById(R.id.character_gender);
            txtId = itemView.findViewById(R.id.character_id);

        }

        public void bind(Anime animes) {
            txtCharacter.setText(animes.getCharacterName());
            //txtSpecies.setText("Species: " + animes.getSpecies());
            txtId.setText("Id:" + Integer.toString(animes.getId()));
            //txtGender.setText("Gender: " + animes.getGender());
            Picasso.get().load(animes.getCharacterImage()).into(imageCharacter);
            this.anime = animes;

            //txtCharacterRickMortyTitle.setOnClickListener(View);
        }
    }

    public void setContentApi(List<Anime> animes) {
        this.animes = animes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnimeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_character_informations, parent, false);
        return new AnimeListViewHolder(view, onClickAnime);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeAdapter.AnimeListViewHolder holder, int position) {
        //holder.txtCharacterRickMortyTitle.setText(animes.get(position).getTitleAnime());
        holder.bind(animes.get(position));
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

}
