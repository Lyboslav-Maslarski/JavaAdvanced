package DefiningClasses.Exercise.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.badgesCount = 0;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void reduceHp() {
        pokemons.forEach(Pokemon::reduceHp);
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public void increaseBadges() {
        this.badgesCount++;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public boolean checkElements(String element) {
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.getBadgesCount(), this.getPokemons().size());
    }
}
