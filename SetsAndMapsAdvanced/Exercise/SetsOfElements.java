package SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        int[] setsLength = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < setsLength[0]; i++) {
            int num = Integer.parseInt(scan.nextLine());
            set1.add(num);
        }
        for (int i = 0; i < setsLength[1]; i++) {
            int num = Integer.parseInt(scan.nextLine());
            set2.add(num);
        }
        set1.retainAll(set2);
        set1.forEach(integer -> System.out.print(integer + " "));
        /*while (!set1.isEmpty()) {
            int firstNum = set1.iterator().next();
            set1.remove(firstNum);
            if (set2.contains(firstNum)) {
                System.out.print(firstNum + " ");
            }
        }*/
    }
}
