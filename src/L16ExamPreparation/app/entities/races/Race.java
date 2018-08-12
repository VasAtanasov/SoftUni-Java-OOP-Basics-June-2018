package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.entities.cars.Car;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private Map<Integer, Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedHashMap<>();
    }

    public boolean hasParticipants() {
        return ! this.participants.isEmpty();
    }

    public boolean hasParticipant(int id) {
        return this.participants.containsKey(id);
    }

    public void add(int id, Car car) {
        this.participants.putIfAbsent(id, car);
    }

    protected int getPrize(int rank) {
        int prize = 0;
        switch (rank) {
            case 1:
                prize = ((this.prizePool * 50) / 100);
                break;
            case 2:
                prize = ((this.prizePool * 30) / 100);
                break;
            case 3:
                prize = ((this.prizePool * 20) / 100);
                break;
            default:
        }
        return prize;
    }

    public abstract int getPerformancePoints(Car car);

    public String start() {
        int[] rank = {1};
        String ranking = this.participants
                .values()
                .stream()
                .sorted((a, b) -> this.getPerformancePoints(b) - this.getPerformancePoints(a))
                .limit(3)
                .map(car -> String.format("%d. %s %s %dPP - $%d", rank[0], car.getBrand(), car.getModel(), this.getPerformancePoints(car), this.getPrize(rank[0]++)))
                .collect(Collectors.joining(System.lineSeparator()));


        return String.format("%s - %d", this.route, this.length) +
                System.lineSeparator() +
                ranking;
    }
}