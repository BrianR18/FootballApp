package model;

public class EnumController{
	
	private Tactic[] t;
	private Expertise[] e;
	private Position[] p;
	
	public EnumController(){
		t = Tactic.values();
		e = Expertise.values();
		p = Position.values();
	}//End constructor
	
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
	
	public String displayTacticsEnum(){
		String tacticsEnum = new String();
		for(Tactic tactics: t){
		   tacticsEnum += "-" + removeUnderscores(tactics.toString()) + "\n";
		}//End for
		return tacticsEnum;
	}//End displayTacticsEnum
	
	public String displayPositionEnum(){
		String positionEnum = new String();
		for(Position position: p){
		   positionEnum += "-" + removeUnderscores(position.toString()) + "\n";
		}//End for
		return positionEnum;
	}//End displayTacticsEnum
	
	public String displayExpertiseEnum(){
		String expertiseEnum = new String();
		for(Expertise expertise: e){
		   expertiseEnum += "-" + removeUnderscores(expertise.toString()) + "\n";
		}//End for
		return expertiseEnum;
	}//End displayTacticsEnum
	
	private String removeUnderscores(String string){
		String newString = new String();
		for(int i = 0; i < string.length(); i++){
			newString += (string.charAt(i) != '_')?string.charAt(i):' ';
		}//End for
		return newString;
	}//End removeUnderscores
	
	public String addUnderscores(String string){
		String newString = new String();
		string = string.toUpperCase();
		for(int i = 0; i < string.length(); i++){
			newString += (string.charAt(i) != ' ')?string.charAt(i):'_';
		}//End for
		return newString;
	}//End addUnderscores
	
}//End EnumController.