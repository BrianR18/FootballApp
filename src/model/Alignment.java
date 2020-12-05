package model;

public class Alignment{
	private Date date;
	private int ROWS = 10;
	private int COLUMNS = 7;
	private int[][] training;
	private Tactic tactic;
	private String trainingcamp;
	
	public Alignment(){
		date = new Date();
		training = new int[ROWS][COLUMNS];
		tactic = Tactic.POR_DEFECTO;
	}//End constructor1
	
	public boolean addDate(int day,int month, int year){
		boolean add = date.setDate(day,month,year);
		return add;
	}//End addDate
	
	public void addTactic(String tactic){
		this.tactic = Tactic.valueOf(tactic);
	}//End addTactic
	public String getTactic(){
		return tactic.toString();
	}//End getTactic
	
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
	
	public String toString(){
		String obj = "Fecha de la alineacion: " + date.toString() + "\n" +
		"Tactica de la alineacion: " + getTactic() + "\n" +
		"Formacion: " + getTrainingString();
		return obj;
	}//End toString.
}//End Alignment