package model;
import java.util.Collections;
import java.util.ArrayList;

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
	
	public Club(){
		name = new String();
		NIT = new String();
		date = new Date();
		employees = new ArrayList<Employee>();
		controller = new EnumController();
		dressingRoom1 = new String[7][6];
		dressingRoom2 = new String[7][7];
		offices = new String[6][6];
		teams = new Team[2];
		teams[0] =  new Team("A");
		teams[1] =  new Team("B");
	}//End constructors1
	
	public Club(String name, String NIT){
		this.name = name;
		this.NIT = NIT;
		date = new Date();
		employees = new ArrayList<Employee>();
		controller = new EnumController();
		dressingRoom1 = new String[7][6];
		dressingRoom2 = new String[7][7];
		offices = new String[6][6];
		teams = new Team[2];
		teams[0] =  new Team("A");
		teams[1] =  new Team("B");
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
	
	public String hireEmployee(String name,String id,double salary,int expYears,int nTeams,int CSWon){
		String msg = "Empleado contratado con exito.";
		Employee mainCouch = new MainCouch(name,id,salary,true,expYears,nTeams,CSWon);
		employees.add(mainCouch);
		return msg;
	}//End hireEmployee.
	
	public String hireEmployee(String name,String id,double salary,int expYears,boolean exPlayer,String expertise){
		String msg = "No se ha podido contratar al empleado.";
		expertise = controller.addUnderscores(expertise);
		if(controller.checkExpertiseEnum(expertise)){
			AssistCouch assisteCouch = new AssistCouch(name,id,salary,true,expYears,exPlayer);
			assisteCouch.addExpertise(expertise);
			Employee e = (Employee) assisteCouch;
			employees.add(assisteCouch);
			msg = "Empleado contratado con exito.";
		}//End if
		return msg;
	}//End hireEmployee.
	
	public String hireEmployee(String name,String id,double salary,int shirt,int goals,double averageScore,String position){
		String msg = "No se ha podido contratar al empleado.";
		position = controller.addUnderscores(position);
		if(controller.checkPositionEnum(position)){
		  Player player = new Player(name,id,salary,true,shirt,goals,averageScore);
		  player.setPosition(position);
		  Employee e = (Employee) player;
		  employees.add(player);
		  msg = "Empleado contratado con exito.";
		}//End if
		return msg;
	}//End hireEmployee.
	
	public String fireEmployee(String id){
		String msg = "No se ha podido despedir al empleado. ID erroneo.";
		int employeeIndex = findId(id);
		int teamIndex = 0;
		if(employeeIndex != -1){
			employees.get(employeeIndex).setState(false);
			teamIndex = findTeam(employees.get(employeeIndex).getTeam());
			if(teamIndex != -1){
				if( employees.get(employeeIndex) instanceof MainCouch){
					teams[teamIndex].setMainCouch(null);
				 }//End if1
				else if( employees.get(employeeIndex) instanceof AssistCouch ){
					teams[teamIndex].removeAssistCouch(id);
				 }//End if2
				else{
					teams[teamIndex].removePlayer(id);
				}//End else
			}//End if
			if(employees.get(employeeIndex) instanceof Player) {
				if( (employees.get(employeeIndex).getTeam()).equals("A") )
				    fillDressingRoomTeamA();
				else if( (employees.get(employeeIndex).getTeam()).equals("B") )
				    fillDressingRoomTeamB();
			}//End if
			else{
				fillOffices();
			}
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
		  if(employees.get(employee).getState()){
				state = true;
				employees.get(employee).setTeam(teamName);
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
		}//End if
		msg = (state)?"Se ha agregado el empleado al equipo.":"No se ha agregado el empleado al equipo.ID o Equipo incorrecto.";
		return msg;
	}//End addEmployeeToTeam
	
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
	
	public boolean checkTacticsEnum(String a){
		a = controller.addUnderscores(a);
		boolean check = controller.checktTaticsEnum(a);
		return check;
	}//End checkTacticsEnum
	
	public boolean checkPositionEnum(String a){
		a = controller.addUnderscores(a);
		boolean check = controller.checkPositionEnum(a);
		return check;
	}//End checkTacticsEnum
	
	public boolean checkExpertiseEnum(String a){
		a = controller.addUnderscores(a);
		boolean check = controller.checkExpertiseEnum(a);
		return check;
	}//End checkTacticsEnum
	
	public void fillDressingRoomTeamA(){
		int distance = 0;
		int player = 0;
		clearFields(dressingRoom1,7,6);
		Collections.shuffle(employees); 
		for(int i = 0; i < 7; i++){
		  for(int j = 0; j < 6; j++){
			  if(distance % 2 == 0 && player < employees.size() ){
				  while( (!(employees.get(player) instanceof Player) || !((employees.get(player).getTeam()).equals("A"))) && ( player+1 < employees.size()) ){
					  player++;
				  }//End while
				  if( (employees.get(player) instanceof Player) && (employees.get(player).getTeam()).equals("A") && employees.get(player).getState()){
					dressingRoom1[i][j] = employees.get(player).getId();
					player++;
				  }//End if
			  }//End if
			 distance++;
		  }//End for
		  distance++;
		}//End for
	}//End fillDressingRoomTeamA.
	
	public void fillDressingRoomTeamB(){
		int distance = 0;
		int player = 0;
		Collections.shuffle(employees);
		clearFields(dressingRoom2,7,7);
		for(int i = 0; i < 7; i++){
		  for(int j = 0; j < 7; j++){
			  if(distance % 2 == 0 && player < employees.size()){
				  while( (!(employees.get(player) instanceof Player) || !((employees.get(player).getTeam()).equals("B"))) && ( player+1 < employees.size()) ){
					 player++;
				  }//End while
				  if( (employees.get(player) instanceof Player) && (employees.get(player).getTeam()).equals("B") && employees.get(player).getState()){
					dressingRoom2[i][j] = employees.get(player).getId();
					player++;	
				  }//End if
			  }//End if
			 distance++; 
		  }//End for
		}//End for
	}//End fillDressingRoomTeamA.
	
	public void fillOffices(){
		int distance = 0;
		int couch = 0;
		Collections.shuffle(employees);
		clearFields(offices,6,6);
		for(int i = 0; i < 6; i++){
		  for(int j = 0; j < 6; j++){
			  if(distance % 2 == 0 && couch < employees.size()){
				  while( (employees.get(couch) instanceof Player)  && ( couch+1 < employees.size()) ){
					  couch++;
				  }//End while
				  if( !(employees.get(couch) instanceof Player) && employees.get(couch).getState() ){
					  offices[i][j] = employees.get(couch).getId();
					  couch++;
				  }//End if
			  }//End if
			  distance++; 
		  }//End for
		  distance++; 
		}//End for
	}//End fillOfficess
	
	public void clearFields(String[][] m, final int r,final int c){
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				m[i][j] = null;
			}//End for
		}//End for
	}//End clearFields
	
	public int findTeam(String name){
		int index = -1;
		boolean found = false;
		for(int i = 0; i < teams.length && !found; i++ ){
			if(name.equals(teams[i].getName())){
				index = i;
				found = true;
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
	
	public String displayEmployeeInformation(String id){
		int index = findId(id);
		String info = "*****************************************\n";
		if(index != -1)
			info += employees.get(index).toString();
		else
			info += "No se encontro un empleado con esta id";
		return info;
	}//End displayEmployeeInformation
	
	public String displayAllEmployeeInformation(){
		String info = new String();
		for(int i = 0; i < employees.size(); i++){
			info += "*****************************************\n";
			info += employees.get(i).toString() +"\n";
		}//End for
		if(employees.size() == 0)
		   info = "No hay empleados.";
		return info;
	}//End displayEmployeeInformation
	
	public String displayTeamInformation(String teamName){
		int index = findTeam(teamName);
		String info = "El equipo no existe.";
		if(index != -1){
			info = "*****************************************\n";
			info += teams[index].toString();
		}//End if
		return info;
	}//End displayTeamInformation
	
	public String displayAllTeamInformation(){
		String info = new String();
		for(int i = 0; i < teams.length; i++){
			info += "*****************************************\n";
			info += teams[i].toString();
		}//End for
		return info;
	}//End displayTeamInformation
	
	public String updateMainCouchInfo(String id,double salary,int expYears,int numberTeams,int championshipWon){
		int index = findId(id);
		String msg = "No se ha podido actualizar la informacion del usuario.\nEl id ingresado no pertenece a un entrenador principal.";
		if(index != -1){
			if(employees.get(index).getState()){
				if( employees.get(index) instanceof MainCouch ){
					MainCouch m = (MainCouch) employees.get(index);
					m.setSalary(salary);
					m.setExpYears(expYears);
					m.setNumberTeams(numberTeams);
					m.setChampionshipWon(championshipWon);
					msg = "Se actualizaron los datos correctamente.";
				}//End if
			}//End if
		}//End if
		return msg;
	}//End updateEmployeeInfo
	
	public String updateAssistCouchInfo(String id,double salary,int expYears,boolean explayer, String expertises){
		int index = findId(id);
		String msg = "No se ha podido actualizar la informacion del usuario.\nEl id ingresado no pertenece a un asistente tecnico.";
		if(index != -1){
			if(employees.get(index).getState()){
				if( employees.get(index) instanceof AssistCouch ){
					AssistCouch a = (AssistCouch) employees.get(index);
					a.setSalary(salary);
					a.setExplayer(explayer);
					expertises = controller.addUnderscores(expertises);
					a.addExpertise(expertises);
					msg = "Se actualizaron los datos correctamente.";
				}//End if
			}//End if
		}//End if
		return msg;
	}//End updateEmployeeInfo
	
	public String updatePlayerInfo(String id,double salary, int shirtNumber,int goals,double averageScore,String position){
		int index = findId(id);
		String msg = "No se ha podido actualizar la informacion del usuario.\nEl id ingresado no pertenece a un jugador.";
		if(index != -1){
			if(employees.get(index).getState()){
				if(employees.get(index) instanceof Player){
					Player p = (Player) employees.get(index);
					p.setShirtNumber(shirtNumber);
					p.setGoals(goals);
					p.setAverageScore(averageScore);
					p.setSalary(salary);
					position = controller.addUnderscores(position);
					p.setPosition(position);
					msg = "Se actualizaron los datos correctamente.";
				}//End if
			}//End if
		}//End if
		return msg;
	}//End updateEmployeeInfo
	
	public String displayDressingRoom1(){
		String dressingRoom = new String();
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 6; j++){
				if(dressingRoom1[i][j] != null)
					dressingRoom += "[X]";
				else
					dressingRoom += "[O]";
			}//End for
			dressingRoom += "\n";
		}//End for
		return dressingRoom;
	}//End displayDressingRoom1
	
	public String displayDressingRoom2(){
		String dressingRoom = new String();
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				if(dressingRoom2[i][j] != null)
					dressingRoom += "[X]";
				else
					dressingRoom += "[O]";
			}//End for
			dressingRoom += "\n";
		}//End for
		return dressingRoom;
	}//End displayDressingRoom2
	
	public String displayOffices(){
		String office = new String();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(offices[i][j] != null)
					office += "[X]";
				else
					office += "[O]";
			}//End for
			office += "\n";
		}//End for
		return office;
	}//End displayDressingRoom2
	
	public String displayTeamAlignments(String team){
		int teamIndex =findTeam(team);
		String alignment = "["+team+"], no es un equipo existente.";
		if(teamIndex != -1){
			alignment = teams[teamIndex].displayAlignments();
		}//End if
		return alignment;
	}//End displayAlignments
	
	public String displayTeamAlignmentTraining(String team,int i){
		int teamIndex = findTeam(team);
		String training = "["+team+"], no es un equipo existente.";
		if(teamIndex != -1){
			training = teams[teamIndex].displayAlignmentTraining(i);
		}
		return training;
	}//End displayAlignmentTraining
	
	public boolean checkTraining(String t){
		boolean check = false;
		int amountPlayers = 0;
		if(t.length() == 5){
			for(int i = 0; i < 5; i += 2){
				amountPlayers += Integer.parseInt(Character.toString(t.charAt(i)));
			}//End for
			if(amountPlayers  == 10)
				check = true;
		}//End if
		return check;
	}//End checkTraining
	
	public boolean checkId(String id){
		boolean check = false;
		for(int i = 0; i < employees.size() && !check; i++){
			if( employees.get(i).getId().equals(id)){
				check = true;
			}//End if
		}//End for
		return check;
	}//End checkId
}//End Club