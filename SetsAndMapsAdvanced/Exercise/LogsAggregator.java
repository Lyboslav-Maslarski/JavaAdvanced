package SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> usersWithTimes = new HashMap<>();
        Map<String, Set<String>> usersWithIPs = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String ip = data[0];
            String user = data[1];
            int time = Integer.parseInt(data[2]);
            usersWithTimes.putIfAbsent(user, 0);
            usersWithTimes.put(user, usersWithTimes.get(user) + time);
            usersWithIPs.putIfAbsent(user, new TreeSet<>());
            usersWithIPs.get(user).add(ip);
        }
        usersWithIPs.forEach((k, v) -> System.out.printf("%s: %d %s%n", k, usersWithTimes.get(k), v));
    }
}
