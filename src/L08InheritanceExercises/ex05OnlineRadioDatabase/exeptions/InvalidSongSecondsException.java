package L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions;

public class InvalidSongSecondsException extends InvalidSongLengthException {
    public InvalidSongSecondsException(String message) {
        super(message);
    }
}
