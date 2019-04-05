public class Player {
	private String name;
	private String stats;
	
	//Constructors
	public Player(String name, String stats) {
		this.name = name;
		this.stats = stats;
	}
	
	public String toString() {
		return String.format("%s: %s", name, stats);
	}
	
	public String getName() {
		return name;
	}
	
	public String getStats(){
		return this.stats;
	}
}