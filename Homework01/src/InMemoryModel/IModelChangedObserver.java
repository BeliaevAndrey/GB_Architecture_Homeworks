package InMemoryModel;

public interface IModelChangedObserver {

    public void applyUpdateModel(String msg);

    public String getAction();

}
