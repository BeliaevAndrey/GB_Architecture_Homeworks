package SingletonPattern;

import java.time.LocalDateTime;

public class Singleton {

    private static LocalDateTime created = null;
    private static Singleton instance = null;

    private Singleton() { }

    public static Singleton createInstance() {
        if (instance == null) {
            instance = new Singleton();
            created = LocalDateTime.now();
        }
        return instance;
    }

    public String getCreated() { return created.toString(); }


}
