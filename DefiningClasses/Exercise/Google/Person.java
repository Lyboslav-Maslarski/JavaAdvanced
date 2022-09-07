package DefiningClasses.Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    static class Car {
        private String carModel;
        private int carSpeed;

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        public String getCarModel() {
            return carModel;
        }

        public void setCarModel(String carModel) {
            this.carModel = carModel;
        }

        public int getCarSpeed() {
            return carSpeed;
        }

        public void setCarSpeed(int carSpeed) {
            this.carSpeed = carSpeed;
        }
    }

    static class Parent {
        private String parentName;
        private String parentBirthday;

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.parentName, this.parentBirthday);
        }
    }

    static class Child {
        private String childName;
        private String childBirthday;

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.childName, this.childBirthday);
        }
    }

    static class Pokemon {
        private String pokemonName;
        private String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.pokemonName, this.pokemonType);
        }
    }

    private String name;
    private String companyName;
    private String department;
    private double salary;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemonList;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    @Override
    public String toString() {
        return String.format("%s%nCompany:%s%nCar:%s", this.name
                , this.companyName == null ? "" : String.format("%n%s %s %.2f", this.companyName, this.department, this.salary)
                , this.car == null ? "" : String.format("%n%s %d", this.car.carModel, this.car.carSpeed));
    }
}
