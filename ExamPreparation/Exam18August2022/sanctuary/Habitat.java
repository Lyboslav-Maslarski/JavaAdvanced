package ExamPreparation.Exam18August2022.sanctuary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Habitat {
    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(elephant -> elephant.getRetiredFrom().equals(retiredFrom)).findAny().orElse(null);
    }

    public Elephant getOldestElephant() {
        return data.stream().max(Comparator.comparing(Elephant::getAge)).get();
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        return "Saved elephants in the park:" +
               System.lineSeparator() +
               data.stream()
                       .map(e -> e.getName() + " came from: " + e.getRetiredFrom())
                       .collect(Collectors.joining(System.lineSeparator()));
    }
}
