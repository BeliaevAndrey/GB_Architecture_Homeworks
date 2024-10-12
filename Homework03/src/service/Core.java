package service;

import builder.HarvesterBuilder;
import builder.SportCarBuilder;
import models.Car;
import models.FillingStation;
import models.Harvester;
import models.SportCar;

import java.util.ArrayList;
import java.util.Collection;

public class Core {

    private static int counter = 0;
    private final Collection<Harvester> harvesters;
    private final Collection<SportCar> sportCars;
    private final HarvesterBuilder harvesterBuilder;
    private final SportCarBuilder sportCarBuilder;
    private final FillingStation fillingStation;

    public Core() {
        harvesterBuilder = new HarvesterBuilder();
        sportCarBuilder = new SportCarBuilder();
        harvesters = new ArrayList<>();
        sportCars = new ArrayList<>();
        fillingStation = new FillingStation(6, 2);
    }

    public void buildSportCars(int amount) {
        for (int i = amount; i > 0; i--) {
            sportCars.add(sportCarBuilder.buildCar());
        }
    }

    public void buildHarvesters(int amount) {
        for (int i = amount; i > 0; i--) {
            harvesters.add(harvesterBuilder.buildCar());
        }
    }

    private void register(Car car) {

        switch (car.getType()) {
            case Truck -> car.setVehicleRegistrationPlate(String.format("Trck %04d", ++counter));
            case Sport -> car.setVehicleRegistrationPlate(String.format("Sprt %04d", ++counter));
            default -> car.setVehicleRegistrationPlate(String.format("Othr %04d", ++counter));
        }
    }

    private void fuelCar(Car car) {
        fillingStation.addCar(car);
        fillingStation.doWork();
    }

    private void checkAllMoves() {
        for (Car car : sportCars) {
            if (!car.isMoving()) goCar(car);
        }

        for (Car car : harvesters) {
            if (!car.isMoving()) goCar(car);
        }
    }

    public void goCar(Car car) {
        if (!car.isFueled()) fuelCar(car);
        if (car.isFueled()) car.movement();
    }
    public void goCars() {

        for (Car car : harvesters) {
            if (car.isMoving()) continue;
            if (car.getVehicleRegistrationPlate() == null) register(car);
            if (!car.isFueled()) fuelCar(car);
            if (car.isFueled()) car.movement();
        }

        for (Car car : sportCars) {
            if (car.isMoving()) continue;
            if (car.getVehicleRegistrationPlate() == null) register(car);
            if (!car.isFueled()) fuelCar(car);
            if (car.isFueled()) car.movement();
        }

        checkAllMoves();
    }

    public void reportCars() {
        harvesters.forEach(Car::reportCar);
        sportCars.forEach(Car::reportCar);
    }

}
