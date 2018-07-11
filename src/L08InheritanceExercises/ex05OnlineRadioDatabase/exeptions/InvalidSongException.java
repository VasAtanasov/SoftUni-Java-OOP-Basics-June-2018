package L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(String message) {
        super(message);
    }
}
