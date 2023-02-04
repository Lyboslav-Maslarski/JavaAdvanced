package ExamPreparation.Exam13April2022.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addEgg(Egg egg) {
        if (this.data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color) {
        return data.removeIf(egg -> egg.getColor().equals(color));
    }

    public Egg getStrongestEgg() {
        int max = data.stream().mapToInt(Egg::getStrength).max().orElse(-1);
        return data.stream().filter(egg -> egg.getStrength() == max).findAny().orElse(null);
    }

    public Egg getEgg(String color) {
        return this.data.stream().filter(egg -> egg.getColor().equals(color)).findAny().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(material + " basket contains:");
        data.forEach(egg -> sb.append(System.lineSeparator()).append(egg));
        return sb.toString();
    }
}
