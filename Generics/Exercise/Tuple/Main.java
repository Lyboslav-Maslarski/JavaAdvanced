package Generics.Exercise.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Tuple<String, String, String> tuple1 = new Tuple<>();
        tuple1.setFirst(input[0] + " " + input[1]);
        tuple1.setSecond(input[2]);
        tuple1.setThird(input[3]);
        input = scan.nextLine().split("\\s+");
        Tuple<String, String, String> tuple2 = new Tuple<>();
        tuple2.setFirst(input[0]);
        tuple2.setSecond(input[1]);
        tuple2.setThird(input[2].equals("drunk") ? "true" : "false");
        input = scan.nextLine().split("\\s+");
        Tuple<String, Double, String> tuple3 = new Tuple<>();
        tuple3.setFirst(input[0]);
        tuple3.setSecond(Double.valueOf(input[1]));
        tuple3.setThird(input[2]);
        System.out.println(tuple1.getFirst() + " -> " + tuple1.getSecond() + " -> " + tuple1.getThird());
        System.out.println(tuple2.getFirst() + " -> " + tuple2.getSecond() + " -> " + tuple2.getThird());
        System.out.println(tuple3.getFirst() + " -> " + tuple3.getSecond() + " -> " + tuple3.getThird());

    }
}
