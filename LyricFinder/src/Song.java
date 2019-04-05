import java.io.FileNotFoundException;

public class Song {
	private String lyrics;
	private String songTitle;
	private String artist;
	
	public Song(String lyrics, String songTitle, String artist) throws FileNotFoundException {
        this.lyrics = lyrics;
        this.songTitle = songTitle;
        this.artist = artist;
  }
	public String toString() {
        return String.format("%s %s: %s", lyrics, songTitle, artist);
  }
	

}
