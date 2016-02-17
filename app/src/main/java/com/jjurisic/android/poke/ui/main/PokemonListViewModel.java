package com.jjurisic.android.poke.ui.main;

import android.content.Context;
import android.view.View;

import com.jjurisic.android.poke.api.model.Pokemon;
import com.jjurisic.android.poke.ui.details.PokemonDetailsActivity;

/**
 * Created by Josip Jurisic
 */
public class PokemonListViewModel {

    private Context context;
    private Pokemon pokemon;

    public PokemonListViewModel(Context context, Pokemon pokemon) {
        this.context = context;
        this.pokemon = pokemon;
    }

    public String getPokemonName() {
        return pokemon.getName();
    }

    public View.OnClickListener onPokemonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPokemonDetailsActivity();
            }
        };
    }

    private void startPokemonDetailsActivity() {
        context.startActivity(PokemonDetailsActivity.getLaunchIntent(context, pokemon.getId()));
    }
}