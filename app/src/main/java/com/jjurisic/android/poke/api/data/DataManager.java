package com.jjurisic.android.poke.api.data;

import android.support.annotation.NonNull;

import com.jjurisic.android.poke.api.backend.ResponseListener;
import com.jjurisic.android.poke.api.model.Pokemon;
import com.jjurisic.android.poke.api.interactor.PokeInteractor;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Josip Jurisic
 */
public class DataManager {

    private PokeInteractor pokeInteractor;

    public DataManager(@NonNull PokeInteractor pokeInteractor) {
        this.pokeInteractor = pokeInteractor;
    }

    public void getPokedex(@NonNull final ResponseListener<List<Pokemon>> listener) {
        pokeInteractor.requestPokedex()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Pokemon>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onError(error);
                    }

                    @Override
                    public void onNext(List<Pokemon> pokemons) {
                        listener.onResponse(pokemons);
                    }
                });
    }

    public void getPokemon(long pokemonId, @NonNull final ResponseListener<Pokemon> listener) {
        pokeInteractor.requestPokemon(pokemonId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<Pokemon>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable error) {
                        listener.onError(error);
                    }

                    @Override
                    public void onNext(Pokemon pokemon) {
                        listener.onResponse(pokemon);
                    }
                });
    }
}