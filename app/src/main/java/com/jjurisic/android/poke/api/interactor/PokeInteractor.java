package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.backend.ApiService;
import com.jjurisic.android.poke.api.data.Pokemon;

import java.util.List;

import rx.Observable;

/**
 * Created by Josip Jurisic
 */
public interface PokeInteractor {

    Observable<List<Pokemon>> requestPokedex(ApiService apiService);

    Observable<Pokemon> requestPokemon(ApiService apiService, long id);

}