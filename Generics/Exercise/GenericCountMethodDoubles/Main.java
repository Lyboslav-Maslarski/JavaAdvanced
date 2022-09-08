package Generics.Exercise.GenericCountMethodDoubles;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Box<Double>> boxes = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            Box<Double> box = new Box<>(Double.parseDouble(scan.nextLine()));
            boxes.add(box);
        }
        Double boxToCompare = Double.valueOf(scan.nextLine());
        System.out.println(Box.greater(boxes, boxToCompare));
    }
}
