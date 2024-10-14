package editor3d.Implements;

/**
 * UI interaction interface
 * User-Interface layer
 */
public interface UILayer {

    void openProject(String FileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

}
