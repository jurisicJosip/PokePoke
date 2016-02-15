package com.jjurisic.android.poke;


import android.app.Application;

import com.jjurisic.android.poke.api.backend.ApiModule;

/**
 * Created by Josip Jurisic
 */

public class App extends Application {

    private AppComponent component;

    private static App sInstance;

    public static App get() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }
}