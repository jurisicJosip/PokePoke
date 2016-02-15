package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.data.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public interface PokeInteractor {

    Observable<List<Pokemon>> requestPokedex();

    Observable<Pokemon> requestPokemon(long id);

}