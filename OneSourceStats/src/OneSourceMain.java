import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class OneSourceMain {
       
       private static final String[] teamNames = new String[] {"Brewers", "Cubs", "Cardinals", "Pirates", "Reds"};

       public static void main(String[] args) throws FileNotFoundException {
             
             Scanner keyboard = new Scanner(System.in);
             String response;
             
             Team[] teams = getTeams();
             
             System.out.println("Welcome to OneSource Baseball Stats. Type the name of one of these teams to see their stats:\n");
             for (Team team : teams) System.out.println(team.getTeamName());
             
             while (true) {
                    System.out.println("\nEnter a team or type STOP to exit the program: ");
                    response = keyboard.nextLine();
                    
                    if (response.equalsIgnoreCase("stop")) {
                          break;
                    }
                    
                    Team teamToShow = null;
                    for (Team team : teams) {
                          if (response.equalsIgnoreCase(team.getTeamName())) {
                                 teamToShow = team;
                                 break;
                          }
                    }
                    
                    if (teamToShow != null) {
                          System.out.println(teamToShow);
                          System.out.println("Type one of these player names and hit enter to see their stats or type BACK to select a different team:\n");
                          
                          for (Player player : teamToShow.getPlayers()) System.out.println(player.getName());
                          
                          while (true) {
                                 System.out.println("\nEnter a player:");
                                 response = keyboard.nextLine();
                                 
                                 if (response.equalsIgnoreCase("back")) {
                                       break;
                                 }
                                 
                                 Player playerToShow = null;
                                 for (Player player : teamToShow.getPlayers()) {
                                       if (response.equalsIgnoreCase(player.getName())) {
                                              playerToShow = player;
                                              break;
                                       }
                                 }
                                 
                                 if (playerToShow != null) {
                                        System.out.println(playerToShow);
                                 } else {
                                       System.out.println("That is not one of the players listed! Please check spelling and try again!");
                                 }
                          }
                    } else {
                          System.out.println("That is not one of the teams listed! Please check spelling and try again!");
                    }
             }
             
             keyboard.close();
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
       
       private static Team[] getTeams() throws FileNotFoundException {
             Team[] teams = new Team[teamNames.length];
             for (int i = 0; i <= teamNames.length - 1; i++) {
                    String teamName = teamNames[i], teamCity, teamStats;
                    
                    File teamFile = new File("Stats/" + teamNames[i] + "Stats");
                    if (teamFile.exists()) {
                          ArrayList<String> contents = getContents(teamFile);
                          
                          teamCity = contents.get(0).trim();
                          teamStats = contents.get(1).trim();
                          teams[i] = new Team(teamName, teamCity, teamStats);
                    }
             }
             return teams;
       }
}
