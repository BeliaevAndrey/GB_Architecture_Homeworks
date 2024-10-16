package editor3d.service;

import editor3d.Implements.BusinessLogicalLayer;
import editor3d.Implements.DatabaseAccess;
import editor3d.Implements.Entity;
import editor3d.models.Model3D;
import editor3d.models.Texture;

import java.util.Collection;
import java.util.Random;

/**
 * Implementation of BLL-interface
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private final DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void addEntity(Entity entity) {
        databaseAccess.addEntity(entity);
    }

    @Override
    public boolean removeEntity(Entity entity) {
        return databaseAccess.removeEntity(entity);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            processRender(model);
        }
    }

    Random rnd = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - rnd.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
