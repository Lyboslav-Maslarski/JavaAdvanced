package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int numberForDivision = Integer.parseInt(scan.nextLine());
        Collections.reverse(list);
        Predicate<Integer> predicate = integer -> integer % numberForDivision != 0;
        System.out.println(list.stream().filter(predicate).map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
