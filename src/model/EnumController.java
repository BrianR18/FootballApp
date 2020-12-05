package model;
/**
* @author Brian Romero
*/
public class EnumController{
	
	private Tactic[] t;
	private Expertise[] e;
	private Position[] p;
	/**
	* Constructor of the Team class.<br>
	* <b>pre:</b><br>
	* <b>post:</b>.<br>
	*/
	public EnumController(){
		t = Tactic.values();
		e = Expertise.values();
		p = Position.values();
	}//End constructor
	/**
	* Check if the input is a valid tactic.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param tacticName. input to search. tactic != null
	*/
	public boolean checktTaticsEnum(String tacticName){
		boolean check = false;
		if(t[0] != null){
			Tactic tactics = t[0];
			for(int i = 0; i < t.length && !check; i++){
				tactics = t[i];
				if(tacticName.equals(tactics.toString()))
					check = true;
			}//End for
		}//End if
		return check;
	}//End checktTatics
	/**
	* Check if the input is a valid expertise.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param expertiseName. input to search. tactic != null
	*/
	public boolean checkExpertiseEnum(String expertiseName){
		boolean check = false;
		if(e[0] != null){
			Expertise expertises = e[0];
			for(int i = 0; i < e.length && !check; i++){
				expertises = e[i];
				if(expertiseName.equals(expertises.toString()))
					check = true;
			}//End for	
		}
		return check;
	}//End checkExpertise
	/**
	* Check if the input is a valid position.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param positionName. input to search. tactic != null
	*/
	public boolean checkPositionEnum(String positionName){
		boolean check = false;
		if(p[0] != null){
			Position position = p[0];
			for(int i = 0; i < p.length && !check; i++){
				position = p[i];
				if(positionName.equals(position.toString()))
					check = true;
			}//End for
		}//End if
		return check;
	}//End checkExpertise
	/**
	* display the tacticsEnum.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	*/
	public String displayTacticsEnum(){
		String tacticsEnum = new String();
		for(Tactic tactics: t){
		   tacticsEnum += "-" + removeUnderscores(tactics.toString()) + "\n";
		}//End for
		return tacticsEnum;
	}//End displayTacticsEnum
	/**
	* display the positionEnum.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	*/
	public String displayPositionEnum(){
		String positionEnum = new String();
		for(Position position: p){
		   positionEnum += "-" + removeUnderscores(position.toString()) + "\n";
		}//End for
		return positionEnum;
	}//End displayTacticsEnum
	/**
	* display the expertiseEnum.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	*/
	public String displayExpertiseEnum(){
		String expertiseEnum = new String();
		for(Expertise expertise: e){
		   expertiseEnum += "-" + removeUnderscores(expertise.toString()) + "\n";
		}//End for
		return expertiseEnum;
	}//End displayTacticsEnum
	/**
	* Remove the underscores of the enum string representation.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	* @param string String representation of the enum, string != null.
	*/
	private String removeUnderscores(String string){
		String newString = new String();
		for(int i = 0; i < string.length(); i++){
			newString += (string.charAt(i) != '_')?string.charAt(i):' ';
		}//End for
		return newString;
	}//End removeUnderscores
	/**
	* adds the underscores of the string.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	* @param string user input, string != null.
	*/
	public String addUnderscores(String string){
		String newString = new String();
		string = string.toUpperCase();
		for(int i = 0; i < string.length(); i++){
			newString += (string.charAt(i) != ' ')?string.charAt(i):'_';
		}//End for
		return newString;
	}//End addUnderscores
	
}//End EnumController.