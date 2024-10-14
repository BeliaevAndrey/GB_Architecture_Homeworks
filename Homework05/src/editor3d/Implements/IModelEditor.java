package editor3d.Implements;

import editor3d.models.Model3D;
import editor3d.models.Texture;

public interface IModelEditor {

    Model3D createModel();
    Model3D editModel(Model3D model3D);
    boolean saveModel();
    boolean addTexture(Texture texture);

    void removeTexture(int index);

}
