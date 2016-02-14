package com.jjurisic.android.poke.api.model;

import com.jjurisic.android.poke.api.data.Pokedex;
import com.jjurisic.android.poke.api.data.Pokemon;
import com.jjurisic.android.poke.api.interactor.PokeInteractor;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public class PokeModel {

    private PokeInteractor pokeInteractor;

    public PokeModel(PokeInteractor pokeInteractor) {
        this.pokeInteractor = pokeInteractor;
    }

    public Observable<Pokedex> getPokedex() {
        return pokeInteractor.requestPokedex();
    }

    public Observable<Pokemon> getPokemon(long id) {
        return pokeInteractor.requestPokemon(id);
    }
}