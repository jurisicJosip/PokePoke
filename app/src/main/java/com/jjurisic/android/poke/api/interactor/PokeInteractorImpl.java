package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.backend.ApiService;
import com.jjurisic.android.poke.api.data.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public class PokeInteractorImpl implements PokeInteractor {

    @Override
    public Observable<List<Pokemon>> requestPokedex(ApiService apiService) {
        return apiService.requestPokedex();
    }

    @Override
    public Observable<Pokemon> requestPokemon(ApiService apiService, long id) {
        return apiService.requestPokemon(id);
    }
}