package models;

public class FlyCar extends Car {

    public FlyCar(String brand, String model, Color color) {
        super(CarType.Sedan, brand, model, color);
    }

    public void fly() {
        System.out.println("Car is flying!");
    }

    @Override
    public void maintenance() {

    }

    @Override
    public void movement() {
        fly();
    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }
}
