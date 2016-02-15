package com.jjurisic.android.poke.ui.main;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.jjurisic.android.poke.App;
import com.jjurisic.android.poke.AppComponent;
import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.api.data.Pokemon;
import com.jjurisic.android.poke.api.model.DaggerPokeComponent;
import com.jjurisic.android.poke.api.model.PokeModel;
import com.jjurisic.android.poke.api.model.PokeModule;
import com.jjurisic.android.poke.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jurisicJosip.
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.adapter_view)
    RecyclerView recyclerView;

    @Inject
    PokeModel pokeModel;

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
        pokeModel.getPokedex(App.get().component().getApiService())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Pokemon>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(App.get(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<Pokemon> pokemons) {
                        adapter.setData(pokemons);
                    }
                });
    }
}