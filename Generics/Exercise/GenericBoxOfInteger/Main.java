package Generics.Exercise.GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            Box<Integer> str = new Box<>(Integer.parseInt(scan.nextLine()));
            System.out.println(str);
        }
    }
}
