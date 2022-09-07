package DefiningClasses.Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int numberOfCars = Integer.parseInt(scan.nextLine());
        while (numberOfCars-- > 0) {
            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];
            double fuelAmount = Integer.parseInt(carData[1]);
            double fuelCostFor1km = Double.parseDouble(carData[2]);
            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            cars.put(model, car);
        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            String model = command[1];
            Car car = cars.get(model);
            int amountOfKm = Integer.parseInt(command[2]);
            boolean hasMoved = car.drive(amountOfKm);
            if (!hasMoved) {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scan.nextLine();
        }
        cars.values().forEach(car -> System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTraveled()));
    }
}
