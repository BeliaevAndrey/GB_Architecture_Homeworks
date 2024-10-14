package editor3d.service;

import editor3d.Implements.ITextureEditor;
import editor3d.models.Texture;

import java.util.Collection;


public class TextureEditor implements ITextureEditor {


    @Override
    public Texture createTexture() {
        return new Texture();
    }

    @Override
    public Texture editTexture(Texture texture) {
        texture.setModified(true);
        return texture;
    }

    @Override
    public boolean saveTexture() {
        return false;
    }

}
