package ExamPreparation.Exam19February2022.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

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

    public void add(Parrot parrot) {
        if (count() < capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream().filter(p -> p.getName().equals(name)).findFirst().get();
        parrot.setAvailable(false);
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = this.data.stream().filter(parrot -> parrot.getSpecies().equals(species)).collect(Collectors.toList());
        parrots.forEach(parrot -> parrot.setAvailable(false));
        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        return "Parrots available at " + name + ":" + System.lineSeparator() +
               this.data.stream()
                       .filter(Parrot::isAvailable)
                       .map(Parrot::toString)
                       .collect(Collectors.joining(System.lineSeparator()));
    }
}
