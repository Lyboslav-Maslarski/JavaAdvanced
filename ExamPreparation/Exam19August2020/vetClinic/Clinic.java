package ExamPreparation.Exam19August2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet oldestPet = data.get(0);
        for (Pet pet : data) {
            if (pet.getAge() >= oldestPet.getAge()) {
                oldestPet = pet;
            }
        }
        return oldestPet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:");
        data.forEach(pet -> stringBuilder.append(System.lineSeparator()).append(pet.getName()).append(" ").append(pet.getOwner()));
        return stringBuilder.toString().trim();
    }
}
