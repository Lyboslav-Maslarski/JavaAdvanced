package ExamPreparation.Exam20February2021.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }
        OptionalInt max = data.stream().mapToInt(Car::getYear).max();
        return data.stream().filter(car -> car.getYear() == max.getAsInt()).findAny().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model))
                .findAny().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(" The cars are in a car ExamPreparation.Exam20February2021.dealership ");
        sb.append(name).append(":");
        data.forEach(car -> sb.append(System.lineSeparator()).append(car));
        return sb.toString();
    }
}
