package com.jjurisic.android.poke.api.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Josip Jurisic
 */
public class Pokedex {

    @SerializedName("pokemon")
    private List<Pokemon> pokemons;

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "pokemons=" + pokemons +
                '}';
    }
}