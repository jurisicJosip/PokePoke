package com.jjurisic.android.poke.ui.details;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.AppComponent;
import com.jjurisic.android.poke.ui.base.BaseActivity;

/**
 * Created by jurisicJosip.
 */
public class PokemonDetailsActivity extends BaseActivity {

    //Bundle keys
    private static final String KEY_POKEMON_ID = "key_pokemon_id";

    public static Intent getLaunchIntent(@NonNull Context from, long pokemonId) {
        Intent intent = new Intent(from, PokemonDetailsActivity.class);
        intent.putExtra(KEY_POKEMON_ID, pokemonId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(KEY_POKEMON_ID)) {
            long pokemonId = extras.getLong(KEY_POKEMON_ID);
            replaceFragment(R.id.fragment_container, PokemonDetailsFragment.newInstance(pokemonId), false);
        } else {
            throw new IllegalArgumentException("You must provide PokemonId in bundle");
        }
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        //ok nothing
    }
}