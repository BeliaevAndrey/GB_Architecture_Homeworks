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
        notifyChanges("add","model");
    }

    public void addCamera(Camera cam) {
        cameras.add(cam);
        notifyChanges("add", "camera");
    }

    public void addFlash(Flash flash) {
        flashes.add(flash);
        notifyChanges("add", "flash");
    }

   public void addScene(Scene scene) {
        scenes.add(scene);
        notifyChanges("add", "scene");
    }


    public void removeModel(PolygonalModel model) {
        models.remove(model);
        notifyChanges("remove","model");
    }

    public void removeCamera(int camId) {
        for (Camera cam : cameras) {
            if (cam.getId() == camId) {
                cameras.remove(cam);
                notifyChanges("remove", "camera " + camId);
            }
        }
    }

    public void removeFlash(int  flashId) {
        for (Flash flash : flashes) {
            if (flash.getId() == flashId) {
                flashes.remove(flash);
                notifyChanges("remove", "flash " + flashId);
            }
        }
    }

    public void removeScene(int  sceneId) {
        for (Scene scene : scenes) {
            if (scene.getId() == sceneId) {
                scenes.remove(scene);
                notifyChanges("remove", "scene " + sceneId);
            }
        }
    }




    @Override
    public void notifyChanges(String act, String msg) {
        for (IModelChangedObserver observer : observers) {
            if (observer.getAction().equals(act)) observer.applyUpdateModel(msg);
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
