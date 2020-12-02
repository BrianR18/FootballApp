package model;

public class MainCouch extends Couch implements Calculable{
	private int numberTeams;
	private int championshipsWon;
	
	public MainCouch(){
		super();
		numberTeams = 0;
		championshipsWon = 0;
	}//End constructor1
	
	public MainCouch(String name, String id, double salary, boolean state,int expYear, int numberTeams, int championshipsWon){
		super(name,id,salary,state,expYear);
		this.numberTeams = numberTeams;
		this.championshipsWon = championshipsWon;
	}//End constructor2
	
	public void setNumberTeams(int numberTeams){
		this.numberTeams = numberTeams;
	}//End setNumberTeams
	
	public int getNumberTeams(){
		return numberTeams;
	}//End getNumberTeams
	
	public void setChampionshipWon(int championshipsWon){
		this.championshipsWon = championshipsWon;
	}//End setChampionshipWon
	
	public int getChampionshipWon(){
		return championshipsWon;
	}//End getChampionshipWon
	
	@Override
	public double calculatePrice(){
		double price = (super.getSalary()*10) + (super.expYear()*100) + (championshipsWon*50);
		return price;
	}//End calculatePrice
	
	@Override
	public double calculateLevel(){
		double level = 5 + (championshipsWon/10.0);
		return level;
	}//End calculateLevel
	
	@Override
	public String toString(){
		String obj = super.toString() + "\nEquipos dirigidos: " + numberTeams +
					"\nCampeonatos ganados: " + championshipsWon;
		return obj;
	}//End toString
}//End MainCouch