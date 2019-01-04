package L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
