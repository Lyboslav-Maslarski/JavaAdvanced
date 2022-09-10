package IteratorsAndComparators.Exercise.EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Person> personTreeSet = new TreeSet<>();
        Set<Person> personHashSet = new HashSet<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] personInfo = scan.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            personTreeSet.add(person);
            personHashSet.add(person);
        }
        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());
    }
}
