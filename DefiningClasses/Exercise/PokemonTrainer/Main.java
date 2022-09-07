package DefiningClasses.Exercise.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Trainer> trainerList = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerList.putIfAbsent(trainerName, new Trainer(trainerName));
            trainerList.get(trainerName).getPokemons().add(pokemon);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("End")) {
            String element = input;
            trainerList.values().forEach(trainer -> {
                boolean hasSuchPokemon = trainer.checkElements(element);
                if (hasSuchPokemon) {
                    trainer.increaseBadges();
                } else {
                    trainer.reduceHp();
                }
            });
            input = scan.nextLine();
        }
        trainerList.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadgesCount(), t1.getBadgesCount()))
                .forEach(System.out::println);
    }
}
