package editor3d.service;

import editor3d.Implements.Database;
import editor3d.Implements.Entity;
import editor3d.models.Model3D;
import editor3d.models.ProjectFile;
import editor3d.models.Texture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Database component (The lowest layer)
 * Editor specific database
 */
public class EditorDataBase implements Database {

    private final Random random = new Random();

    private final ProjectFile projectFile;

    private Collection<Entity> entities;

    public EditorDataBase(ProjectFile projectFile) {
        this.projectFile = projectFile;     // define a project file
        load();                             // and then load all entities parameters
    }

    @Override
    public void load() {
        // Load all the entities of project (models, textures etc.)
    }

    @Override
    public void save() {
        // Save current state of all the entities of project
    }

    @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);   // 5 to 10 models
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int countTextures = random.nextInt(3);
        for (int i = 0; i < countTextures; i++) {
            Texture t = new Texture();
            model3D.getTextures().add(t);
            entities.add(t);
        }
        entities.add(model3D);
    }

}
