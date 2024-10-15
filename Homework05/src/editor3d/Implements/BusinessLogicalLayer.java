package editor3d.Implements;

import editor3d.models.Model3D;
import editor3d.models.Texture;

import java.util.Collection;

/**
 * BLL (Business-logic layer)
 * Business-logic layer interaction interface
 */
public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    void addEntity(Entity entity);
    boolean removeEntity(Entity entity);

}
