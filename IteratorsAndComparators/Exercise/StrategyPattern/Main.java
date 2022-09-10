package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Person> nameSet = new TreeSet<>(new Person.ComparatorByName());
        Set<Person> ageSet = new TreeSet<>(new Person.ComparatorByAge());
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personInfo = scan.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            nameSet.add(person);
            ageSet.add(person);
        }
        nameSet.forEach(System.out::println);
        ageSet.forEach(System.out::println);
    }
}
