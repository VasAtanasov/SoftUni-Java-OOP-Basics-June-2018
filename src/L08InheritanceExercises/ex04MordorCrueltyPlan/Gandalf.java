package L08InheritanceExercises.ex04MordorCrueltyPlan;

public class Gandalf {
    private int happinessPoints;

    public Gandalf() {
        this.happinessPoints = 0;
    }

    public void eat(Food food) {
        this.happinessPoints += food.getPoints();
    }

    private String getMood() {
        if (this.happinessPoints < - 5) {
            return "Angry";
        } else if (this.happinessPoints < 0) {
            return "Sad";
        } else if (this.happinessPoints <= 15) {
            return "Happy";
        }
        return "JavaScript";
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.happinessPoints, this.getMood());
    }
}
