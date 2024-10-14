package editor3d.service;

import editor3d.Implements.BusinessLogicalLayer;
import editor3d.Implements.IModelEditor;
import editor3d.models.Model3D;
import editor3d.models.Texture;

import java.util.ArrayList;
import java.util.Collection;

public class ModelEditor implements IModelEditor {


    private BusinessLogicalLayer bll;
    private final Model3D model;

    private ArrayList<Texture> textures;

    public ModelEditor(BusinessLogicalLayer bll) {
        this.bll = bll;
        this.model = createModel();
    }

    public ModelEditor(Model3D model) {
        this.model = model;
        this.textures = (ArrayList<Texture>) model.getTextures();
    }

    @Override
    public Model3D createModel() {
        return new Model3D();
    }

    @Override
    public Model3D editModel(Model3D model) {
        return null;
    }

    @Override
    public boolean saveModel() {
        this.model.setTextures(this.textures);
        bll.getAllModels().add(model);
        return true;
    }

    @Override
    public boolean addTexture(Texture texture) {
        return false;
    }

    @Override
    public void removeTexture(int index) {
        textures.remove(index);
    }
}
