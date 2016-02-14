package com.jjurisic.android.poke.api.ui.main;

import android.support.annotation.NonNull;

import com.jjurisic.android.poke.api.data.Pokemon;

import java.util.List;

/**
 * Created by jurisicJosip.
 */
public interface MainView extends BaseView {

    void showPokemons(@NonNull List<Pokemon> pokemonList);

    void showPokemonDetails(long id);

    void showProgress();

    void hideProgress();

}