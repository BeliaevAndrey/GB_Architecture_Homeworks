import InMemoryModel.ModelStore;
import InMemoryModel.ObserverAdd;
import InMemoryModel.ObserverRmv;
import Models.*;

import java.util.ArrayList;
import java.util.List;

public class application {
    public static void main(String[] args) {

        ObserverAdd observer1 = new ObserverAdd();
        ObserverRmv observer2 = new ObserverRmv();

        ModelStore store = new ModelStore();
        store.registerModelChanger(observer1);
        store.registerModelChanger(observer2);

        List<Polygon> polygons = new ArrayList<>(){{
            new Polygon(1);
            new Polygon(2);
            new Polygon(3);
        }};


        PolygonalModel polygonalModel = new PolygonalModel(polygons);

        store.addModel(polygonalModel);

        store.addCamera(new Camera(1));
        store.addFlash(new Flash(1, new Color(255, 255, 255), 100));
        store.addFlash(new Flash(2, new Color(200, 10, 10), 100));

        store.removeFlash(1);

    }
}
