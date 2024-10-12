package models;

import Implements.Refueling;

public class RefuelingStation implements Refueling {
    @Override
    public void fuel(FuelType fuel) {
        switch (fuel) {
            case Diesel -> System.out.println("Fueling diesel");
            case Gasoline -> System.out.println("Fueling gasoline");
        }
    }
}
