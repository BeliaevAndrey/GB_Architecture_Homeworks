package Models;

import java.util.List;

public class Polygon {

    private final int id;
    private List<Point3D> points;

    public Polygon(int id) {
        this.id = id;
    }

    public Polygon(int id, List<Point3D> points) {
        this.id = id;
        this.points = points;
    }
}
