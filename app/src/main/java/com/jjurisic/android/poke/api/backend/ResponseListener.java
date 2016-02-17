package com.jjurisic.android.poke.api.backend;


/**
 * Created by jurisicJosip.
 */
public interface ResponseListener<T> {

    void onResponse(T data);

    void onError(Object error);

}