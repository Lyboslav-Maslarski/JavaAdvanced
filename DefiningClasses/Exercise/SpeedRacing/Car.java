package DefiningClasses.Exercise.SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public boolean drive(int amountOfKm) {
        double fuelNeeded = amountOfKm * fuelCostFor1km;
        if (fuelNeeded <= fuelAmount) {
            fuelAmount -= fuelNeeded;
            distanceTraveled += amountOfKm;
            return true;
        } else {
            return false;
        }
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
