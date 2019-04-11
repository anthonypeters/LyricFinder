import java.io.FileNotFoundException;

public class Song {
	private String lyrics;
	private String songName;
	private String artist;
	
	public Song(String songName, String artist, String lyrics) throws FileNotFoundException {
        this.lyrics = lyrics;
        this.songName = songName;
        this.artist = artist;
  }
	public String toString() {
        return String.format("%s %s: %s", songName, artist, lyrics);
  }
	public String getSongName() {
        return this.songName;
  }

}
