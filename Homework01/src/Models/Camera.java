package Models;

public class Camera {

    private final int id;
    private Point3D location;
    private Angle3D angle;

    public Camera(int id, Point3D location, Angle3D angle) {
        this.id = id;
        this.location = location;
        this.angle = angle;
    }

    public Camera(int id) {
        this.id = id;
    }

    public void Rotate(Angle3D angle) { this.angle = angle; }
    public void Move(Point3D location) { this.location = location; }


}
