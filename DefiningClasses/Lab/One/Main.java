package DefiningClasses.Lab.One;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());
        while (count-- > 0) {
            String[] carData = scan.nextLine().split("\\s+");
            String brand = carData[0];
            String model = carData[1];
            int horsePower = Integer.parseInt(carData[2]);
            Car car = new Car(brand, model, horsePower);
            System.out.println(car.carInfo());
        }
    }
}
