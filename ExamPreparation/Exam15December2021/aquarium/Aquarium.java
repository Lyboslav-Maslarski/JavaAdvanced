package ExamPreparation.Exam15December2021.aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        Optional<Fish> optionalFish = fishInPool.stream().filter(f -> f.getName().equals(fish.getName())).findAny();
        if (optionalFish.isEmpty() && capacity > getFishInPool()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(fish -> fish.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        return String.format("Aquarium: %s ^ Size: %d%n", name, size) +
               fishInPool.stream().map(Fish::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
