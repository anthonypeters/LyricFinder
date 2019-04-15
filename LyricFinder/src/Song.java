import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Song {
	private ArrayList<String> lyrics;
	private String songName;
	private String artist;
	
	public Song(String songName, String artist, ArrayList<String> lyrics) throws FileNotFoundException {
        this.songName = songName;
        this.artist = artist;
        this.lyrics = lyrics;
  }
	public String toString() {
        return String.format("\nTitle: %s \n\nArtist: %s \n\nLyrics: \n%s", songName, artist, lyrics);
  }
	public String getSongName() {
        return this.songName;
  }
	public ArrayList<String> getLyrics(){
		return this.lyrics;
	}
}

