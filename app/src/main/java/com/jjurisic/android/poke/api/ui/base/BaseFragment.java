package com.jjurisic.android.poke.api.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jjurisic.android.poke.api.App;
import com.jjurisic.android.poke.api.AppComponent;


/**
 * Created by jurisicJosip.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setupComponent(App.get().component());
    }

    protected abstract void setupComponent(AppComponent appComponent);

    protected abstract void prepareUi(@NonNull View view);

    protected abstract void prepareData();
}