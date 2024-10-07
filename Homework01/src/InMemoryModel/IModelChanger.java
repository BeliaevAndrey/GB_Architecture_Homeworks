package InMemoryModel;

public interface IModelChanger {

    void notifyChanges(String msg);

    void registerModelChanger(IModelChangedObserver o);
    void removeModelChanger(IModelChangedObserver o);

}
