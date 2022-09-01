package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }
        continents.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((k, v) -> System.out.printf("%s -> %s%n", k, String.join(", ", v)));
        });
    }
}
