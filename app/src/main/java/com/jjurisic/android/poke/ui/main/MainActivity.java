package com.jjurisic.android.poke.ui.main;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.jjurisic.android.poke.App;
import com.jjurisic.android.poke.AppComponent;
import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.api.backend.ResponseListener;
import com.jjurisic.android.poke.api.data.DaggerPokeComponent;
import com.jjurisic.android.poke.api.data.DataManager;
import com.jjurisic.android.poke.api.data.PokeModule;
import com.jjurisic.android.poke.api.model.Pokemon;
import com.jjurisic.android.poke.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jurisicJosip.
 */
public class MainActivity extends BaseActivity implements ResponseListener<List<Pokemon>> {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.adapter_view)
    RecyclerView recyclerView;

    @Inject
    DataManager dataManager;

    private PokemonListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUi();
        requestPokemons();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        DaggerPokeComponent.builder()
                .appComponent(appComponent)
                .pokeModule(new PokeModule())
                .build().inject(this);
    }

    protected void initUi() {
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        adapter = new PokemonListAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void requestPokemons() {
        dataManager.getPokedex(this);
    }

    @Override
    public void onResponse(List<Pokemon> data) {
        adapter.setData(data);
    }

    @Override
    public void onError(Object error) {
        Toast.makeText(App.get(), error.toString(), Toast.LENGTH_LONG).show();
    }
}