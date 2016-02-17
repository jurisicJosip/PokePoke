package com.jjurisic.android.poke.api.data;


import com.jjurisic.android.poke.AppComponent;
import com.jjurisic.android.poke.api.di.ActivityScope;
import com.jjurisic.android.poke.ui.details.PokemonDetailsFragment;
import com.jjurisic.android.poke.ui.main.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = PokeModule.class)
public interface PokeComponent {

    void inject(MainActivity pokemonViewModel);

    void inject(PokemonDetailsFragment fragment);

}