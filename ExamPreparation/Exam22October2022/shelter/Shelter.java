package ExamPreparation.Exam22October2022.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (getCount() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream().filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)).findFirst().orElse(null);
    }

    public Animal getOldestAnimal() {
        return data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return "The ExamPreparation.Exam22October2022.shelter has the following animals:" +
               System.lineSeparator() +
               data.stream().map(animal -> animal.getName() + " " + animal.getCaretaker())
                       .collect(Collectors.joining(System.lineSeparator()));
    }
}
