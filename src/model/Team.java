package model;
import java.util.ArrayList;
/**
* @author Brian Romero
*/
public class Team{
	private String name;
	private MainCoach mainCoach;
	private AssistCoach[] assistCoaches;
	private Player[] players;
	private ArrayList<Alignment> alignments;
	private int ASSISTCOACH = 3;
	private int PLAYERS = 25;
	/**
	* Constructor of the Team class.<br>
	* <b>pre:</b><br>
	* <b>post:</b> Team class object has been created.<br>
	*/
	public Team(){
		name = new String();
		mainCoach = new MainCoach();
		assistCoaches = new AssistCoach[ASSISTCOACH];
		players = new Player[PLAYERS];
		alignments = new ArrayList<Alignment>();
	}//End Team
	/**
	* Constructor of the Team class.<br>
	* <b>pre:</b> name is initialized. name != null<br>
	* <b>post:</b> Team class object has been created.<br>
	* @param name. Team name. name != null
	*/
	public Team(String name){
		this.name = name;
		mainCoach = new MainCoach();
		assistCoaches = new AssistCoach[ASSISTCOACH];
		players = new Player[PLAYERS];
		alignments = new ArrayList<Alignment>();
	}//End Team
	/**
	* returns the Team name.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> Team name.<br>
	* @return Return a team name
	*/
	public String getName(){
		return name;
	}//End getName
	/**
	* changes the Team MainCoach.<br>
	* <b>pre:</b> MainCoach is initialized.<br>
	* <b>post:</b> Team MainCoach has been changed.<br>
	* @param coach. New Team MainCoach. MainCoach != null
	*/
	public void setMainCoach(MainCoach coach){
			mainCoach = coach;
	}//End setMainCouch
	/**
	* adds a AssistCoach to the Team.<br>
	* <b>pre:</b> AssistCoach is initialized.<br>
	* <b>post:</b> a new AssistCoach has been added to the Team.<br>
	* @param coach. New Team AssistCoach. coach != null
	*/
	public boolean addAssistCoach(AssistCoach coach){
		boolean add = false;
		for(int i = 0; i < ASSISTCOACH && !add; i++){
			if(assistCoaches[i] == null){
				assistCoaches[i] = coach;
				add = true;
			}//End if
		}//End for
		return add;
	}//End addAssistCouch
	/**
	* adds a player to the team.<br>
	* <b>pre:</b> player != null.<br>
	* <b>post:</b> a new player has been added to the Team.<br>
	* @param player. New Player to add. player != null
	*/
	public boolean addPlayer(Player player){
		boolean add = false;
		for(int i = 0; i < PLAYERS && !add; i++){
			if(players[i] == null){
				players[i] = player;
				add = true;
			}//End if
		}//End for
		return add;
	}//End addPlayer
	
	public void removeAssistCoach(String id){
		boolean found = false;
		for(int i = 0; i < ASSISTCOACH && !found; i++){
			if(id.equals(assistCoaches[i].getId())){
				assistCoaches[i] = null;
				found = true;
			}//End if
		}//End for
	}//End removeAssistCouch
	
	public void removePlayer(String id){
		boolean found = false;
		for(int i = 0; i < PLAYERS && !found; i++){
			if(players[i] != null ){
				if( id.equals(players[i].getId()) ){
					players[i] = null;
					found = true;
				}//End if
			}//End if
		}//End for
	}//End removeAssistCouch
	/**
	* adds an alignment to the Team.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new alignment has been added to the Team.<br>
	* @param day. Alignment date. Alignment date. date != null<br>
	* @param month. Alignment date. Alignment date. date != null<br>
	* @param year. Alignment date. Alignment date. date != null<br>
	* @param tactic. Alignment tactic. tactic != null<br>
	* @param training. Alignment training. training != null<br>
	*/
	public boolean addTraining(int day, int month, int year,String tatic, String training){
		boolean status = false;
		Alignment alignment = new Alignment();
		status = alignment.addDate(day,month,year);
		if(status){
			alignment.addTactic(tatic);
			alignment.addTraining(training);
			alignments.add(alignment);
		}//End if
		return status;
	}//End addTraining.*/
	/**
	* Display the alignments info in a String.<br>
	* <b>pre:</b> alignments is initialized.<br>
	* <b>post:</b> alignments info in a String.<br>
	* @return Return all alignments.
	*/
	public String displayAlignments(){
		String alignment = new String();
		for(int i = 0; i < alignments.size();i++){
			alignment += "["+(i+1)+"]"+alignments.get(i).getTrainingString()+"\n";
		}//End for
		return alignment;
	}//End displayAlignments
	/**
	* Display training in the field.<br>
	* <b>pre:</b>training is initialized.<br>
	* <b>post:</b>.<br>
	* @return Return the training in the field.
	*/
	public String displayAlignmentTraining(int i){
		String training = "["+i+"]No esta dentro del rango de opciones";
		if( i >= 0 && i < alignments.size() )
		  training = alignments.get(i).displayTraining();
		return training;
	}//End displayAlignmentTraining
	/**
	* Display the Team info in a String.<br>
	* <b>pre:</b> name, headCoach, technicalAssistants, players and alignments are initialized.<br>
	* <b>post:</b> Team info in a String.<br>
	*/
	public String toString(){
		String obj = "Nombre del equipo: " + name + "\n" +
		"Entrenador principal: " + ( (mainCoach != null) ? mainCoach.getName() :"Sin asignar" ) + 
		"\n"+ "Asistentes tecnicos: ";
		for(int i = 0; i < ASSISTCOACH; i++ ){
			if(assistCoaches[i] != null){
				obj += assistCoaches[i].getName();
			}//End if
			if((i+1 < ASSISTCOACH))
				obj += (assistCoaches[i+1] != null)?", ":"";
		}//End for
		obj += "\nJugadores: ";
		for(int i = 0; i < PLAYERS; i++ ){
			if(i%5 == 0)
			   obj += "\n";
			if(players[i] != null){
				obj += players[i].getName();
			}//End if
			if(i+1 < PLAYERS)
				obj += (players[i+1] != null)?" - ":"";
		}//End for
		obj += "\nAlineaciones del equipo...\n";
		for(int i = 0; i < alignments.size(); i++){
			obj += alignments.get(i).toString() + "\n";
		}//End for
		return obj;
	}//End toString
}//End Team