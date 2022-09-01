package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String registration = input.split(", ")[1];
            if (direction.equals("IN")) {
                parking.add(registration);
            } else {
                parking.remove(registration);
            }
            input = scan.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parking));
        }
    }
}