package L04DefiningClassesExercises.ex10FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String dayOfBirth;
    private List<Person> children;
    private List<Person> parents;

    {
        children = new ArrayList<>();
        parents = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public String getDayOfBirth() {
        return this.dayOfBirth;
    }

    boolean isMatch(String name, String date) {
        return date.equals(this.getDayOfBirth()) || name.equals(this.getName());
    }


    void addChild(Person person) {
        this.children.add(person);
    }

    void addParent(Person person) {
        this.parents.add(person);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s %s", this.getName(), this.getDayOfBirth())).append(System.lineSeparator());
        output.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(p -> output.append(String.format("%s %s", p.getName(), p.getDayOfBirth())).append(System.lineSeparator()));
        output.append("Children:").append(System.lineSeparator());
        this.children.forEach(p -> output.append(String.format("%s %s", p.getName(), p.getDayOfBirth())).append(System.lineSeparator()));
        return output.toString();
    }
}
