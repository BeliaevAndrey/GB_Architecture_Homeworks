package editor3d.models;

import editor3d.Implements.Entity;

/**
 * Some texture
 */
public class Texture implements Entity {

    private static int counter = 5000;
    private final int id;

    {
        id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%d", id);
    }
}
