package DefiningClasses.Exercise.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Employee>> employees = new HashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] employeeData = scan.nextLine().split("\\s+");
            String name = employeeData[0];
            double salary = Double.parseDouble(employeeData[1]);
            String position = employeeData[2];
            String department = employeeData[3];
            if (employeeData.length == 4) {
                Employee employee = new Employee(name, salary, position, department);
                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(employee);
            } else if (employeeData.length == 5) {
                if (employeeData[4].length() > 2) {
                    String email = employeeData[4];
                    Employee employee = new Employee(name, salary, position, department, email);
                    employees.putIfAbsent(department, new ArrayList<>());
                    employees.get(department).add(employee);
                } else {
                    int age = Integer.parseInt(employeeData[4]);
                    Employee employee = new Employee(name, salary, position, department, age);
                    employees.putIfAbsent(department, new ArrayList<>());
                    employees.get(department).add(employee);
                }
            } else if (employeeData.length == 6) {
                String email = employeeData[4];
                int age = Integer.parseInt(employeeData[5]);
                Employee employee = new Employee(name, salary, position, department, email, age);
                employees.putIfAbsent(department, new ArrayList<>());
                employees.get(department).add(employee);
            }
        }
        double maxSalary = 0;
        String maxSalaryDepartment = "";
        for (Map.Entry<String, List<Employee>> entry : employees.entrySet()) {
            double avgSalary = entry.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
            if (avgSalary > maxSalary) {
                maxSalaryDepartment = entry.getKey();
                maxSalary = avgSalary;
            }
        }
        System.out.println("Highest Average Salary: " + maxSalaryDepartment);
        employees.get(maxSalaryDepartment).stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge()));
    }
}
