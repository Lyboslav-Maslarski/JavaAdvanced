package DefiningClasses.Exercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Engine> engines = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);
            if (data.length == 2) {
                Engine engine = new Engine(model, power);
                engines.add(engine);
            } else if (data.length == 3) {
                if (data[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(data[2]);
                    Engine engine = new Engine(model, power, displacement);
                    engines.add(engine);
                } else {
                    String efficiency = data[2];
                    Engine engine = new Engine(model, power, efficiency);
                    engines.add(engine);
                }
            } else {
                int displacement = Integer.parseInt(data[2]);
                String efficiency = data[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engines.add(engine);
            }
        }
        n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            String engine = data[1];
            Engine currentEngine = engines.stream().filter(engine1 -> engine1.getModel().equals(engine)).collect(Collectors.toList()).get(0);
            if (data.length == 2) {
                Car car = new Car(model, currentEngine);
                carList.add(car);
            } else if (data.length == 3) {
                if (data[2].matches("\\d+")) {
                    int weight = Integer.parseInt(data[2]);
                    Car car = new Car(model, currentEngine, weight);
                    carList.add(car);
                } else {
                    String color = data[2];
                    Car car = new Car(model, currentEngine, color);
                    carList.add(car);
                }
            } else {
                int weight = Integer.parseInt(data[2]);
                String color = data[3];
                Car car = new Car(model, currentEngine, weight, color);
                carList.add(car);
            }
        }
        carList.forEach(System.out::println);
    }
}
