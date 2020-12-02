package model;
import java.util.Random;

public class Club{
	private String name;
	private String NIT;
	private Date date;
	private String[][] dressingRoom1;
	private String[][] dressingRoom2;
	private String[][] offices;
	private Team[] teams;
	private EnumController controller;
	private ArrayList<Employee> employees;
	private Random choice;
	
	public Club(){
		name = new String();
		NIT = new String();
		date = new Date();
		choice = new Random();
		controller = new EnumController();
		dressingRoom1 = new String[7][6];
		dressingRoom2 = new String[7][7];
		offices = new String[6][6];
		teams = new Team[2];
		Team[0] =  new Team("A");
		Team[1] =  new Team("B");
	}//End constructors1
	
	public Club(String name, String NIT){
		this.name = name;
		this.NIT = NIT;
		date = new Date();
		choice = new Random();
		controller = new EnumController();
		dressingRoom1 = new String[7][6];
		dressingRoom2 = new String[7][7];
		offices = new String[6][6];
		teams = new Team[2];
		Team[0] =  new Team("A");
		Team[1] =  new Team("B");
	}//End constructors2
	
	public boolean addDate(int day, int month, int year){
		boolean add = date.setDate(day,month,year);
		return add;
	}//End addDate
	
	public void	setName(String name){
		this.name = name;
	}//End setName
	
	public void setNIT(String NIT){
		this.NIT = NIT;
	}//End setNIT
	
	public String hireEmployee(String name,String id,double salary,boolean state,int expYears,int nTeams,int CSWon){
		String msg = "Empleado contratado con exito.";
		Employee mainCouch = new MainCouch(name,id,salary,state,expYears,nTeams,CSWon);
		employees.add(mainCouch);
		return msg;
	}//End hireEmployee.
	
	public String hireEmployee(String name,String id,double salary,boolean state,int expYears,boolean exPlayer,String expertise){
		String msg = "No se ha podido contratar al empleado.";
		expertise = controller.addUnderscores(expertise);
		if(controller.checkExpertiseEnum(expertise)){
			Employee assisteCouch = new AssistCouch(name,id,salary,state,exPlayer);
			assisteCouch.addExpertise(expertise);
			employees.add(assisteCouch);
			msg = "Empleado contratado con exito.";
		}//End if
	}//End hireEmployee.
	
	public String hireEmployee(String name,String id,double salary,boolean state,int shirt,int goals,double averageScore,String position){
		String msg = "No se ha podido contratar al empleado.";
		if(controller.checkPositionEnum(position)){
		  Employee player = new Player(name,id,salary,state,shirt,goals,averageScore);
		  player.setPosition(position);
		  employees.add(player);
		  msg = "Empleado contratado con exito.";
		}//End if
		return msg;
	}//End hireEmployee.
	
	public String fireEmployee(String id){
		String msg = "No se ha podido despedir al empleado. ID erroneo.";
		int index = findId(id);
		if(index != -1){
			employees.remove(index);
			msg = "Se ha despedido al empleado correctamente.";
		}//if
		return msg;
	}//End fireEmployee
	
	public String addEmployeeToTeam(String id, String teamName){
		int team = findTeam(teamName);
		int employee = findId(id);
		boolean state = false;
		String msg;
		if( (team != -1) && (employee != -1) ){
			if( employees.get(employee) instanceof MainCouch){
				MainCouch mCouch = (MainCouch)employees.get(employee);
				teams[team].setMainCouch(mCouch);
			}//End if1
			else if( employees.get(employee) instanceof AssistCouch ){
				AssistCouch aCouch = (AssistCouch)employees.get(employee);
				teams[team].addAssistCouch(aCouch);
			}//End if2
			else{
				Player player = (Player)employees.get(employee);
				teams[team].addPlayer(player);
			}//End else
		}//End if
		msg = (state)?"Se ha agregado el empleado al equipo.":"No se ha agregado el empleado al equipo.";
		return msg;
	}//End addEmployeeToTeam.
	
	public String addTrainingToTeam(String teamName,int day, int month,int year,String tactic,String training){
		String msg = "No se pudeo agregar la formacion al equipo, datos erroneos.";
		int index = findTeam(teamName);
		tactic = controller.addUnderscores(tactic);
		if( (index != -1) && (controller.checktTaticsEnum(tactic)) ){
			if(teams[index].addTraining(day,month,year,tactic,training)){
				msg = "Se agrego la formacion correctamente.";
			}//End if
		}//End if
		return msg;
	}//End addAlignmentToTeam
	
	public String displayTacticsEnum(){
		String msg = controller.displayTacticsEnum();
		return msg;
	}//End displayTacticsEnum
	
	public String displayPositionEnum(){
		String msg = controller.displayPositionEnum();
		return msg;
	}//End displayTacticsEnum
	
	public String displayExpertiseEnum(){
		String msg = controller.displayExpertiseEnum();
		return msg;
	}//End displayTacticsEnum
	
	public void fillDressingRoom
	
	public int findTeam(String name){
		int index = -1;
		boolean found = false;
		for(int i = 0; i < teams.length && !index; i++ ){
			if(name.equals(teams[i].getName())){
				index = i;
				found = false;
			}//End if
		}//End for
		return index;
	}//End findTeam
	
	public int findId(String id){
		boolean check = false;
		int index = -1;
		for(int i = 0; i < employees.size() && !check; i++){
			if( id.equals(employees.get(i).getId())){
				index = i;
				check = true;
			}//End if
		}//End for
		return index;
	}//End findId
	
}//End Club