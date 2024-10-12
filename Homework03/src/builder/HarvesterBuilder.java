package builder;

import Implements.CarBuilder;
import models.Color;
import models.FuelType;
import models.GearboxType;
import models.Harvester;

public class HarvesterBuilder implements CarBuilder {

    // region private default fields

    //  common Car brand
    private String brand = "The Brand";

    // default Car color
    private Color color = Color.Orange;

    // default Number of wheels
    private int wheelsCount = 6;

    // default Car Model
    private String model = "Harvester 5.2";

    // default engine capacity
    private double engineCapacity = 5.2;

    // Fuel type
    private FuelType fuelType = FuelType.Diesel;

    private GearboxType gearboxType = GearboxType.AT;

    // endregion

    @Override
    public Harvester buildCar() {
        Harvester harvester = new Harvester(brand, model, color);
        harvester.setEngineCapacity(engineCapacity);
        harvester.setWheelsCount(wheelsCount);
        harvester.setFuelType(fuelType);
        harvester.setGearboxType(gearboxType);
        return harvester;

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
