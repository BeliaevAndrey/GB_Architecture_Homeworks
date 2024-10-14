package editor3d.Implements;

import editor3d.models.Texture;

public interface ITextureEditor {

    Texture createTexture();
    Texture editTexture(Texture texture);
    boolean saveTexture();

}
