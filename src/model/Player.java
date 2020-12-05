package model;
/**
* @author Brian Romero
*/
public class Player extends Employee implements Calculable{
	//Attributes
	private int shirtNumber;
	private int goals;
	private double averageScore;
	private Position position;
	private double level; 
	private double price;
	
	public Player(){
		super();
		shirtNumber = 0;
		goals = 0;
		averageScore = 0;
		position = Position.BANCA;
		level = calculateLevel();
		price = calculatePrice();
	}//End contructor1
	/**
	* constructor of the Player class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Player class object created.<br>
	* @param name. Player name. name != null. name != "".
	* @param id. Player id. id != null.
	* @param salary. Player salary. salary > 0. 
	* @param state. Player state. state is initialized.
	* @param shirtNumber. Player shirtNumber . shirtNumber >= 0.
	* @param goals. Player goals. goals >= 0.
	* @param averageScore. Player average score >= 0.
	*/
	public Player(String name, String id, double salary, boolean state, int shirtNumber, int goals, double averageScore){
		super(name,id,salary,state);
		this.shirtNumber = shirtNumber;
		this.goals = goals;
		this.averageScore = averageScore;
		level = calculateLevel();
		price = calculatePrice();
	}//End contructor2
	/**
	* changes the Player t-shirt number.<br>
	* <b>pre:</b> number is initialized.<br>
	* <b>post:</b> Player number has been changed.<br>
	* @param number. New Player t-shirt number. number is initialized
	*/
	public void setShirtNumber(int number){
		shirtNumber = number;
	}//End setShirtNumber
	/**
	* returns the Player t-shirt number.<br>
	* <b>pre:</b> number is initialized.<br>
	* <b>post:</b> Player number.<br>
	*/
	public int getShirtNumber(){
		return shirtNumber;
	}//End getShirtNumber
	/**
	* changes the Player amount of goals.<br>
	* <b>pre:</b> goals is initialized.<br>
	* <b>post:</b> Player amount of goals have been changed.<br>
	* @param goals. New Player goals. goals >= 0
	*/
	public void setGoals(int goals){
		this.goals = goals;
	}//End setGoals
	/**
	* returns the Player amount of goals.<br>
	* <b>pre:</b> goals is initialized.<br>
	* <b>post:</b> Player amount of goals.<br>
	*/
	public int getGoals(){
		return goals;
	}//End getGoals
	/**
	* changes the Player average score.<br>
	* <b>pre:</b> averageScore is initialized.<br>
	* <b>post:</b> Player averageScore has been changed.<br>
	* @param score. New Player average score. averageScore >= 0
	*/
	public void setAverageScore(double score){
		averageScore = score;
	}//End setAverageScore
	/**
	* returns the Player average score.<br>
	* <b>pre:</b> average is initialized.<br>
	* <b>post:</b> Player average score.<br>
	*/
	public double getAverageScore(){
		return averageScore;
	}//End getAverageScore
	/**
	* changes the Player position.<br>
	* <b>pre:</b> position is initialized.<br>
	* <b>post:</b> postion has been changed.<br>
	* @param position. New player position. position != null. position != ""
	*/
	public void setPosition(String position){
		this.position = Position.valueOf(position);
	}//End setPosition
	/**
	* returns the Player position.<br>
	* <b>pre:</b> position is initialized.<br>
	* <b>post:</b> Player position.<br>
	*/
	public String getPosition(){
		return position.toString();
	}//End getPosition
	/**
	* calculates the Player market price. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Player market price.<br>
	*/
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
	/**
	* calculates the level of a employee. <br>
	* <b>pre:</b> .<br>
	* <b>post:</b> employee level has been calculated.<br>
	*/
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
	/**
	* saves the Player info in a String.<br>
	* <b>pre:</b> name, id, salary, state, teamName, shirtNumber, goals, averageScore and position are initialized.<br>
	* <b>post:</b> Player info in a String.<br>
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "\nNumero de camiseta: " + shirtNumber + "\n" +
					"Numero de goles hechos: " + goals + "\n" + "Calificacion promedio: " + averageScore
					+ "\nPosicion: " + position.toString() + "\nPrecio de mercado: " + price + "\nNivel del jugador: "+ level;
		return obj;
	}//End toString
}//End Player