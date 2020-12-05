package model;
import java.util.ArrayList;

public class Team{
	private String name;
	private MainCouch mainCouch;
	private AssistCouch[] assistCouches;
	private Player[] players;
	private ArrayList<Alignment> alignments;
	private int ASSISTCOUCH = 3;
	private int PLAYERS = 25;
	
	public Team(){
		name = new String();
		mainCouch = new MainCouch();
		assistCouches = new AssistCouch[ASSISTCOUCH];
		players = new Player[PLAYERS];
		alignments = new ArrayList<Alignment>();
	}//End Team
	
	public Team(String name){
		this.name = name;
		mainCouch = new MainCouch();
		assistCouches = new AssistCouch[ASSISTCOUCH];
		players = new Player[PLAYERS];
		alignments = new ArrayList<Alignment>();
	}//End Team
	
	public String getName(){
		return name;
	}//End getName
	
	public void setMainCouch(MainCouch couch){
			mainCouch = couch;
	}//End setMainCouch
	
	public boolean addAssistCouch(AssistCouch couch){
		boolean add = false;
		for(int i = 0; i < ASSISTCOUCH && !add; i++){
			if(assistCouches[i] == null){
				assistCouches[i] = couch;
				add = true;
			}//End if
		}//End for
		return add;
	}//End addAssistCouch
	
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
	
	public void removeAssistCouch(String id){
		boolean found = false;
		for(int i = 0; i < ASSISTCOUCH && !found; i++){
			if(id.equals(assistCouches[i].getId())){
				assistCouches[i] = null;
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
	
	public String displayAlignments(){
		String alignment = new String();
		for(int i = 0; i < alignments.size();i++){
			alignment += "["+(i+1)+"]"+alignments.get(i).getTrainingString()+"\n";
		}//End for
		return alignment;
	}//End displayAlignments
	
	public String displayAlignmentTraining(int i){
		String training = "["+i+"]No esta dentro del rango de opciones";
		if( i >= 0 && i < alignments.size() )
		  training = alignments.get(i).displayTraining();
		return training;
	}//End displayAlignmentTraining
	
	public String toString(){
		String obj = "Nombre del equipo: " + name + "\n" +
		"Entrenador principal: " + ( (mainCouch != null) ? mainCouch.getName() :"Sin asignar" ) + 
		"\n"+ "Asistentes tecnicos: ";
		for(int i = 0; i < ASSISTCOUCH; i++ ){
			if(assistCouches[i] != null){
				obj += assistCouches[i].getName();
			}//End if
			if((i+1 < ASSISTCOUCH))
				obj += (assistCouches[i+1] != null)?", ":"";
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