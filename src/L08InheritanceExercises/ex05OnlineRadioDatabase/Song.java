package L08InheritanceExercises.ex05OnlineRadioDatabase;

import L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions.InvalidArtistNameException;
import L08InheritanceExercises.ex05OnlineRadioDatabase.exeptions.InvalidSongNameException;

public class Song {
    private String name;
    private String title;
    private SongLength length;

    public Song(String name, String title, String length) {
        this.setName(name);
        this.setTitle(title);
        this.length = new SongLength(length);
    }

    private void setName(String name) {
        if (name.length() < 3 || name.length() > 20) {
            throw new InvalidArtistNameException(Constants.INVALID_ARTIST_NAME);
        }
        this.name = name;
    }

    private void setTitle(String title) {
        if (title.length() < 3 || title.length() > 30) {
            throw new InvalidSongNameException(Constants.INVALID_SONG_NAME);
        }
        this.title = title;
    }

    public int getTotalSeconds() {
        return this.length.getTotalSeconds();
    }
}
