package com.jjurisic.android.poke.api.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

/**
 * Created by Josip Jurisic
 */

public class Pokemon extends BaseObservable {

    @Bindable
    private long id;

    private String url;

    @Bindable
    private String name;

    @Bindable
    private int height;

    @Bindable
    private int width;

    public int getId() {
        try {
            String[] tokens = TextUtils.split(url, "/");
            String id = TextUtils.isEmpty(tokens[tokens.length - 1]) ? tokens[tokens.length - 2] : tokens[tokens.length - 1];
            return Integer.parseInt(id);
        } catch (Exception e) {
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}