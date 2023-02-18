package ExamPreparation.Exam26October2019.rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public boolean removeSpecies(String species) {
        return this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit found = this.data.stream().filter(rabbit -> rabbit.getName().equals(name)).findFirst().orElse(null);
        if (found != null) {
            found.setAvailable(false);
        }
        return found;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList());
        rabbits.forEach(rabbit -> rabbit.setAvailable(false));
        return rabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        return "Rabbits available at " + name + ":" + System.lineSeparator() +
               data.stream()
                       .filter(Rabbit::isAvailable)
                       .map(Rabbit::toString)
                       .collect(Collectors.joining(System.lineSeparator()));
    }

}
