package editor3d.service;

import editor3d.Implements.BusinessLogicalLayer;
import editor3d.Implements.IModelEditor;
import editor3d.models.Model3D;
import editor3d.models.Texture;

import java.util.ArrayList;
import java.util.Collection;

public class ModelEditor implements IModelEditor {


    private BusinessLogicalLayer bll;
    private Model3D model;


    private ArrayList<Texture> textures;

    public ModelEditor(BusinessLogicalLayer bll) {
        if (bll == null) throw new RuntimeException("Undefined project file");
        this.bll = bll;
    }

    public ModelEditor(BusinessLogicalLayer bll, Model3D model) {
        this.bll = bll;
        this.model = model;
        this.textures = (ArrayList<Texture>) model.getTextures();
    }

    @Override
    public void createModel() {
        model = new Model3D();
        saveModel();
    }

    @Override
    public void editModel(int modelNo) {
        this.model = ((ArrayList<Model3D>) bll.getAllModels()).get(modelNo);
        model.setModified(true);
        saveModel();
    }

    @Override
    public boolean saveModel() {
        this.model.setTextures(this.textures);
        bll.addEntity(model);
        return true;
    }

    @Override
    public boolean addTexture(Texture texture) {
        // TODO: place new texture from TextureEditor to texture collection; save()
        return false;
    }

    @Override
    public void removeTexture(int index) {
        textures.remove(index);
    }
}
