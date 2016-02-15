package com.jjurisic.android.poke.api.interactor;

import com.jjurisic.android.poke.api.backend.ApiService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Josip Jurisic
 */
public class PokeInteractorImplTest {

    private static final int POKEMON_ID = 8;
    @Mock
    ApiService apiService;

    private PokeInteractor pokeInteractor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        pokeInteractor = new PokeInteractorImpl();
    }

    @Test
    public void testRequestPokedex() {
        pokeInteractor.requestPokedex(apiService);
        verify(apiService).requestPokedex();
    }

    @Test
    public void testRequestPokemon() {
        pokeInteractor.requestPokemon(apiService, POKEMON_ID);
        verify(apiService).requestPokemon(POKEMON_ID);
    }
}