package com.jjurisic.android.poke;


import com.jjurisic.android.poke.api.backend.ApiModule;
import com.jjurisic.android.poke.api.backend.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Josip Jurisic
 */

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class
})

public interface AppComponent {

    void inject(App app);

    ApiService getApiService();
}