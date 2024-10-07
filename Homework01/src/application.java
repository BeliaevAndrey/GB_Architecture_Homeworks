import InMemoryModel.ModelStore;
import InMemoryModel.Observer1;
import Models.Polygon;
import Models.PolygonalModel;

import java.util.ArrayList;
import java.util.List;

public class application {
    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();

        ModelStore store = new ModelStore();
        store.registerModelChanger(observer1);

        List<Polygon> polygons = new ArrayList<>(){{
            new Polygon(1);
            new Polygon(2);
            new Polygon(3);
        }};

        PolygonalModel polygonalModel = new PolygonalModel(polygons);

        store.addModel(polygonalModel);

    }
}
