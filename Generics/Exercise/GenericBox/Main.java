package Generics.Exercise.GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Box<String> str = new Box<>(scan.nextLine());
            System.out.println(str);
        }
    }
}
