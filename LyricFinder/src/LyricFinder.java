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
       

        System.out.println("Enter a song lyrcic and we'll do our "
        		+ "best to find the song that most closely matches your input!\n");
        
      
        System.out.println("\nEnter here (or enter stop to exit the program): ");
        while (true) {
            userInput = keyboard.nextLine();
            
            if (userInput.equalsIgnoreCase("stop")) {
                  break;
            } 
            
            Song songToShow = null;
            for (Song song : songs) {
            	for(int n = 0; n < song.getLyrics().size(); n++) {          		
            	if(getLevenshteinDistance(userInput.toLowerCase().replaceAll(" ", ""), 
            			song.getLyrics().get(n).toLowerCase().replaceAll(" ", "")) < 5) {
            		songToShow = song;
                    break;
                  } 
            	}
            }
            System.out.println(songToShow+"\n\n"); 
            System.out.println("If this was not the song you were looking for try again \n"
            		+ "(or type stop to exit the program): ");
            }
        keyboard.close();
	}
	
	
	private static Song[] getSongs() throws FileNotFoundException{
        Song[] song = new Song[songNames.length];
        for (int i = 0; i <= songNames.length - 1; i++) {
               String songName = songNames[i];
               
               
               File songFile = new File("Songs/" + songNames[i]);
               
               if (songFile.exists()) {
                     ArrayList<String> contents = getContents(songFile);
                     ArrayList<String> songLyrics = new ArrayList<String>();
                     
                     String songArtist = contents.get(1).trim();
                     
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
}
