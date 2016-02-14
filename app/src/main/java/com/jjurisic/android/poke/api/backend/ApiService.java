package com.jjurisic.android.poke.api.backend;


import com.jjurisic.android.poke.api.data.Pokedex;
import com.jjurisic.android.poke.api.data.Pokemon;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by jurisicJosip.
 */
public interface ApiService {

    @GET("/")
    Observable<Pokedex> requestPokedex();


    @GET("/{id}")
    Observable<Pokemon> requestPokemon(@Path("id") long id);
}