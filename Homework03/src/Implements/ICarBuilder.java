package Implements;

import models.Car;
import models.Color;
import models.FuelType;
import models.GearboxType;

public interface ICarBuilder {

    void setBrand(String brand);


    void setModel(String model);

    void setWheelsCount(int wheelsCount);

    void setGearbox(GearboxType gbType);

    void setEngineCapacity(double engineCapacity);

    void setFuelType(FuelType fuelType);

    void setColor(Color color);

    Car buildCar();


}
