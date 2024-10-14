package editor3d.service;

import editor3d.Implements.BusinessLogicalLayer;
import editor3d.Implements.Database;
import editor3d.Implements.DatabaseAccess;
import editor3d.Implements.UILayer;
import editor3d.models.Model3D;
import editor3d.models.ProjectFile;
import editor3d.models.Texture;

import java.util.ArrayList;

public class Editor3D implements UILayer {

    private ProjectFile projectFile;

    private BusinessLogicalLayer businessLogicalLayer;

    private DatabaseAccess databaseAccess;

    private Database database;


    private void init() {
        database = new EditorDataBase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }


    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        init();
    }

    @Override
    public void showProjectSettings() {

        // Precondition
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("filename: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");

    }

    private void checkProjectFile() {
        if (projectFile == null) throw new RuntimeException("Undefined project file");
    }

    @Override
    public void saveProject() {

        // Precondition
        checkProjectFile();

        database.save();    // synchronize changes to DB
        System.out.println("Changes to project are saved successfully.");
    }

    @Override
    public void printAllModels() {

        // Precondition
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {

        // Precondition
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }

    }

    @Override
    public void renderAll() {

        // Precondition
        checkProjectFile();

        System.out.println("Wait...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = System.currentTimeMillis();
        System.out.printf("Rendering operation took %d ms\n", (endTime - startTime));
    }

    @Override
    public void renderModel(int i) {

        // Precondition
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size()) throw new RuntimeException("Incorrect model number");
        System.out.println("Wait...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = System.currentTimeMillis();
        System.out.printf("Rendering operation took %d ms\n", (endTime - startTime));

    }
}
