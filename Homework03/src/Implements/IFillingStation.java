package Implements;

import models.Car;
import models.FuelType;

import java.util.ArrayList;
import java.util.Collection;

public interface IFillingStation {

    void doWork();
    boolean detectFuelType(Car car);
    void addCar(Car car);
    void fuelCar(Car car);
    void removeCar(Car car);

}
