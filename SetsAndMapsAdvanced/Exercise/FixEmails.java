package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        Map<String, String> usernamesWithEmail = new LinkedHashMap<>();
        while (!username.equals("stop")) {
            String email = scan.nextLine();
            String domain = email.substring(email.length() - 3).toLowerCase();
            if (domain.equals(".us") || domain.equals(".uk") || domain.equals("com")) {
                username = scan.nextLine();
                continue;
            } else {
                usernamesWithEmail.put(username, email);
            }
            username = scan.nextLine();
        }
        usernamesWithEmail.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
