package InMemoryModel;

public class ObserverRmv implements IModelChangedObserver {

    private final String action = "remove";

    public String getAction() { return action; }

    @Override
    public void applyUpdateModel(String msg) {
        System.out.println(msg + " was removed - observer #2");
    }
}
