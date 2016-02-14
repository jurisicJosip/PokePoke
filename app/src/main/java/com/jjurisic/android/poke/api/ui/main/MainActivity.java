package com.jjurisic.android.poke.api.ui.main;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jjurisic.android.poke.R;
import com.jjurisic.android.poke.api.AppComponent;
import com.jjurisic.android.poke.api.ui.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jurisicJosip.
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.adapter_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initUi();
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {

    }

    protected void initUi() {
        toolbar.setTitle(R.string.app_name);
    }
}