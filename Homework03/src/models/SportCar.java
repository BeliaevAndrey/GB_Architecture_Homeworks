package models;

public class SportCar extends Car {


    public SportCar(String brand, String model, Color color) {
        super(CarType.Sport, brand, model, color);
    }


    @Override
    public void maintenance() {
        if (this.isMaintained()) {
            System.out.println("The car is maintained.");
            return;
        }
        System.out.println("The car needs maintenance.");
        System.out.println("....");
        System.out.println("The car is maintained.");
    }

    @Override
    public void movement() {
        if (startCheck()) {
            setMoving(true);
            System.out.println("The car is moving");
        }
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

    @Override
    public void setEngineCapacity(double vol) {
        super.setEngineCapacity(vol);
    }
}
