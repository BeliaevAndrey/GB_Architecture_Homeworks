package InMemoryModel;

public interface IModelChanger {

    void notifyChanges(String act, String msg);

    void registerModelChanger(IModelChangedObserver o);
    void removeModelChanger(IModelChangedObserver o);

}
