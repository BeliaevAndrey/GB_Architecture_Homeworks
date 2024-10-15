package editor3d.Implements;

import editor3d.models.Texture;

public interface ITextureEditor {

    void createTexture();
    void editTexture();
    void saveTexture();

    boolean removeTexture(int i);
}
