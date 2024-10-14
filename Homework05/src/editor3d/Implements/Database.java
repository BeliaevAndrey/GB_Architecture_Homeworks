package editor3d.Implements;

import java.util.Collection;

/**
 * Database interface
 */
public interface Database {

    void load();

    void save();

    Collection<Entity> getAll();

}
