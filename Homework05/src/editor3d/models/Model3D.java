package editor3d.models;

import editor3d.Implements.Entity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 3D-model
 */
public class Model3D implements Entity {

    private boolean modified = false;
    private static int counter = 10000;

    private final int id;

    private Collection<Texture> textures = new ArrayList<>();

    // initializer
    {
        id = ++counter;
    }

    // region constructors

    public Model3D() {
    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    // endregion

    // region getters and setters

    @Override
    public int getId() {
        return id;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    public void setTextures(Collection<Texture> textures) {
        this.textures = textures;
    }

    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }
// endregion

    @Override
    public String toString() {
        return String.format("3D model #%d", id);
    }
}
