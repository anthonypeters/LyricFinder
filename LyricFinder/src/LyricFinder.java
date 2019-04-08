import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LyricFinder{
	
	private static final String[] songs = new String[] {"7rings", "babyshark", "igottafeeling"};
	
	
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
        String userInput;
        
        String lyricLine1;
        String lyricLine2;
        
        System.out.println("\nEnter a lyric and we'll do our best to find the song: ");
        userInput = keyboard.next();
        
        while (userInput != null) {
        	if (userInput.toLowerCase().equals(lyricLine1) || userInput.toLowerCase().equals(lyricLine2)) {
        		System.out.println();
        	}
            
        }
        
	}
	
	
	
	
	private static Song[] getSongs() throws FileNotFoundException{
        Song[] song = new Song[songs.length];
        for (int i = 0; i <= songs.length - 1; i++) {
               String songName = songs[i];
               
               File songFile = new File("Songs/" + songNames[i]);
               if (songFile.exists()) {
                     ArrayList<String> contents = getContents(songFile);
                     
                     songs[i] = new Song(lyrics, songTitle, artist);
               }
        }
        return song;
  }
	
	
	
	public static ArrayList<String> getContents(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        reader.useDelimiter(";");
        ArrayList<String> contents = new ArrayList<String>();
        while (reader.hasNext()) {
               contents.add(reader.next());
        }
        reader.close();
        return contents;
  }
}
