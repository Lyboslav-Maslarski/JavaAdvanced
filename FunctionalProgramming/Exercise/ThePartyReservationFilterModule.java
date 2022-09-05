package FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> partyList = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scan.nextLine();
        Set<String> filters = new HashSet<>();
        while (!input.equals("Print")) {
            String[] command = input.split(";");
            String filter = command[1] + ":" + command[2];
            if (command[0].equals("Add filter")) {
                filters.add(filter);
            } else {
                filters.remove(filter);
            }
            input = scan.nextLine();
        }
        for (String filter : filters) {
            String[] currentFilter = filter.split(":");
            Predicate<String> predicate = getPredicate(currentFilter[0], currentFilter[1]);
            List<String> toRemove = partyList.stream().filter(predicate).collect(Collectors.toList());
            partyList.removeAll(toRemove);
        }
        System.out.println(String.join(" ", partyList));
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        Predicate<String> predicate = null;
        switch (type) {
            case "Starts with":
                predicate = name -> name.startsWith(parameter);
                break;
            case "Ends with":
                predicate = name -> name.endsWith(parameter);
            case "Contains":
                predicate = name -> name.contains(parameter);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(parameter);
                break;
        }
        return predicate;
    }
}
