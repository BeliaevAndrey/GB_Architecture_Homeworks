package editor3d.Implements;

import editor3d.models.Model3D;
import editor3d.models.Texture;

public interface IModelEditor {

    void createModel();
    void editModel(int modelNo);
    boolean saveModel();

    boolean removeModel(int i);

}
