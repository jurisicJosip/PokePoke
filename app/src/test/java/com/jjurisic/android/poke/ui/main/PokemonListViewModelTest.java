package com.jjurisic.android.poke.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.jjurisic.android.poke.api.model.Pokemon;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Josip Jurisic
 */
public class PokemonListViewModelTest {

    private static final String TEST_NAME = "name";

    private Context context;
    private Pokemon pokemon;

    private PokemonListViewModel pokemonListViewModel;

    @Before
    public void init() {
        context = Mockito.mock(Context.class);
        pokemon = new Pokemon();

        pokemonListViewModel = new PokemonListViewModel(context, pokemon);
    }

    @Test
    public void testGetPokemonName() throws Exception {
        pokemon.setName(TEST_NAME);
        assertEquals(pokemon.getName(), TEST_NAME);
    }

    @Test
    public void testOnPokemonClick() throws Exception {
        View.OnClickListener onClickListener = pokemonListViewModel.onPokemonClick();
        assertNotNull(onClickListener);
        onClickListener.onClick(Mockito.mock(View.class));
        verify(context).startActivity(any(Intent.class));
    }
}