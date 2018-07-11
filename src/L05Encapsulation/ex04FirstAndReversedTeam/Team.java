package L05Encapsulation.ex04FirstAndReversedTeam;

import java.util.ArrayList;
import java.util.List;

class Team {
    private String teamName;
    private List<Person> first;
    private List<Person> reserve;

    Team() {
        this.teamName = "Minior";
        this.first = new ArrayList<>();
        this.reserve = new ArrayList<>();
    }

    void addPersonToTeam(Person person) {
        if (person.getAge() < 40) {
            this.first.add(person);
        } else {
            this.reserve.add(person);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("First team have %d players%n", this.first.size()));
        output.append(String.format("Reserve team have %d players%n", this.reserve.size()));
        return output.toString();
    }
}
