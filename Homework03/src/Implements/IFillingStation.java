package Implements;

import models.Car;
import models.FuelType;

import java.util.ArrayList;
import java.util.Collection;

public interface IFillingStation {


    int carsCapacity = 0;   // amount of cars simultaneously
    Collection<FuelType> fuelTypes = new ArrayList<>(); // supported fuel types
    Collection<Car> cars = new ArrayList<>();

    void doWork();
    boolean detectFuelType(Car car);
    void addCar(Car car);
    void fuelCar(Car car);
    void removeCar(Car car);

}
