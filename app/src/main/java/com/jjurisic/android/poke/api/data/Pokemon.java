package com.jjurisic.android.poke.api.data;

/**
 * Created by Josip Jurisic
 */
public class Pokemon {

    private long id;

    private String name;

    private int height;

    private int width;

    public long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}