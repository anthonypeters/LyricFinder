import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LyricFinder{
	
	private static final String[] songNames = new String[] {"7 Rings"};
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
        String userInput;
        
        Song[] songs = getSongs();

        System.out.println("Enter a song name and we'll do our best to find the song and its contents!\n");
        
        for (Song song : songs) {
        	System.out.println(song.getSongName());
        }
      
        System.out.println("\nEnter here: ");
        while (true) {
            userInput = keyboard.nextLine();
            
            if (userInput.equalsIgnoreCase("stop")) {
                  break;
            }
            
            Song songToShow = null;
            for (Song song : songs) {
                  if (userInput.equalsIgnoreCase(song.getSongName())) {
                         songToShow = song;
                         break;
                  }
            }
            System.out.println(songToShow); 
            }
        keyboard.close();
	}
	
	
	
	
	private static Song[] getSongs() throws FileNotFoundException{
        Song[] song = new Song[songNames.length];
        for (int i = 0; i <= songNames.length - 1; i++) {
               String songName = songNames[i], songArtist, songLyrics;
               
               File songFile = new File("Songs/" + songNames[i]);
               
               if (songFile.exists()) {
                     ArrayList<String> contents = getContents(songFile);
                     
                     songArtist = contents.get(1).trim();
                     
                     songLyrics = contents.get(2).trim();              
                     
                     song[i] = new Song(songName, songArtist, songLyrics);
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
