package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        while (n-- > 0) {
            String username = scan.nextLine();
            usernames.add(username);
        }
        System.out.println(String.join(System.lineSeparator(), usernames));
    }
}
