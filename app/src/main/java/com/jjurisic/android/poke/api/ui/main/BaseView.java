package com.jjurisic.android.poke.api.ui.main;

import android.support.annotation.NonNull;

/**
 * Created by jurisicJosip.
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showMessage(@NonNull String message);

}