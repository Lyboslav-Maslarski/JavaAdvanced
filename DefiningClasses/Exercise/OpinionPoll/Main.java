package DefiningClasses.Exercise.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] personData = scan.nextLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        Predicate<Person> predicate = person -> person.getAge() > 30;
        people.stream()
                .filter(predicate)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(person -> System.out.println(person.getName() + " - " + person.getAge()));
    }
}
