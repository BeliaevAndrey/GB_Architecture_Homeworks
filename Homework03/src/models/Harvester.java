package models;

import Implements.Fueling;
import Implements.Wiping;

public class Harvester extends Car implements Fueling, Wiping {


    public Harvester(String brand, String model, Color color) {
        super(CarType.Truck, brand, model, color);
    }

    public void sweeping() {
        System.out.println("The car is sweeping street.");
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
            System.out.println("The car moves.");
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



    // region Cleaning

    @Override
    public void wipeMirrors() {

    }

    @Override
    public void wipeWindshield() {

    }

    @Override
    public void wipeHeadlights() {

    }

    // endregion

    @Override
    public void fuel() {

    }
}
