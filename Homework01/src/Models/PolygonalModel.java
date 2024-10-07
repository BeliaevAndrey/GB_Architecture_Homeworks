package Models;

import java.util.List;

public class PolygonalModel {

    private List<Polygon> polygons;
    private List<Texture> textures;

    public PolygonalModel(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public PolygonalModel(List<Polygon> polygons, List<Texture> textures) {
        this.polygons = polygons;
        this.textures = textures;
    }
}
