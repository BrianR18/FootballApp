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
		boolean check = true;
		for(Tactic tactics: t){
			if(!tacticName.equals(t.toString()))
				check = false;
		}//End for
		return check;
	}//End checktTatics
	
	public boolean checkExpertiseEnum(String expertiseName){
		boolean check = true;
		for(Expertise expertises: e){
			if(!expertiseName.equals(e.toString()))
				check = false;
		}//End for
		return check;
	}//End checkExpertise
	
	public boolean checkPositionEnum(String PositionName){
		boolean check = true;
		for(Position position: p){
			if(!PositionName.equals(p.toString()))
				check = false;
		}//End for
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
		for(Expertise expertise: t){
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