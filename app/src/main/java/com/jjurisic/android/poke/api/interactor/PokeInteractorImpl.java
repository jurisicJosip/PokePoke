package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.App;
import com.jjurisic.android.poke.api.data.Pokedex;
import com.jjurisic.android.poke.api.data.Pokemon;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public class PokeInteractorImpl implements PokeInteractor {

    @Override
    public Observable<Pokedex> requestPokedex() {
        return App.get().component().getApiService().requestPokedex();
    }

    @Override
    public Observable<Pokemon> requestPokemon(long id) {
        return App.get().component().getApiService().requestPokemon(id);
    }
}