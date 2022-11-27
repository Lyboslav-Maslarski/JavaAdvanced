package ExamPreparation.Exam16December2020.Openning.bakery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return Collections.max(employees, Comparator.comparingInt(Employee::getAge));
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder("Employees working at Bakery " + name + ":");
        employees.forEach(e -> stringBuilder.append(System.lineSeparator()).append(e));
        return stringBuilder.toString().trim();
    }
}
