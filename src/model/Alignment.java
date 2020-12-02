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
	
	public void addTraining(String training){
		int[] numbers = getTrainingFromString(training);
		int index = 0;
		for(int i = 2; i < ROWS; i+=3){
			for(int j = 1; j < (COLUMNS -1); j++){
				if(numbers[i] > 0){
					training[i][j] = 1;
				}//End if
			}//End for1
			index++;
		}//End for2
	}//End addTraining
	
	public String displayTraining(){
		String t = new String();
		for(int i = 0; i < ROW; i++){
			for(int j = 0; j < COLUMNS; j++){
				t += "[" + training[i][j] + "]";
			}//End for1
			t+= "\n";
		}//End for2
		return t;
	}//End displayTraining
	
	public void getTrainingString(){
		String t = new String();
		int player;
		for(int i = 2; i < ROWS; i+=3){
			player = 0;
			for(int j = 1; j < (COLUMNS -1); j++){
				if(numbers[i] > 0){
					player++;
				}//End if
			}//End for1
			t += ((i+3) < ROWS)?player + "-":player;
		}//End for2
		return t;
	}//End getTrainingString
	
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
}//End Alignment