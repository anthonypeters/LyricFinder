import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LyricFinder{
	
	private static final String[] songNames = new String[] {"7 Rings"};
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
        //String userInput;
        
        Song[] songs = getSongs();
        
        //System.out.println("Enter a lyric and we'll do our best to find the song: ");
        //userInput = keyboard.next();
        
        for (Song song : songs) {
        	System.out.println(song.getSongName());
        }
        
       // while (userInput != null) {
        	//for (int i =0; i<= songNames.length; i++) {
        		//if (userInput.toLowerCase().equals() || userInput.toLowerCase().equals()) {
            		//System.out.println();
            	//}
        	//}
	
          
        
	}
	
	
	
	
	private static Song[] getSongs() throws FileNotFoundException{
        Song[] song = new Song[songNames.length];
        for (int i = 0; i <= songNames.length - 1; i++) {
               String songName = songNames[i], songArtist, songLyrics;
               
               File songFile = new File("Songs/" + songNames[i]);
               
               if (songFile.exists()) {
                     ArrayList<String> contents = getContents(songFile);
                     
                     songArtist = contents.get(1).trim();
                     songLyrics = contents.get(2).trim(); //This will only get the contents of the lyrics in index 2
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
