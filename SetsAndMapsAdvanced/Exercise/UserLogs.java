package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, Integer>> usersWithIPsAndMassageCount = new TreeMap<>();
        while (!input.equals("end")) {
            String[] data = input.split("\\s+");
            String ipAddress = data[0].substring(3);
            String user = data[2].substring(5);
            usersWithIPsAndMassageCount.putIfAbsent(user, new LinkedHashMap<>());
            usersWithIPsAndMassageCount.get(user).putIfAbsent(ipAddress, 0);
            usersWithIPsAndMassageCount.get(user).put(ipAddress, usersWithIPsAndMassageCount.get(user).get(ipAddress) + 1);
            input = scan.nextLine();
        }
        usersWithIPsAndMassageCount.forEach((user, ipAddresses) -> {
            System.out.println(user + ":");
            int counter = 0;
            for (Map.Entry<String, Integer> entry : ipAddresses.entrySet()) {
                counter++;
                if (counter < ipAddresses.size()) {
                    System.out.print(entry.getKey() + " => " + entry.getValue() + ", ");
                } else {
                    System.out.println(entry.getKey() + " => " + entry.getValue() + ".");
                }
            }
        });
    }
}
