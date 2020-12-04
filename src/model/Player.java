package model;

public class Player extends Employee implements Calculable{
	private int shirtNumber;
	private int goals;
	private double averageScore;
	private Position position;
	public Player(){
		super();
		shirtNumber = 0;
		goals = 0;
		averageScore = 0;
		position = Position.BANCA;
	}//End contructor1
	
	public Player(String name, String id, double salary, boolean state, int shirtNumber, int goals, double averageScore){
		super(name,id,salary,state);
		this.shirtNumber = shirtNumber;
		this.goals = goals;
		this.averageScore = averageScore;
	}//End contructor2
	
	public void setShirtNumber(int number){
		shirtNumber = number;
	}//End setShirtNumber
	
	public int getShirtNumber(){
		return shirtNumber;
	}//End getShirtNumber
	
	public void setGoals(int goals){
		this.goals = goals;
	}//End setGoals
	
	public int getGoals(){
		return goals;
	}//End getGoals
	
	public void setAverageScore(double score){
		averageScore = score;
	}//End setAverageScore
	public double getAverageScore(){
		return averageScore;
	}//End getAverageScore
	
	public void setPosition(String position){
		this.position = Position.valueOf(position);
	}//End setPosition
	
	public String getPosition(){
		return position.toString();
	}//End getPosition
	
	@Override
	public double calculatePrice(){
		double price = 0;
		switch(position){
			case PORTERO:
				price = (super.getSalary()*12) + (averageScore*150);
				break;
			case DEFENSOR:
				price = (super.getSalary()*13) + (averageScore*125) + (goals*100);
				break;
			case VOLANTE:
				price = (super.getSalary()*14) + (averageScore*135) + (goals*125);
				break;
			case DELANTERO:
				price = (super.getSalary()*15) + (averageScore*145) + (goals*150);
				break;
		}//End switch
		return price;
	}//End calculatePrice
	
	@Override
	public double calculateLevel(){
		double level = 0;
		switch(position){
			case PORTERO:
				level = averageScore*0.9;
				break;
			case DEFENSOR:
				level = (averageScore*0.9) + (goals/100.0);
				break;
			case VOLANTE:
				level = (averageScore*0.9) + (goals/90.0);
				break;
			case DELANTERO:
				level = (averageScore*0.9) + (goals*80.0);
				break;
		}//End switch
		return level;
	}//End calculateLevel
	
	@Override
	public String toString(){
		String obj = super.toString() + "\nNumero de camiseta: " + shirtNumber + "\n" +
					"Numero de goles hechos: " + goals + "\n" + "Calificacion promedio: " + averageScore
					+ "\nPosicion: " + position.toString();
		return obj;
	}//End toString
}//End Player