package IteratorsAndComparators.Exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] personInfo = input.split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            String town = personInfo[2];

            Person person = new Person(name, age, town);
            personList.add(person);
            input = scan.nextLine();
        }
        int index = Integer.parseInt(scan.nextLine()) - 1;
        Person personForComparing = personList.get(index);
        int numberOfEqualPpl = 0;
        int numberOfNotEqualPpl = 0;
        for (Person person : personList) {
            if (person.compareTo(personForComparing) == 0) {
                numberOfEqualPpl++;
            } else {
                numberOfNotEqualPpl++;
            }
        }
        if (numberOfEqualPpl == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(numberOfEqualPpl + " " + numberOfNotEqualPpl + " " + personList.size());
        }
    }
}
