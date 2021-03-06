/*
 *
 *  *
 *  *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *  *
 *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  * you may not use this file except in compliance with the License.
 *  *  * You may obtain a copy of the License at
 *  *  *
 *  *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *  *
 *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  * See the License for the specific language governing permissions and
 *  *  * limitations under the License.
 *  *
 *
 */

package com.jjurisic.android.poke.api.data;


import com.jjurisic.android.poke.App;
import com.jjurisic.android.poke.api.interactor.PokeInteractor;
import com.jjurisic.android.poke.api.interactor.PokeInteractorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PokeModule {

    @Provides
    public PokeInteractor providePokeInteractor() {
        return new PokeInteractorImpl(App.get().component().getApiService());
    }

    @Provides
    public DataManager providePokeModel(PokeInteractor pokeInteractor) {
        return new DataManager(pokeInteractor);
    }
}