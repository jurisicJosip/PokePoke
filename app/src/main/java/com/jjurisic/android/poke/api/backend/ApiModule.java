package com.jjurisic.android.poke.api.backend;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Josip Jurisic
 */
@Module
public class ApiModule {

    static final String KEY_BASE_URL = "http://pokeapi.co/api/v2";

    @Provides
    @Singleton
    public Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(KEY_BASE_URL);
    }

    @Provides
    @Singleton
    public GsonConverter provideGsonConverter() {
        Gson gson = new GsonBuilder().create();
        return new GsonConverter(gson);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public OkClient provideOkClient(OkHttpClient client) {
        return new OkClient(client);
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter(Endpoint endpoint, GsonConverter gsonConverter, OkClient okClient) {
        return new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setClient(okClient)
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setConverter(gsonConverter)
                .build();
    }

    @Provides
    @Singleton
    public ApiService provideApiService(RestAdapter restAdapter) {
        return restAdapter.create(ApiService.class);
    }
}