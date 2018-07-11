package L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions;

public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(String message) {
        super(message);
    }
}
