package SetsAndMapsAdvanced.Exercise;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Long>> countriesWithCitiesWithPopulation = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("report")) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Integer.parseInt(data[2]);
            countriesWithCitiesWithPopulation.putIfAbsent(country, new LinkedHashMap<>());
            countriesWithCitiesWithPopulation.get(country).put(city, population);
            input = scan.nextLine();
        }
        countriesWithCitiesWithPopulation.entrySet().stream()
                .sorted((country1, country2) ->
                        Long.compare(country2.getValue().values().stream().mapToLong(e -> e).sum(), country1.getValue().values().stream().mapToLong(e -> e).sum()))
                .forEach(entry -> {
                    System.out.printf("%s (total population: %d)%n", entry.getKey(), entry.getValue().values().stream().mapToLong(e -> e).sum());
                    entry.getValue().entrySet().stream().sorted((city1, city2) -> Long.compare(city2.getValue(), city1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
