import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LyricFinder{
	
	private static final String[] songNames = new String[] {"7rings", "babyshark", "igottafeeling"};
	
	
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
        String userInput;
        
        System.out.println("\nEnter a lyric and we'll do our best to find the song: ");
        userInput = keyboard.next();
        
        while (userInput != null) {
        	if (userInput.toLowerCase().equals(lyricLine1) || userInput.toLowerCase().equals(lyricLine2)) {
        		System.out.println()
        	}
            
        }
        
	}
	
	
	
	
	private static Song[] getSongs() throws FileNotFoundException{
        Song[] songs = new Song[songNames.length];
        for (int i = 0; i <= songNames.length - 1; i++) {
               String teamName = songNames[i], teamCity, teamStats;
               
               File teamFile = new File("Stats/" + songNames[i] + "Stats");
               if (teamFile.exists()) {
                     ArrayList<String> contents = getContents(teamFile);
                     
                     teamCity = contents.get(0).trim();
                     teamStats = contents.get(1).trim();
                     songs[i] = new Song(teamName, teamCity, teamStats);
               }
        }
        return songs;
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