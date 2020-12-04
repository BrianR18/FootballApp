package model;
import java.util.ArrayList;

public class AssistCouch extends Couch{
	private boolean explayer;
	private ArrayList<Expertise> expertises;
	
	public AssistCouch(){
		super();
		explayer = false;
		expertises = new ArrayList<Expertise>();
		expertises.add(Expertise.OFENSIVO);
	}//End AssistCouch
	
	public AssistCouch(String name, String id, double salary, boolean state,int expYears, boolean explayer){
		super(name,id,salary,state,expYears);
		expertises = new ArrayList<Expertise>();
		this.explayer = explayer;
	}//End AssistCouch
	
	public void setExplayer(boolean ex){
		explayer = ex;
	}//End setExplayer
	
	public boolean getExplayer(){
		return explayer;
	}//End getExplayer
	
	public void addExpertise(String expertise){
		if(!checkExpertise(expertise))
		   this.expertises.add(Expertise.valueOf(expertise));
	}//End setExpertise
	
	public String getExpertise(){
		String exp = new String();
		for(Expertise e: expertises){
			exp += "-"+ e;
		}//End for
		return exp;
	}//End getExpertise
	
	public boolean checkExpertise(String expertise){
		boolean check = false;
		for(int i = 0; i < expertises.size() && !check; i++){
			if(expertise.equals(expertises.get(i).toString()))
		      check = true;
		}//End for
		return check;
	}//End checkExpertise
	
	@Override
	public String toString(){
		String obj = super.toString() + "\nExperticia: " + getExpertise() + 
					"\nEx-jugador: " + ((explayer)?"si":"no");
		return obj;
	}//End toString
}//End AssistCouch