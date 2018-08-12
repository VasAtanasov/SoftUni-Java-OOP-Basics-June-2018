package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.entities.cars.Car;

import java.util.stream.Collectors;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    @Override
    protected int getPrize(int rank) {
        int prize = 0;
        switch (rank) {
            case 1:
                prize = ((super.getPrizePool() * 40) / 100);
                break;
            case 2:
                prize = ((super.getPrizePool() * 30) / 100);
                break;
            case 3:
                prize = ((super.getPrizePool() * 20) / 100);
                break;
            case 4:
                prize = ((super.getPrizePool() * 10) / 100);
                break;
        }
        return prize;
    }

    @Override
    public int getPerformancePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
    }

    @Override
    public String start() {
        int[] rank = {1};
        String ranking = super.getParticipants()
                .values()
                .stream()
                .peek(car -> car.setDurability(car.getDurability() - (this.laps * (super.getLength() * super.getLength()))))
                .sorted((a, b) -> this.getPerformancePoints(b) - this.getPerformancePoints(a))
                .limit(4)
                .map(car -> String.format("%d. %s %s %dPP - $%d", rank[0], car.getBrand(), car.getModel(), this.getPerformancePoints(car), this.getPrize(rank[0]++)))
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format("%s - %d", super.getRoute(), (super.getLength() * this.laps)) +
                System.lineSeparator() +
                ranking;
    }
}