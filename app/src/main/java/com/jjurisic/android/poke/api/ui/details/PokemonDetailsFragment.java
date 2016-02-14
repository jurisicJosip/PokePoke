package com.jjurisic.android.poke.api.ui.details;


import android.content.Context;
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

import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.api.AppComponent;
import com.jjurisic.android.poke.api.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jurisicJosip.
 */
public class PokemonDetailsFragment extends BaseFragment {

    //Bundle keys
    private static final String KEY_POKEMON_ID = "key_pokemon_id";

    //Ui widgets
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    //Data
    private long pokemonId;

    public static BaseFragment newInstance(long movieId) {
        Bundle b = new Bundle();
        b.putLong(KEY_POKEMON_ID, movieId);
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
//        DaggerMovieDetailsComponent.builder()
//                .appComponent(appComponent)
//                .moviesDetailsModule(new MoviesDetailsModule(this, getContext()))
//                .build()
//                .inject(this);
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
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false);
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
    }

}