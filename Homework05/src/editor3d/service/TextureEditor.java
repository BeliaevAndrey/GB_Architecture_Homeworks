package editor3d.service;

import editor3d.Implements.BusinessLogicalLayer;
import editor3d.Implements.ITextureEditor;
import editor3d.models.Texture;

import java.util.ArrayList;

public class TextureEditor implements ITextureEditor {

    BusinessLogicalLayer bll;

    Texture texture;

    public TextureEditor(BusinessLogicalLayer bll) {
        if (bll == null) throw new RuntimeException("Undefined project file.");
        this.bll = bll;
    }

    @Override
    public void createTexture() {
        texture = new Texture();
        saveTexture();
    }

    @Override
    public void editTexture() {
        texture.setModified(true);
        saveTexture();
    }

    @Override
    public void saveTexture() {
        bll.addEntity(texture);
    }

    public boolean removeTexture(int i) {
        Texture textureToRm = ((ArrayList<Texture>) bll.getAllTextures()).get(i);
        return bll.removeEntity(textureToRm);
    }

}
