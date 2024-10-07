package InMemoryModel;

import Models.Camera;
import Models.Flash;
import Models.PolygonalModel;
import Models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger{

    private List<IModelChangedObserver> observers = new ArrayList<>();

    private List<PolygonalModel> models = new ArrayList<>();
    private List<Scene>  scenes  = new ArrayList<>();

    private List<Flash>  flashes = new ArrayList<>();

    private List<Camera> cameras = new ArrayList<>();


    public Scene getScene(int id) {
        for (Scene scene : scenes) {
            if (scene.getId() == id ) return scene;
        }
        throw new IllegalArgumentException("Scene " + id + " not found");
    }

    public void addModel(PolygonalModel model) {
        models.add(model);
        notifyChanges("model");
    }


    @Override
    public void notifyChanges(String msg) {
        for (IModelChangedObserver observer : observers) {
            observer.applyUpdateModel(msg);
        }
    }

    @Override
    public void registerModelChanger(IModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void removeModelChanger(IModelChangedObserver o) {
        observers.remove(o);
    }
}
