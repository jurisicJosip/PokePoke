package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.data.Pokedex;
import com.jjurisic.android.poke.api.data.Pokemon;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public interface PokeInteractor {

    Observable<Pokedex> requestPokedex();

    Observable<Pokemon> requestPokemon(long id);

}