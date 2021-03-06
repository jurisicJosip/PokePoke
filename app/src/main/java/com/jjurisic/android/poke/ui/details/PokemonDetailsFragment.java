package com.jjurisic.android.poke.ui.details;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jjurisic.android.poke.App;
import com.jjurisic.android.poke.AppComponent;
import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.api.backend.ResponseListener;
import com.jjurisic.android.poke.api.data.DaggerPokeComponent;
import com.jjurisic.android.poke.api.data.DataManager;
import com.jjurisic.android.poke.api.data.PokeModule;
import com.jjurisic.android.poke.api.model.Pokemon;
import com.jjurisic.android.poke.databinding.FragmentPokemonDetailsBinding;
import com.jjurisic.android.poke.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jurisicJosip.
 */
public class PokemonDetailsFragment extends BaseFragment implements ResponseListener<Pokemon> {

    //Bundle keys
    private static final String KEY_POKEMON_ID = "key_pokemon_id";

    //Ui widgets
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private FragmentPokemonDetailsBinding binding;

    //Data
    private long pokemonId;

    @Inject
    DataManager dataManager;

    public static BaseFragment newInstance(long pokemonId) {
        Bundle b = new Bundle();
        b.putLong(KEY_POKEMON_ID, pokemonId);
        PokemonDetailsFragment f = new PokemonDetailsFragment();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        setHasOptionsMenu(true);

        Bundle args = getArguments();
        if (args != null) {
            if (args.containsKey(KEY_POKEMON_ID)) {
                pokemonId = args.getLong(KEY_POKEMON_ID);
            }
        }
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerPokeComponent.builder()
                .appComponent(appComponent)
                .pokeModule(new PokeModule())
                .build().inject(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        prepareUi(view);
    }

    @Override
    protected void prepareUi(@NonNull View view) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareData();
    }

    @Override
    protected void prepareData() {
        dataManager.getPokemon(pokemonId, this);
    }

    @Override
    public void onResponse(Pokemon data) {
        binding.setPokemonDetailsViewModel(new PokemonDetailsViewModel(data));
    }

    @Override
    public void onError(Object error) {
        Toast.makeText(App.get(), error.toString(), Toast.LENGTH_LONG).show();
    }
}