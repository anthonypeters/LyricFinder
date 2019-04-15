import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LyricFinder{
	
	private static final String[] songNames = new String[] {"7 Rings", "Another One Bites the Dust", "Isn't She Lovely", "Old Town Road", "Thriller"};
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner keyboard = new Scanner(System.in);
        String userInput;
        
        Song[] songs = getSongs();
       

        System.out.println("Enter a song lyric and we'll do our best to find the song with similar lyrics!\n");
        
        for (Song song : songs) {
        	System.out.println(song.getSongName());
        }
      
        System.out.println("\nEnter here (or type stop to end the program): ");
        while (true) {
            userInput = keyboard.nextLine();
            
            if (userInput.equalsIgnoreCase("stop")) {
                  break;
            }
            
            Song songToShow = null;
            for (Song song : songs) {
            	if(getLevenshteinDistance(userInput.toLowerCase().replaceAll(" ", ""), song.getSongName().replaceAll(" ", "")) < 5) {
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
               String songName = songNames[i], songArtist;
               
               
               File songFile = new File("Songs/" + songNames[i]);
               
               if (songFile.exists()) {
                     ArrayList<String> contents = getContents(songFile);
                     ArrayList<String> songLyrics = new ArrayList<String>();
                     
                     songArtist = contents.get(1).trim();
                     
                     for (int j=3; j <contents.size()-1; j++) {
                    	 songLyrics.add(contents.get(j));
                     }             
                     
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
	
	
	public static int getLevenshteinDistance(String str1, String str2){    
		
        int len1 = str1.length();

        int len2 = str2.length();

        int[][] arr = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)

            arr[i][0] = i;

        for (int i = 1; i <= len2; i++)

            arr[0][i] = i;

        for (int i = 1; i <= len1; i++) {

            for (int j = 1; j <= len2; j++) {

                int m = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0:1;                        

                arr[i][j] = Math.min(Math.min(arr[i - 1][j] + 1, arr[i][j - 1] + 1), arr[i - 1][j - 1] + m);

            }

        }

        return arr[len1][len2];

    }
	
	public static ArrayList<String> getLyric() throws FileNotFoundException{
		ArrayList<String> songLyrics = new ArrayList<String>(); 
	        for (int i = 0; i <= songNames.length - 1; i++) {

	               
	               
	               File[] songFile = new File("Songs/").listFiles();
	               for(File file: songFile) {
	            	    ArrayList<String> contents = getContents(file);
	                     for (int j=3; j <contents.size()-1; j++) {
	                    	 songLyrics.add(contents.get(j));
	                     }
	               }
	        
	        
	        }
	        return songLyrics;
	}
}
