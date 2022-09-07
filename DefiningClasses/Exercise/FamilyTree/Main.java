package DefiningClasses.Exercise.FamilyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        ArrayDeque<String> deque = new ArrayDeque<>();
        String[] search = scan.nextLine().split("\\s+");

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            if (input.contains("-")) {
                deque.offer(input);
            } else {
                String firstName = data[0];
                String lastName = data[1];
                String dateOfBirth = data[2];
                Person person = new Person(firstName, lastName, dateOfBirth);
                personList.add(person);
            }
            input = scan.nextLine();
        }

        while (!deque.isEmpty()) {
            String[] data = deque.pop().split("\\s+");
            if (data.length == 5) {
                String parentFirstName = data[0];
                String childFirsName = data[3];
                Person person1 = personList.stream().filter(person -> person.getFirstName().equals(parentFirstName)).collect(Collectors.toList()).get(0);
                Person person2 = personList.stream().filter(person -> person.getFirstName().equals(childFirsName)).collect(Collectors.toList()).get(0);
                person1.getChildren().add(person2);
                person2.getParents().add(person1);
            } else if (data.length == 4) {
                if (data[1].equals("-")) {
                    String parentDateOfBirth = data[0];
                    String childFirsName = data[2];
                    Person person1 = personList.stream().filter(person -> person.getDateOfBirth().equals(parentDateOfBirth)).collect(Collectors.toList()).get(0);
                    Person person2 = personList.stream().filter(person -> person.getFirstName().equals(childFirsName)).collect(Collectors.toList()).get(0);
                    person1.getChildren().add(person2);
                    person2.getParents().add(person1);
                } else {
                    String parentFirstName = data[0];
                    String childDateOfBirth = data[3];
                    Person person1 = personList.stream().filter(person -> person.getFirstName().equals(parentFirstName)).collect(Collectors.toList()).get(0);
                    Person person2 = personList.stream().filter(person -> person.getDateOfBirth().equals(childDateOfBirth)).collect(Collectors.toList()).get(0);
                    person1.getChildren().add(person2);
                    person2.getParents().add(person1);
                }
            } else {
                String parentDateOfBirth = data[0];
                String childDateOfBirth = data[2];
                Person person1 = personList.stream().filter(person -> person.getDateOfBirth().equals(parentDateOfBirth)).collect(Collectors.toList()).get(0);
                Person person2 = personList.stream().filter(person -> person.getDateOfBirth().equals(childDateOfBirth)).collect(Collectors.toList()).get(0);
                person1.getChildren().add(person2);
                person2.getParents().add(person1);
            }
        }

        Person person;
        if (search.length == 2) {
            person = personList.stream().filter(person1 -> person1.getFirstName().equals(search[0])).collect(Collectors.toList()).get(0);
        } else {
            person = personList.stream().filter(person1 -> person1.getDateOfBirth().equals(search[0])).collect(Collectors.toList()).get(0);
        }
        System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getDateOfBirth());
        System.out.println("Parents:");
        person.getParents().forEach(parent -> System.out.println(parent.getFirstName() + " " + parent.getLastName() + " " + parent.getDateOfBirth()));
        System.out.println("Children:");
        person.getChildren().forEach(child -> System.out.println(child.getFirstName() + " " + child.getLastName() + " " + child.getDateOfBirth()));
    }
}
