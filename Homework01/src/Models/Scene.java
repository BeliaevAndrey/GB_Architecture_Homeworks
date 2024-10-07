package Models;

import java.util.List;

public class Scene {
    private final int id;
    private List<PolygonalModel> models;
    private List<Flash> flashes;

    public Scene(int id, List<PolygonalModel> models, List<Flash> flashes) {
        this.id = id;
        this.models = models;
        this.flashes = flashes;
    }


    public Scene(int id) { this.id = id; }

    // methods

    public void method1() { }
    public void method2() { }

    // setters and getters
    public List<PolygonalModel> getModels() { return models; }

    public void setModels(List<PolygonalModel> models) { this.models = models; }

    public List<Flash> getFlashes() { return flashes; }

    public void setFlashes(List<Flash> flashes) { this.flashes = flashes; }

    public int getId() { return id; }
}
