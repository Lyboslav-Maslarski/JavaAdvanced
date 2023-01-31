package ExamPreparation.Exam14December2022.softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        if (getCount() == capacity) {
            return "The hall is full.";
        }
        if (this.data.contains(student)) {
            return "Student is already in the hall.";
        }
        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
    }

    public String remove(Student student) {
        if (this.data.contains(student)) {
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream().filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)).findAny().orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(getCount());
        this.data.forEach(student -> sb.append(System.lineSeparator()).append(student));
        return sb.toString();
    }
}
