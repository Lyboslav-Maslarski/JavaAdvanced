package DefiningClasses.Exercise.RawData;

import java.util.List;

public class Car {
    static class Engine {
        private int engineSpeed;
        private int enginePower;

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }

    static class Cargo {
        private int cargoWeight;
        private String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

    static class Tire {
        private double tirePressure;
        private int tireAge;

        public Tire(double tirePressure, int tireAge) {
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }

        public double getTirePressure() {
            return tirePressure;
        }
    }

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
