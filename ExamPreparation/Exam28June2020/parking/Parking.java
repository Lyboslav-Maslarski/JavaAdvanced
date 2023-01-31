package ExamPreparation.Exam28June2020.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }
        int year = data.stream().mapToInt(Car::getYear).max().getAsInt();
        return data.stream().filter(car -> car.getYear() == year).findFirst().get();
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findAny().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(type).append(":");
        for (Car car : data) {
            sb.append(System.lineSeparator()).append(car);
        }
        return sb.toString();
    }
}
