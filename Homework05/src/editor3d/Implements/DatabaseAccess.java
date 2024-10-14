package editor3d.Implements;

import editor3d.models.Model3D;
import editor3d.models.Texture;

import java.util.Collection;

/**
 * DataAccess layer (DAC)
 * Interface for interaction with DB
 * (see materials on transactions (DB).)
 */
public interface DatabaseAccess {
    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}
