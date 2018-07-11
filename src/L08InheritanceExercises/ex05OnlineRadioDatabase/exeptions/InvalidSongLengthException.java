package L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions;

public class InvalidSongLengthException extends InvalidSongException {
    public InvalidSongLengthException(String message) {
        super(message);
    }
}
