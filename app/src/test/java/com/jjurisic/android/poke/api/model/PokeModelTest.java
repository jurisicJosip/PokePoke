package com.jjurisic.android.poke.api.model;

import com.jjurisic.android.poke.api.backend.ApiService;
import com.jjurisic.android.poke.api.interactor.PokeInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Josip Jurisic
 */
public class PokeModelTest {

    private static final int POKEMON_ID = 5;

    @Mock
    PokeInteractor pokeInteractor;

    @Mock
    ApiService apiService;

    private PokeModel pokeModel;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        pokeModel = new PokeModel(pokeInteractor);
    }

    @Test
    public void testGetPokedex() {
        pokeModel.getPokedex(apiService);
        verify(pokeInteractor).requestPokedex(apiService);
    }

    @Test
    public void testGetPokemon() {
        pokeModel.getPokemon(apiService, POKEMON_ID);
        verify(pokeInteractor).requestPokemon(apiService, POKEMON_ID);
    }
}