package InMemoryModel;

public class Observer2 implements IModelChangedObserver {
    @Override
    public void applyUpdateModel(String msg) {
        System.out.println("New " + msg + " was added - observer #2");
    }
}
