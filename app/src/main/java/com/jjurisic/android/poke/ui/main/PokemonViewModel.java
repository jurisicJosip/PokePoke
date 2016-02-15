package com.jjurisic.android.poke.ui.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.jjurisic.android.poke.api.data.Pokemon;
import com.jjurisic.android.poke.ui.details.PokemonDetailsActivity;

/**
 * Created by Josip Jurisic
 */
public class PokemonViewModel extends BaseObservable {

    private Context context;
    private Pokemon pokemon;

    public PokemonViewModel(Context context, Pokemon pokemon) {
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