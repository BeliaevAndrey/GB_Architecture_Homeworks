package Models;

public class Color {
    private final String id;
    private final int red;
    private final int green;
    private final int blue;

    private int is_valid(int val) {
        if (val < 0 || val > 255) throw new IllegalArgumentException("Wrong color range (must be 0..255)");
        return val;
    }

    public Color(int red, int green, int blue) {
        this.red = is_valid(red);
        this.green = is_valid(green);
        this.blue = is_valid(blue);
        this.id = String.format("#%02x%02x%02x", red, green, blue);
    }

    public String getId() { return id; }

}
