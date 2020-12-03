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
	
	public boolean setMainCouch(MainCouch couch){
		boolean set = false;
		if(couch != null){
			mainCouch = couch;
			set = true;
		}//End if
		return set;
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
	
}//End Team