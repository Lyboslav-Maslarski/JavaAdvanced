package ExamPreparation.Exam17Dec2019.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (count() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        double maxWeight = 0;
        Present heaviest = null;
        for (Present present : data) {
            double currentWeight = present.getWeight();
            if (currentWeight > maxWeight) {
                maxWeight = currentWeight;
                heaviest = present;
            }
        }
        return heaviest;
    }

    public Present getPresent(String name) {
        return data.stream().filter(present -> present.getName().equals(name)).findAny().get();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(getColor()).append(" bag contains:");
        for (Present present : data) {
            sb.append(System.lineSeparator()).append(present);
        }
        return sb.toString();
    }
}
