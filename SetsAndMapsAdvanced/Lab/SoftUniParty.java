package SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> party = new TreeSet<>();
        String input = scan.nextLine();
        while (!input.equals("PARTY")) {
            party.add(input);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("END")) {
            party.remove(input);
            input = scan.nextLine();
        }
        System.out.println(party.size());
        System.out.println(String.join(System.lineSeparator(), party));
    }
}
