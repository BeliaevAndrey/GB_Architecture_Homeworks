package Models;

public class Texture {
    private final int id;
    private String name;

    public Texture(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public String getName() { return name; }
}
