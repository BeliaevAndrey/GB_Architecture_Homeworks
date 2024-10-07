package Models;

public class Flash {

    private final int id;
    private Point3D location;
    private Angle3D angle;
    private final Color color;
    private float power;

    public Flash(int id, Point3D location, Angle3D angle, Color color, float power) {
        this.id = id;
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash(int id, Color color, float power) {
        this.id = id;
        this.color = color;
    }

    public int getId() { return id; }

    public void Rotate(Angle3D angle) { this.angle = angle; }
    public void Move(Point3D location) { this.location = location; }

    public Point3D getLocation() { return location; }

    public Angle3D getAngle() { return angle; }

    public Color getColor() { return color; }

    public float getPower() { return power; }

    public void setPower(float power) { this.power = power; }
}
