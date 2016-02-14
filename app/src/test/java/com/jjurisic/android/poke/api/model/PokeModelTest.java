package com.jjurisic.android.poke.api.model;

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

    private PokeModel pokeModel;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        pokeModel = new PokeModel(pokeInteractor);
    }

    @Test
    public void testGetPokedex() throws Exception {
        pokeModel.getPokedex();
        verify(pokeInteractor).requestPokedex();
    }

    @Test
    public void testGetPokemon() throws Exception {
        pokeModel.getPokemon(POKEMON_ID);
        verify(pokeInteractor).requestPokemon(POKEMON_ID);
    }
}