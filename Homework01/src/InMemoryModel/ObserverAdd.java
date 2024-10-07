package InMemoryModel;

public class ObserverAdd implements IModelChangedObserver {

    private final String action = "add";
    @Override
    public void applyUpdateModel(String msg) {
        System.out.println("New " + msg + " was added - observer #1");
    }

    @Override
    public String getAction() { return action; }
}
