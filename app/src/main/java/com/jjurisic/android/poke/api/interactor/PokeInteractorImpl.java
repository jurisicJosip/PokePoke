package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.App;
import com.jjurisic.android.poke.api.data.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public class PokeInteractorImpl implements PokeInteractor {

    @Override
    public Observable<List<Pokemon>> requestPokedex() {
        return App.get().component().getApiService().requestPokedex();
    }

    @Override
    public Observable<Pokemon> requestPokemon(long id) {
        return App.get().component().getApiService().requestPokemon(id);
    }
}