package model;
import java.util.ArrayList;

/**
* @author Brian Romero<br>
*/
public class AssistCoach extends Coach{
	private boolean explayer;
	private ArrayList<Expertise> expertises;
	
	public AssistCoach(){
		super();
		explayer = false;
		expertises = new ArrayList<Expertise>();
		expertises.add(Expertise.OFENSIVO);
	}//End AssistCouch
	/**
	* constructor of the AssistCoach class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> AssistCoach class object created.<br>
	* @param name. AssistCoach name. name != null. name != "".<br>
	* @param id. AssistCoach id. id != null.<br>
	* @param salary. AssistCoach salary. salary > 0. <br>
	* @param state. AssistCoach state. state is initialized<br>
	* @param expYears. AssistCoach experience years. years >= 0.<br>
	* @param explayer. AssistCoach professionalPlayer info. professionalPlayer is initialized.<br>
	*/
	public AssistCoach(String name, String id, double salary, boolean state,int expYears, boolean explayer){
		super(name,id,salary,state,expYears);
		expertises = new ArrayList<Expertise>();
		this.explayer = explayer;
	}//End AssistCouch
	/**
	* changes the AssistCoach professionalPlayer info.<br>
	* <b>pre:</b> professionalPlayer is initialized.<br>
	* <b>post:</b> AssistCoach professionalPlayer has been changed.<br>
	* @param ex. AssistCoach professionalPlayer info. professionalPlayer is initialized<br>
	*/
	public void setExplayer(boolean ex){
		explayer = ex;
	}//End setExplayer
	/**
	* returns the AssistCoach professionalPlayer info.<br>
	* <b>pre:</b> professionalPlayer is initialized.<br>
	* <b>post:</b> professionalPlayer.<br>
	* @return Return if the AssistCoach is or isn't a ex-player.<br>
	*/
	public boolean getExplayer(){
		return explayer;
	}//End getExplayer
	/**
	* add the AssistCoach expertise.<br>
	* <b>pre:</b> expertise is initialized.<br>
	* <b>post:</b> expertise has been changed.<br>
	* @param expertise. AssistCoach set of expertise. expertise is initialized<br>
	*/
	public void addExpertise(String expertise){
		if(!checkExpertise(expertise))
		   this.expertises.add(Expertise.valueOf(expertise));
	}//End setExpertise
	/**
	* returns the AssistCoach expertise.<br>
	* <b>pre:</b> expertise is initialized.<br>
	* <b>post:</b> expertises.<br>
	*  @return Return the AssistCoach expertises<br>
	*/
	public String getExpertise(){
		String exp = new String();
		for(Expertise e: expertises){
			exp += "-"+ e;
		}//End for
		return exp;
	}//End getExpertise
	/**
	* Check if the expertise entered does not already exist.<br>
	* <b>pre:</b> expertise is initialized.<br>
	* <b>post:</b> expertises.<br>
	*  @return Returns whether the expertise exists or not <br>
	*/
	public boolean checkExpertise(String expertise){
		boolean check = false;
		for(int i = 0; i < expertises.size() && !check; i++){
			if(expertise.equals(expertises.get(i).toString()))
		      check = true;
		}//End for
		return check;
	}//End checkExpertise
	/**
	* saves the AssistCoach info in a String.<br>
	* <b>pre:</b> name, id, salary, state, expYears, ex-player and expertise are initialized.<br>
	* <b>post:</b> AssistCoach info in a String.<br>
	* @return Return a string representation of the AssistCoach
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "\nExperticia: " + getExpertise() + 
					"\nEx-jugador: " + ((explayer)?"si":"no");
		return obj;
	}//End toString
}//End AssistCouch