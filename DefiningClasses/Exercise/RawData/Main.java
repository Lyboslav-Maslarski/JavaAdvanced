package DefiningClasses.Exercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] data = scan.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Car.Engine engine = new Car.Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Car.Cargo cargo = new Car.Cargo(cargoWeight, cargoType);
            List<Car.Tire> tires = new ArrayList<>();
            for (int i = 5; i < data.length; i += 2) {
                double tirePressure = Double.parseDouble(data[i]);
                int tireAge = Integer.parseInt(data[i + 1]);
                Car.Tire tire = new Car.Tire(tirePressure, tireAge);
                tires.add(tire);
            }
            Car car = new Car(model, engine, cargo, tires);
            carList.add(car);
        }
        String searchCommand = scan.nextLine();
        if (searchCommand.equals("fragile")) {
            carList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> car.getTires().stream().mapToDouble(Car.Tire::getTirePressure).min().getAsDouble() < 1)
                    .forEach(System.out::println);
        } else {
            carList.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
