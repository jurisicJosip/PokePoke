package com.jjurisic.android.poke.api;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Josip Jurisic
 */
public class AppModuleTest {

    private AppModule appModule;

    @Before
    public void setUp() throws Exception {
        appModule = new AppModule(Mockito.mock(Application.class));
    }

    @Test
    public void testProvideApplication() throws Exception {
        assertNotNull(appModule.provideApplication());
    }
}