package DefiningClasses.Exercise.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private List<Person> parents;
    private List<Person> children;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String firstName, String lastName, String dateOfBirth) {
        this(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
