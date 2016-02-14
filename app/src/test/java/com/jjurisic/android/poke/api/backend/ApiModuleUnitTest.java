package com.jjurisic.android.poke.api.backend;

import com.squareup.okhttp.OkHttpClient;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Josip Jurisic
 */
public class ApiModuleUnitTest {

    private ApiModule apiModule;

    @Before
    public void setUp() {
        apiModule = new ApiModule();
    }

    @Test
    public void testBaseUrl() {
        assertEquals("http://pokeapi.co/api/v2", ApiModule.KEY_BASE_URL);
    }

    @Test
    public void testProvideEndpoint() {
        assertNotNull(apiModule.provideEndpoint());
    }

    @Test
    public void testProvideGsonConverter() {
        assertNotNull(apiModule.provideGsonConverter());
    }

    @Test
    public void testProvideOkHttpClient() {
        assertNotNull(apiModule.provideOkHttpClient());
    }

    @Test
    public void testProvideOkClient() {
        assertNotNull(apiModule.provideOkClient(Mockito.mock(OkHttpClient.class)));
    }

    @Test
    public void testProvideRestAdapter() {
        assertNotNull(apiModule.provideRestAdapter(Mockito.mock(Endpoint.class), Mockito.mock(GsonConverter.class), Mockito.mock(OkClient.class)));
    }

    @Test
    public void testProvideMoviesApiService() {
        RestAdapter adapter = apiModule.provideRestAdapter(Mockito.mock(Endpoint.class), Mockito.mock(GsonConverter.class), Mockito.mock(OkClient.class));
        assertNotNull(adapter);
    }
}