package models;

public abstract class Car {

    // region Constructors

    public Car(CarType type, String mark, String model, Color color) {
        this.brand = mark;
        this.model = model;
        this.color = color;
        this.type = type;
    }


    // endregion


    // region Public Methods

    // Movement
    public abstract void maintenance();

    // Maintenance
    public abstract void movement();

    public void stop() {
        isMoving = false;
    }

    public boolean startCheck() {
        if (VehicleRegistrationPlate == null) {
            System.out.println("The car needs to be registered. Set Vehicle registration plate.");
            return false;
        }
        if (!isMaintained()) {
            System.out.println("The car needs a maintenance.");
            return false;
        }

        if (!isFueled) {
            System.out.println("The car needs fuel.");
            return false;
        }
        return true;
    }

    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }

    public void setGearboxType(GearboxType gearboxType) { this.gearboxType = gearboxType; }

    // Gear shift
    public abstract boolean gearShifting();

    // Headlights on/off
    public abstract boolean switchHeadlights();

    // Wipers on/off
    public abstract boolean switchWipers();

    // Fog lights on/off
    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
    }

    protected boolean isMaintained() { return maintained; }

    public void setWheelsCount(int wheelsCount) {
        if (this.wheelsCount == 0)
            this.wheelsCount = wheelsCount;
        else System.out.println("Wheels count is already set");
    }

    public void setEngineCapacity(double vol)
    {
        if (this.engineCapacity == 0) this.engineCapacity = vol;
        else System.out.println("Engine Capacity already is set");
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public String getBrand() { return brand; }

    public String getModel() { return model; }

    public FuelType getFuelType() { return fuelType; }

    public double getEngineCapacity() { return engineCapacity; }

    public CarType getType() { return type; }

    public boolean isFueled() { return isFueled; }

    public void setFueled(boolean fueled) { isFueled = fueled; }

    public void reportCar() {
        String report = String.format(
                """
                        Car type: %s
                        Brand: %s
                        Model: %s
                        Engine Capacity: %.2f
                        Now moving: %s
                        Is fueled: %s
                        Registration plate: %s""",
                getType(), getBrand(), getModel(), getEngineCapacity(), isMoving(),
                isFueled(),  getVehicleRegistrationPlate());
        System.out.println("=".repeat(40));
        System.out.println(report);
        System.out.println("=".repeat(40));
    }

    public void setVehicleRegistrationPlate(String vehicleRegistrationPlate) {
        if (VehicleRegistrationPlate == null) VehicleRegistrationPlate = vehicleRegistrationPlate;
        else System.out.println("The car has id-number already.");
    }

    public String getVehicleRegistrationPlate() { return VehicleRegistrationPlate; }

    public boolean isMoving() { return isMoving; }

    protected void setMoving(boolean moving) { isMoving = moving; }

    // endregion

    // region Private fields

    private String VehicleRegistrationPlate = null;

    // Car brand
    private final String brand;

    // Car Model
    private final String model;

    // Car color
    private final Color color;

    // Car type
    private final CarType type;

    // Number of wheels
    private int wheelsCount = 0;

    // Fuel type
    private FuelType fuelType;

    // Gearbox type
    private GearboxType gearboxType;

    // engine volume
    protected double engineCapacity = 0;

    // Fog lights
    private boolean fogLights = false;

    // Need maintenance
    private boolean maintained = true;

    private boolean isFueled = false;

    private boolean isMoving = false;

    // endregion



}
