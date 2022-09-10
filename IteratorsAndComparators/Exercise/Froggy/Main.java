package IteratorsAndComparators.Exercise.Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] ints = Arrays.stream(scan.nextLine().split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        Lake<Integer> lake = new Lake<>(ints);
        Iterator<Integer> iterator = lake.iterator();
        List<String> toPrint = new ArrayList<>();
        while (iterator.hasNext()) {
            toPrint.add(iterator.next()+"");
        }
        System.out.println(String.join(", ",toPrint));
    }
}
