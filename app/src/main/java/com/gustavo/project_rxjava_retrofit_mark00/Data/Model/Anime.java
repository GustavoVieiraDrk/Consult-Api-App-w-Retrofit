package com.gustavo.project_rxjava_retrofit_mark00.Data.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Anime implements Parcelable {

    private final int id;
    private final String characterName;
    private final String isAlive;
    private final String species;
    private final String gender;
    private final String characterImage;

    public Anime(String characterName, String isAlive, String species, String gender, int id, String characterImage) {
        this.characterName = characterName;
        this.isAlive = isAlive;
        this.species = species;
        this.gender = gender;
        this.id = id;
        this.characterImage = characterImage;
    }

    protected Anime(Parcel in) {
        id = in.readInt();
        characterName = in.readString();
        isAlive = in.readString();
        species = in.readString();
        gender = in.readString();
        characterImage = in.readString();
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getIsAlive() {
        return isAlive;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getCharacterImage() {
        return characterImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(characterName);
        dest.writeString(isAlive);
        dest.writeString(species);
        dest.writeString(gender);
        dest.writeString(characterImage);
    }
}

