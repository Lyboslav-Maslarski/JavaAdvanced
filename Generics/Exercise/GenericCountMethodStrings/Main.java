package Generics.Exercise.GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Box<String>> boxes = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            Box<String> box = new Box<>(scan.nextLine());
            boxes.add(box);
        }
        String boxToCompare = scan.nextLine();
        System.out.println(Box.greater(boxes, boxToCompare));
    }
}
