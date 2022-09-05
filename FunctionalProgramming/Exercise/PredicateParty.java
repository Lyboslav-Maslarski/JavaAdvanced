package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> partyList = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        BiFunction<List<String>, Predicate<String>, List<String>> doubleFunc = (list, stringPredicate) -> {
            List<String> toAdd = list.stream().filter(stringPredicate).collect(Collectors.toList());
            list.addAll(toAdd);
            return list;
        };
        BiFunction<List<String>, Predicate<String>, List<String>> removeFunc = (list, stringPredicate) -> {
            List<String> toRemove = list.stream().filter(stringPredicate).collect(Collectors.toList());
            list.removeAll(toRemove);
            return list;
        };
        String input = scan.nextLine();
        while (!input.equals("Party!")) {
            String[] command = input.split("\\s+");
            Predicate<String> predicate = getPredicate(command[1], command[2]);
            switch (command[0]) {
                case "Double":
                    doubleFunc.apply(partyList, predicate);
                    break;
                case "Remove":
                    removeFunc.apply(partyList, predicate);
                    break;
            }
            input = scan.nextLine();
        }
        if (partyList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(partyList);
            System.out.println(String.join(", ", partyList) + " are going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String command, String search) {
        Predicate<String> predicate = null;
        switch (command) {
            case "StartsWith":
                predicate = name -> name.startsWith(search);
                break;
            case "EndsWith":
                predicate = name -> name.endsWith(search);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(search);
                break;
        }
        return predicate;
    }
}
