package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.backend.ApiService;
import com.jjurisic.android.poke.api.model.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public class PokeInteractorImpl implements PokeInteractor {

    private ApiService apiService;

    public PokeInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Pokemon>> requestPokedex() {
        return apiService.requestPokedex();
    }

    @Override
    public Observable<Pokemon> requestPokemon(long id) {
        return apiService.requestPokemon(id);
    }
}