package editor3d.models;

/**
 * A file of project
 */
public class ProjectFile {

    // region private fields

    private final String fileName;
    private final int setting1;
    private final String setting2;
    private boolean setting3;

    // endregion

    // region constructors

    public ProjectFile(String fileName) {

        this.fileName = fileName;

        // load a project properties from file on disk

        setting1 = 1;
        setting2 = "...";
        setting3 = false;

    }

    // endregion

    // region setters and getters

    public String getFileName() {
        return fileName;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }

    public void setSetting3(boolean setting3) {
        this.setting3 = setting3;
    }
// endregion

}
