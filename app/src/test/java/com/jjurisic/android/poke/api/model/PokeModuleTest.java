package com.jjurisic.android.poke.api.model;

import com.jjurisic.android.poke.api.data.PokeModule;
import com.jjurisic.android.poke.api.interactor.PokeInteractor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Josip Jurisic
 */
public class PokeModuleTest {

    private PokeModule pokeModule;

    @Before
    public void init() {
        pokeModule = new PokeModule();
    }

    @Test
    public void testProvidePokeModel() throws Exception {
        PokeInteractor pokeInteractor = Mockito.mock(PokeInteractor.class);
        assertNotNull(pokeModule.providePokeModel(pokeInteractor));
    }
}