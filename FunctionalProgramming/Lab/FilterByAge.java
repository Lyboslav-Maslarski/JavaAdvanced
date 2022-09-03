package FunctionalProgramming.Lab;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = IntStream.range(0, n).mapToObj(i -> readPerson(scan)).collect(Collectors.toList());
        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();
        people = filterPeopleByAge(people, getPredicate(condition, age));
        Consumer<Person> printer = getOutputFormat(format);
        people.forEach(printer);
    }

    private static Consumer<Person> getOutputFormat(String format) {
        switch (format) {
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.name, person.age);
            case "name":
                return person -> System.out.printf("%s%n", person.name);
            case "age":
                return person -> System.out.printf("%d%n", person.age);
            default:
                throw new IllegalArgumentException("Invalid format");
        }
    }

    private static List<Person> filterPeopleByAge(List<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate).collect(Collectors.toList());
    }

    private static Predicate<Person> getPredicate(String condition, int age) {
        switch (condition) {
            case "younger":
                return person -> person.age <= age;
            case "older":
                return person -> person.age >= age;
            default:
                throw new IllegalArgumentException("Invalid arguments");
        }
    }

    private static Person readPerson(Scanner scanner) {
        String[] data = scanner.nextLine().split(", ");
        return new Person(data[0], Integer.parseInt(data[1]));
    }
}
