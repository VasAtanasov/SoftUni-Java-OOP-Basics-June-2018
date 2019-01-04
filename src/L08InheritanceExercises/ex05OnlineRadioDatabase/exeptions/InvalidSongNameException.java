package L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions;

public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException(String message) {
        super(message);
    }
}
