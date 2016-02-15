package com.jjurisic.android.poke.ui.details;

import com.jjurisic.android.poke.api.data.Pokemon;

/**
 * Created by Josip Jurisic
 */
public class PokemonDetailsViewModel {

    private Pokemon pokemon;

    public PokemonDetailsViewModel(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getPokemonName() {
        return pokemon.getName();
    }

    public String getPokemonWidth() {
        return String.valueOf(pokemon.getWidth());
    }

    public String getPokemonHeight() {
        return String.valueOf(pokemon.getHeight());
    }
}