package ExamPreparation.Exam14April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() == this.capacity) {
            return "No seats in the university";
        } else if (this.students.contains(student)) {
            return "Student is already in the university";
        } else {
            this.students.add(student);
            return "Added student " + student.firstName + " " + student.lastName;
        }
    }

    public String dismissStudent(Student studentToSearch) {
        if (!this.students.contains(studentToSearch)) {
            return "Student not found";
        } else {
            this.students.remove(studentToSearch);
            return "Removed student " + studentToSearch.firstName + " " + studentToSearch.lastName;
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream().filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            stringBuilder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n"
                    , student.firstName, student.lastName, student.bestSubject));
        }
        return stringBuilder.toString().trim();
    }
}
