package L06EncapsulationExercises.ex06FootballTeamGenerator;

import java.util.Map;

public class Player {
    private String name;
    private Map<String, Double> stats;

    public Player(String name, Map<String, Double> stats) {
        this.name = name;
        this.stats = stats;
    }

    double getAverageStats() {
        return stats.values().stream().reduce(0.0, (a, b) -> a + b) / stats.size();
    }
}
