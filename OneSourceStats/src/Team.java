import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Team {
       private String teamName;
       private String city;
       private String stats;
       
       private ArrayList<Player> players = new ArrayList<Player>();
       
       //Constructors
       public Team(String teamName, String city, String stats) throws FileNotFoundException {
             this.teamName = teamName;
             this.city = city;
             this.stats = stats;
             
             this.addPlayers();
       }
       
       public String toString() {
             return String.format("%s %s: %s", city, teamName, stats);
       }
       
       public String getTeamName() {
             return this.teamName;
       }
       
       public ArrayList<Player> getPlayers() {
             return this.players;
       }
       
       private void addPlayers() throws FileNotFoundException {
             File playersFile = new File("Players/" + teamName + "Players");
             if (playersFile.exists()) {
                    ArrayList<String> contents = OneSourceMain.getContents(playersFile);
                    for (int i = 0; i <= contents.size() - 1; i++) {
                          String[] playerInfo = contents.get(i).split("#");
                          this.players.add(new Player(playerInfo[0].trim(), playerInfo[1].trim()));
                    }
             }
       }
}
