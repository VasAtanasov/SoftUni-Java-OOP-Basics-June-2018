package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.entities.cars.Car;

public class TimeLimitRace extends Race {
    private int goldTime;
    private String participantTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
        this.participantTime = "No prize";
    }

    @Override
    protected int getPrize(int timePerformance) {
        if (timePerformance <= this.goldTime) {
            this.participantTime = "Gold";
            return super.getPrizePool();
        } else if (timePerformance <= (this.goldTime + 15)) {
            this.participantTime = "Silver";
            return super.getPrizePool() - (super.getPrizePool() * 50) / 100;
        } else {
            this.participantTime = "Bronze";
            return super.getPrizePool() - (super.getPrizePool() * 30) / 100;
        }
    }

    @Override
    public int getPerformancePoints(Car car) {
        return super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
    }

    @Override
    public String start() {
        Car participant = super.getParticipants().values().stream().findFirst().get();
        int timePerformance = this.getPerformancePoints(participant);
        int prize = this.getPrize(timePerformance);
        return String.format("%s - %d", super.getRoute(), super.getLength()) +
                System.lineSeparator() +
                String.format("%s %s - %d s.", participant.getBrand(), participant.getModel(), timePerformance) +
                System.lineSeparator() +
                String.format("%s Time, $%d.", this.participantTime, prize);
    }
}