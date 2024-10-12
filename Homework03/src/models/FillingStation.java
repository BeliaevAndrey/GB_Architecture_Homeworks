package models;

import Implements.IFillingStation;

import java.util.ArrayList;
import java.util.Collection;

public class FillingStation implements IFillingStation {

        
        private final int carCapacity;
        private final Collection<FuelType> fuelTypes = new ArrayList<>();

        private Collection<Car> cars;

        public FillingStation(int carCapacity, int fuelTypes) {

            cars = new ArrayList<>();
            this.carCapacity = carCapacity;
            if (fuelTypes > FuelType.values().length) fuelTypes = FuelType.values().length;
            for (FuelType ft : FuelType.values()) {
                this.fuelTypes.add(ft);     // simplified
                fuelTypes--;
                if (fuelTypes == 0) break;
            }

        }

        @Override
        public void doWork() {
            if (cars.isEmpty()) {
                System.out.println("No clients.");
                return;
            }

            for (Car car : cars) {
                fuelCar(car);
            }
        }

        @Override
        public boolean detectFuelType(Car car) {

            if (fuelTypes.contains(car.getFuelType())) return true;
            System.out.println("Fuel type not supported.");

            return false;
        }

        @Override
        public void addCar(Car car) {

            if (!detectFuelType(car)) return;

            if (car.isFueled()) {
                System.out.println("No fuel needed!");
                return;
            }

            if (cars.size() < carCapacity) cars.add(car);
            else System.out.println("No free places.");
        }

        @Override
        public void fuelCar(Car car) {
            if (!car.isFueled()) car.setFueled(true);
            System.out.println("The car is fueled.");
            removeCar(car);
        }

        @Override
        public void removeCar(Car car) {
            for (Car c : cars) {
                if (c.equals(cars)) cars.remove(c);
                System.out.println("The car has left station.");
                return;
            }
        }
}
