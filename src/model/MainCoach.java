package model;
/**
* @author Brian Romero
*/
public class MainCoach extends Coach implements Calculable{
	private int numberTeams;
	private int championshipsWon;
	/**
	* constructor of the MainCoach class.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> MainCoach class object created.<br>
	*/
	public MainCoach(){
		super();
		numberTeams = 0;
		championshipsWon = 0;
	}//End constructor1
	/**
	* construcotr of the HeadCoach class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> HeadCoach class object created.<br>
	* @param name. HeadCoach name. name != null.
	* @param id. HeadCoach id. id != null, id != ""
	* @param salary. HeadCoach salary. salary > 0. 
	* @param state. HeadCoach state. state is initialized
	* @param expYears. HeadCoach experience years. years >= 0
	* @param numberTeams. HeadCoach leading teams. leadingTeams is initialized
	* @param championshipsWon. HeadCoach achieved championships. championshipsWon is initialized
	*/
	public MainCoach(String name, String id, double salary, boolean state,int expYear, int numberTeams, int championshipsWon){
		super(name,id,salary,state,expYear);
		this.numberTeams = numberTeams;
		this.championshipsWon = championshipsWon;
	}//End constructor2
	/**
	* changes the MainCoach amount of leading teams.<br>
	* <b>pre:</b> numberTeams is initialized.<br>
	* <b>post:</b> MainCoach amount of leading teams has been changed.<br>
	* @param numberTeams. New MainCoach amount of numberTeams. numberTeams is initialized
	*/
	public void setNumberTeams(int numberTeams){
		this.numberTeams = numberTeams;
	}//End setNumberTeams
	/**
	* returns the MainCoach amount of leading teams.<br>
	* <b>pre:</b> leadingTeams is initialized.<br>
	* <b>post:</b> HeadCoach leadingTeams.<br>
	*/
	public int getNumberTeams(){
		return numberTeams;
	}//End getNumberTeams
	/**
	* changes the MainCoach amount of achieved championships.<br>
	* <b>pre:</b> championshipsWon is initialized.<br>
	* <b>post:</b> championshipsWon has been changed.<br>
	* @param championshipsWon. New MainCoach amount of achieved championships. championshipsWon is initialized
	*/
	public void setChampionshipWon(int championshipsWon){
		this.championshipsWon = championshipsWon;
	}//End setChampionshipWon
	/**
	* returns de MainCoach amount of achieved championships.<br>
	* <b>pre:</b> championshipsWon is initialized.<br>
	* <b>post:</b> MainCoach championshipsWon.<br>
	*/
	public int getChampionshipWon(){
		return championshipsWon;
	}//End getChampionshipWon
	/**
	* calculates the MainCoach market price. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> MainCoach market price has been calculated.<br>
	*/
	@Override
	public double calculatePrice(){
		double price = (super.getSalary()*10) + (super.getExpYears()*100) + (championshipsWon*50);
		return price;
	}//End calculatePrice
	/**
	* calculates the MainCoach level. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> MainCoach level has been calculated.<br>
	*/
	@Override
	public double calculateLevel(){
		double level = 5 + (championshipsWon/10.0);
		return level;
	}//End calculateLevel
	/**
	* saves the MainCoach info on a string.<br>
	* <b>pre:</b> name, id, salary, expYears, numberTeams and championshipsWon are initialized.<br>
	* <b>post:</b> String with the MainCoach info.<br>
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "\nEquipos dirigidos: " + numberTeams +
					"\nCampeonatos ganados: " + championshipsWon;
		return obj;
	}//End toString
}//End MainCouch