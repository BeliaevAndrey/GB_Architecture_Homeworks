package builder;

import Implements.CarBuilder;
import models.Color;
import models.FuelType;
import models.GearboxType;
import models.SportCar;

public class SportCarBuilder implements CarBuilder {

    // region common default field

    //  common Car brand
    private String brand = "The Brand";

    // default Car color
    private Color color = Color.Red;

    // default Number of wheels
    private int wheelsCount = 3;

    // default Car Model
    private String model = "Sport 3";

    // default engine capacity
    private double engineCapacity = 4.0;

    // Fuel type
    private FuelType fuelType = FuelType.Gasoline;

    private GearboxType gearboxType = GearboxType.MT;

    // endregion


    @Override
    public SportCar buildCar() {
        SportCar sportCar = new SportCar(brand, model, color);
        sportCar.setEngineCapacity(engineCapacity);
        sportCar.setWheelsCount(wheelsCount);
        sportCar.setFuelType(fuelType);
        sportCar.setGearboxType(gearboxType);
        return sportCar;
    }

    // region setters

    @Override
    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public void setColor(Color color) { this.color = color; }

    @Override
    public void setWheelsCount(int wheelsCount) { this.wheelsCount = wheelsCount; }

    @Override
    public void setGearbox(GearboxType gbType) { this.gearboxType = gbType; }

    @Override
    public void setModel(String model) { this.model = model; }

    @Override
    public void setEngineCapacity(double engineCapacity) { this.engineCapacity = engineCapacity; }

    @Override
    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }

    // endregion



}
