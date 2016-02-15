package com.jjurisic.android.poke.api.model;

import com.jjurisic.android.poke.api.data.Pokemon;
import com.jjurisic.android.poke.api.interactor.PokeInteractor;

import java.util.List;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public class PokeModel {

    private PokeInteractor pokeInteractor;

    public PokeModel(PokeInteractor pokeInteractor) {
        this.pokeInteractor = pokeInteractor;
    }

    public Observable<List<Pokemon>> getPokedex() {
        return pokeInteractor.requestPokedex();
    }

    public Observable<Pokemon> getPokemon(long id) {
        return pokeInteractor.requestPokemon(id);
    }
}