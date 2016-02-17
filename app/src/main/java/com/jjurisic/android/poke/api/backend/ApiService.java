package com.jjurisic.android.poke.api.backend;


import com.jjurisic.android.poke.api.model.Pokemon;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by jurisicJosip.
 */
public interface ApiService {

    @GET("/pokemon")
    Observable<List<Pokemon>> requestPokedex();


    @GET("/pokemon/{id}")
    Observable<Pokemon> requestPokemon(@Path("id") long id);
}