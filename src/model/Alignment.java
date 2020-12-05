package model;
/**
* @author Brian Romero
*/
public class Alignment{
	private Date date;
	private int ROWS = 10;
	private int COLUMNS = 7;
	private int[][] training;
	private Tactic tactic;
	private String trainingcamp;
	/**
	* Constructor of the Alignment class. <br>
	* <b>pre:</b> <br>
	* <b>post:</b> Alignment class object created.
	*/
	public Alignment(){
		date = new Date();
		training = new int[ROWS][COLUMNS];
		tactic = Tactic.POR_DEFECTO;
	}//End constructor1
	/**
	* Changes the date of the Alignment.<br>
	* <b>pre:</b> date is initialized.<br>
	* <b>post:</b> date has been changed.<br>
	* @param day. New Alignment day. day != null. day != "".
	* @param month. New Alignment month. month != null. month != "".
	* @param year. New Alignment year. year != null. year != "".
	* @return Return if the date is correct
	*/
	public boolean addDate(int day,int month, int year){
		boolean add = date.setDate(day,month,year);
		return add;
	}//End addDate
	/**
	* add the tactic of the Alignment.<br>
	* <b>pre:</b> tactic is initialized.<br>
	* <b>post:</b> tactic has been changed.<br>
	* @param tactic. New Alignemnt tactic. tactic != null. tactic != "".
	*/
	public void addTactic(String tactic){
		this.tactic = Tactic.valueOf(tactic);
	}//End addTactic
	/**
	* returns the tactic of the Alignment.<br>
	* <b>pre:</b> tactic is initialized. tactic is not null.<br>
	* <b>post:</b> tactic of the Alignemnt.<br>
	* @return Return the tactics
	*/
	public String getTactic(){
		return tactic.toString();
	}//End getTactic
	/**
	* add the formation to the matrix<br>
	* <b>pre:</b> training is initialized. <br>
	* <b>post:</b> training in a specific format. <br>
	* @param t Training to add <br>
	*/
	public void addTraining(String t){
		int[] numbers = getTrainingFromString(t);
		int index = 0;
		for(int i = 2; i < ROWS; i+=3){
			for(int j = 1; j < (COLUMNS -1); j++){
				if(numbers[index] > 0){
					training[i][j] = 1;
				}//End if
				numbers[index]--;
			}//End for1
			index++;
		}//End for
	}//End addTraining*/
	
	public String displayTraining(){
		String t = new String();
		for(int i = 0; i < ROWS; i++){
			for(int j = 0; j < COLUMNS; j++){
				t += "[" + training[i][j] + "]";
			}//End for1
			t+= "\n";
		}//End for2
		return t;
	}//End displayTraining
	/**
	* converts the training Matrix to a format. <br>
	* <b>pre:</b> training is initialized. <br>
	* <b>post:</b> training in a specific format. <br>
	* @return Return the training as a String
	*/
	public String getTrainingString(){
		String t = new String();
		int players = 0; //Saves the amount of players in each position.
		for(int i = 2; i < ROWS; i+=3){
			for(int j = 1; j < (COLUMNS -1); j++){
				if(training[i][j] == 1){
					players++;
				}
			}//End for
			t += ((i+3 < ROWS)?players+"-":String.valueOf(players));
			players = 0;
		}//End for
		return t;
	}//End getTrainingString*/
	/**
	* transform string training into numeric.<br>
	* <b>pre:</b> training is initialized.<br>
	* <b>post:</b> training has been changed.<br>
	* @param s. New Alignemnt training. s != null. s != "".
	* @return Return the training in numeric format.
	*/
	private int[] getTrainingFromString(String s){
		final int l = (int) Math.ceil(s.length()/2.0);
        int[] numbers = new int[l];
        int index = 0;
        for(int i = 0; i < s.length(); i += 2){
            numbers[index] = Integer.parseInt(Character.toString(s.charAt(i)));
			index++;
        }//End for
		return numbers;
	}//End getNumbersFromString
	/**
	* display the Alignemnt info on a String. <br>
	* <b>pre:</b>date, tactic, and fieldFormation are initialized. <br>
	* <b>post:</b>info of the alignment. <br>
	* @return Return a string representation of the Alignemnt
	*/
	public String toString(){
		String obj = "Fecha de la alineacion: " + date.toString() + "\n" +
		"Tactica de la alineacion: " + getTactic() + "\n" +
		"Formacion: " + getTrainingString();
		return obj;
	}//End toString.
}//End Alignment