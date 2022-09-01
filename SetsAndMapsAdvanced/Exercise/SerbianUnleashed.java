package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z]+ ?[A-Za-z]* ?[A-Za-z]*) @(?<city>[A-Za-z]+ ?[A-Za-z]* ?[A-Za-z]*) (?<price>\\d+) (?<count>\\d+)");
        Map<String, Map<String, Integer>> citiesWithArtistsAndProfit = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String artistName = matcher.group("name");
                String city = matcher.group("city");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));
                citiesWithArtistsAndProfit.putIfAbsent(city, new LinkedHashMap<>());
                citiesWithArtistsAndProfit.get(city).putIfAbsent(artistName, 0);
                citiesWithArtistsAndProfit.get(city).put(artistName, citiesWithArtistsAndProfit.get(city).get(artistName) + (price * count));
            }
            input = scan.nextLine();
        }
        citiesWithArtistsAndProfit.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet().stream().sorted((artist1, artist2) -> artist2.getValue().compareTo(artist1.getValue()))
                    .forEach(entry -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
        });
    }
}
