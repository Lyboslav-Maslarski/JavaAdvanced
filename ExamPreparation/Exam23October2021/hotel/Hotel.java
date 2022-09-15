package ExamPreparation.Exam23October2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String name;
    private final int capacity;
    private final List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (this.roster.size() < capacity) {
            this.roster.add(person);
        }
    }

    public boolean remove(String name) {
        boolean anyMatch = this.roster.stream().anyMatch(person -> person.getName().equals(name));
        if (anyMatch) {
            Person searchedPerson = this.roster.stream().filter(person -> person.getName().equals(name)).findFirst().get();
            this.roster.remove(searchedPerson);
            return true;
        } else {
            return false;
        }
    }

    public Person getPerson(String name, String hometown) {
        return this.roster.stream()
                .filter(person -> person.getName().equals(name) && person.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.roster.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The people in the ExamPreparation.Exam23October2021.hotel ").append(this.name).append(" are:").append(System.lineSeparator());
        this.roster.forEach(person -> stringBuilder.append(person.toString()).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }

}
