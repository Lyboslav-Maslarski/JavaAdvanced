package ExamPreparation.Exam16December2020.Openning.bakery;

public class Employee {
    private String name;
    private int age;
    private String country;

    public Employee(String name, int age, String country) {
        setName(name);
        setAge(age);
        setCounty(country);
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

    public String getCountry() {
        return country;
    }

    public void setCounty(String county) {
        this.country = county;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", getName(), getAge(), getCountry());
    }
}
