package DefiningClasses.Exercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Person> personMap = new HashMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            personMap.putIfAbsent(name, new Person(name));
            Person person = personMap.get(name);
            if (data[1].equals("company")) {
                String companyName = data[2];
                String department = data[3];
                double salary = Double.parseDouble(data[4]);
                person.setCompanyName(companyName);
                person.setDepartment(department);
                person.setSalary(salary);
            } else if (data[1].equals("pokemon")) {
                String pokemonName = data[2];
                String pokemonType = data[3];
                Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);
                person.getPokemonList().add(pokemon);
            } else if (data[1].equals("parents")) {
                String parentName = data[2];
                String parentBirthday = data[3];
                Person.Parent parent = new Person.Parent(parentName, parentBirthday);
                person.getParents().add(parent);
            } else if (data[1].equals("children")) {
                String childName = data[2];
                String childBirthday = data[3];
                Person.Child child = new Person.Child(childName, childBirthday);
                person.getChildren().add(child);
            } else {
                String carModel = data[2];
                int carSpeed = Integer.parseInt(data[3]);
                Person.Car car = new Person.Car(carModel, carSpeed);
                person.setCar(car);
            }
            input = scan.nextLine();
        }
        String nameToSearch = scan.nextLine();
        Person person = personMap.get(nameToSearch);
        System.out.println(person);
        System.out.println("Pokemon:");
        person.getPokemonList().forEach(System.out::println);
        System.out.println("Parents:");
        person.getParents().forEach(System.out::println);
        System.out.println("Children:");
        person.getChildren().forEach(System.out::println);
    }
}
