package DefiningClasses.Exercise.CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s"
                , this.model, this.power, this.displacement == 0 ? "n/a" : String.valueOf(this.displacement), this.efficiency);
    }
}
