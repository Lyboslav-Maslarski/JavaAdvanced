package IteratorsAndComparators.Exercise.StrategyPattern;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class ComparatorByName implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getName().length() == p2.getName().length()) {
                return Character.compare(p1.getName().toLowerCase().charAt(0), p2.getName().toLowerCase().charAt(0));
            }
            return Integer.compare(p1.getName().length(), p2.getName().length());

        }
    }

    public static class ComparatorByAge implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
