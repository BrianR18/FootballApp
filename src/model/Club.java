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
	/**
	* constructor of the Club class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> Club class object created. <br>
	*/
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
	/**
	* constructor of the Club class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> Club class object created. <br>
	* @param name. Club name. name != null. name != ""<br>
	* @param NIT Club nit. nit != null. nit != ""
	*/
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
	/**
	* changes the Club foundation date.<br>
	* <b>pre:</b> foundationDate is initialized.<br>
	* <b>post:</b> Club foundation date has been changed.<br>
	* @day foundation day. Club foundation date. foundationDate != null. foundationDate != ""
	* @month foundation month. Club foundation date. foundationDate != null. foundationDate != ""
	* @year foundation year. Club foundation date. foundationDate != null. foundationDate != ""
	*/
	public boolean addDate(int day, int month, int year){
		boolean add = date.setDate(day,month,year);
		return add;
	}//End addDate
	/**
	* changes the Club name <br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> name has been changed.<b>
	* @param name. New Club name. name != null. name != ""
	*/
	public void	setName(String name){
		this.name = name;
	}//End setName
	/**
	* changes the Club nit.<br>
	* <b>pre:</b> nit is initialized.<br>
	* <b>post:</b> Club nit has been changed.<br>
	* @param NIT. Club NIT. NIT != null. NIT != ""
	*/
	public void setNIT(String NIT){
		this.NIT = NIT;
	}//End setNIT
	/**
	* adds a new Employee(HeadCoach).<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new Employee has been added.<br>
	* @param id. MainCoach id. id != null.
	* @param salary. MainCoach salary. salary > 0. 
	* @param state. MainCoach state. state is initialized
	* @param expYears. MainCoach experience years. years >= 0
	* @param nTeams. MainCoach leading teams. leadingTeams is initialized
	* @param CSWon. MainCoach achieved championships. achievedChampionShips is initialized
	*/
	public String hireEmployee(String name,String id,double salary,int expYears,int nTeams,int CSWon){
		String msg = "Empleado contratado con exito.";
		Employee mainCoach = new MainCoach(name,id,salary,true,expYears,nTeams,CSWon);
		employees.add(mainCoach);
		return msg;
	}//End hireEmployee.
	/**
	* adds a new Employee(AssistCoach).<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new Employee has been added.<br>
	* @param name. AssistCoach name. name != null. name != ""
	* @param id. AssistCoach id. id != null.
	* @param salary. AssistCoach salary. salary > 0. 
	* @param state. AssistCoach state. state is initialized
	* @param expYears. AssistCoach experience years. years >= 0
	* @param exPlayer. AssistCoach exPlayer info. exPlayer is initialized
	* @param expertise. AssistCoach expertise. expertise is initialized
	*/
	public String hireEmployee(String name,String id,double salary,int expYears,boolean exPlayer,String expertise){
		String msg = "No se ha podido contratar al empleado.";
		expertise = controller.addUnderscores(expertise);
		if(controller.checkExpertiseEnum(expertise)){
			AssistCoach assisteCoach = new AssistCoach(name,id,salary,true,expYears,exPlayer);
			assisteCoach.addExpertise(expertise);
			Employee e = (Employee) assisteCoach;
			employees.add(assisteCoach);
			msg = "Empleado contratado con exito.";
		}//End if
		return msg;
	}//End hireEmployee.
	/**
	* adds a new Employee(player).<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new Employee has been added.<br>
	* @param name. Player name. name != null. name != ""
	* @param id. Player id. id != null.
	* @param salary. Player salary. salary > 0. 
	* @param shirt. Player number . number >= 0
	* @param goals. Player goals. goals >= 0
	* @param averageScore. Player average score >= 0
	* @param position. Player position. position != null. position != ""
	*/
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
	/**
	* fires an employee.<br>
	* <b>pre:</b> employee id is initialized.<br>
	* <b>post:</b> an employee has been fired.<br>
	* @param id. id of the employee to fire. 
	*/
	public String fireEmployee(String id){
		String msg = "No se ha podido despedir al empleado. ID erroneo.";
		int employeeIndex = findId(id);
		int teamIndex = 0;
		if(employeeIndex != -1){
			employees.get(employeeIndex).setState(false);
			teamIndex = findTeam(employees.get(employeeIndex).getTeam());
			if(teamIndex != -1){
				if( employees.get(employeeIndex) instanceof MainCoach){
					teams[teamIndex].setMainCoach(null);
				 }//End if1
				else if( employees.get(employeeIndex) instanceof AssistCoach ){
					teams[teamIndex].removeAssistCoach(id);
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
	/**
	* adds a employee to a team.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> a new employee has been added to a team.<br>
	* @param id. id of the employee to add. id != null<br>
	* @param teamName. teamName of the team to add. teamName != null
	*/
	public String addEmployeeToTeam(String id, String teamName){
		int team = findTeam(teamName);
		int employee = findId(id);
		boolean state = false;
		String msg;
		if( (team != -1) && (employee != -1) ){
		  if(employees.get(employee).getState()){
				state = true;
				employees.get(employee).setTeam(teamName);
				if( employees.get(employee) instanceof MainCoach){
					MainCoach mCoach = (MainCoach)employees.get(employee);
					teams[team].setMainCoach(mCoach);
				}//End if1
				else if( employees.get(employee) instanceof AssistCoach ){
					AssistCoach aCoach = (AssistCoach)employees.get(employee);
					teams[team].addAssistCoach(aCoach);
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
	/**
	* adds a new alignment to a team.<br>
	* <b>pre:</b> parametrs are initialized.<br>
	* <b>post:</b> a new alignment has been added to a team.<br>
	* @param teamName. name of the team to add. teamName != null
	* @param day. Alignment day. day > 0. 
	* @param month. Alignment month. month > 0. 
	* @param year. Alignment year. year > 0.
	* @param tactic. Alignment tactic. tactic != null. tactic != "".
	* @param training. Alignemnt training. training != null. training != "".
	*/
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
	/**
	* display the tacticsEnum.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	* @return Return tacticsEnum as a String
	*/
	public String displayTacticsEnum(){
		String msg = controller.displayTacticsEnum();
		return msg;
	}//End displayTacticsEnum
	/**
	* display the positionEnum.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	* @return Return positionEnum as a String
	*/
	public String displayPositionEnum(){
		String msg = controller.displayPositionEnum();
		return msg;
	}//End displayTacticsEnum
	/**
	* display the expertiseEnum.<br>
	* <b>pre:</b><br>
	* <b>post:</b><br>
	* @return Return expertiseEnum as a String
	*/
	public String displayExpertiseEnum(){
		String msg = controller.displayExpertiseEnum();
		return msg;
	}//End displayTacticsEnum
	/**
	* Check if the input is a valid tactic.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param a. input to search. a != null
	* @return Return true if found. false if not
	*/
	public boolean checkTacticsEnum(String a){
		a = controller.addUnderscores(a);
		boolean check = controller.checktTaticsEnum(a);
		return check;
	}//End checkTacticsEnum
	/**
	* Check if the input is a valid expertise.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param a. input to search. a != null
	* @return Return true if found. false if not
	*/
	public boolean checkPositionEnum(String a){
		a = controller.addUnderscores(a);
		boolean check = controller.checkPositionEnum(a);
		return check;
	}//End checkTacticsEnum
	/**
	* Check if the input is a valid position.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param a. input to search. a != null
	* @return Return true if found. false if not
	*/
	public boolean checkExpertiseEnum(String a){
		a = controller.addUnderscores(a);
		boolean check = controller.checkExpertiseEnum(a);
		return check;
	}//End checkTacticsEnum
	/**
	* adds a player to a dressing room 1.<br>
	* <b>pre:</b> playerIndex is initialized.<br>
	* <b>post:</b> a player has been added to a dressing room.<br> 
	*/
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
	/**
	* adds a player to a dressing room 2.<br>
	* <b>pre:</b> playerIndex is initialized.<br>
	* <b>post:</b> a player has been added to a dressing room.<br>
	*/
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
	/**
	* adds coaches to a office.<br>
	* <b>pre:</b> coachIndex is initialized.<br>
	* <b>post:</b> The coaches have been added to a office.<br>
	*/
	public void fillOffices(){
		int distance = 0;
		int coach = 0;
		Collections.shuffle(employees);
		clearFields(offices,6,6);
		for(int i = 0; i < 6; i++){
		  for(int j = 0; j < 6; j++){
			  if(distance % 2 == 0 && coach < employees.size()){
				  while( (employees.get(coach) instanceof Player)  && ( coach+1 < employees.size()) ){
					  coach++;
				  }//End while
				  if( !(employees.get(coach) instanceof Player) && employees.get(coach).getState() ){
					  offices[i][j] = employees.get(coach).getId();
					  coach++;
				  }//End if
			  }//End if
			  distance++; 
		  }//End for
		  distance++; 
		}//End for
	}//End fillOfficess
	/**
	* Clear the matriz.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b>.<br>
	* @param m. Matriz. 
	* @param r. rows. 
	* @param c. columns. 
	*/
	public void clearFields(String[][] m, final int r,final int c){
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				m[i][j] = null;
			}//End for
		}//End for
	}//End clearFields
	/**
	* finds if the input is a valid team.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b>.<br>
	* @param name. name of the team. 
	*/
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
	/**
	* finds if the input is a valid id.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b>.<br>
	* @param id. id of the employeeo. 
	*/
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
	/**
	* Display the info of an employee on a String.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b> info of an employee.<br>
	* @param id. id of the employee to save info. 
	*/
	public String displayEmployeeInformation(String id){
		int index = findId(id);
		String info = "*****************************************\n";
		if(index != -1)
			info += employees.get(index).toString();
		else
			info += "No se encontro un empleado con esta id";
		return info;
	}//End displayEmployeeInformation
	/**
	* Display all employees info on a String.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b> info of an employee.<br>
	* @param id. id of the employee to save info. 
	*/
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
	/**
	* Display the info of a team on a String.<br>
	* <b>pre:</b> teamName is initialized.<br>
	* <b>post:</b> info of team.<br>
	* @param teamName. Name of the team. teamName != null
	*/
	public String displayTeamInformation(String teamName){
		int index = findTeam(teamName);
		String info = "El equipo no existe.";
		if(index != -1){
			info = "*****************************************\n";
			info += teams[index].toString();
		}//End if
		return info;
	}//End displayTeamInformation
	/**
	* Display all teams info on a String.<br>
	* <b>pre:</b> <br>
	* <b>post:</b> info of team.<br>
	*/
	public String displayAllTeamInformation(){
		String info = new String();
		for(int i = 0; i < teams.length; i++){
			info += "*****************************************\n";
			info += teams[i].toString();
		}//End for
		return info;
	}//End displayTeamInformation
	/**
	* updates a MainCoach amount of achieved championships.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> championships have been changed. <br>
	* @param id. MainCoach id to update. MainCoach is initialized
	* @param salary. New MainCoach salary. salary is initialized
	* @param expYears. New MainCoach expYears. expYears is initialized
	* @param numberTeams. New MainCoach numberTeams. numberTeams is initialized
	* @param championshipWon. New MainCoach championships. newChampionShips is initialized
	*/
	public String updateMainCoachInfo(String id,double salary,int expYears,int numberTeams,int championshipWon){
		int index = findId(id);
		String msg = "No se ha podido actualizar la informacion del usuario.\nEl id ingresado no pertenece a un entrenador principal.";
		if(index != -1){
			if(employees.get(index).getState()){
				if( employees.get(index) instanceof MainCoach ){
					MainCoach m = (MainCoach) employees.get(index);
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
	/**
	* updates a AssistCoach amount of achieved championships.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> championships have been changed. <br>
	* @param id. AssistCoach id to update. AssistCoach is initialized
	* @param salary. New AssistCoach salary. salary is initialized
	* @param expYears. New AssistCoach expYears. expYears is initialized
	* @param explayer. New AssistCoach explayer. explayer is initialized
	* @param expertises. New AssistCoach expertises. expertises is initialized
	*/
	public String updateAssistCoachInfo(String id,double salary,int expYears,boolean explayer, String expertises){
		int index = findId(id);
		String msg = "No se ha podido actualizar la informacion del usuario.\nEl id ingresado no pertenece a un asistente tecnico.";
		if(index != -1){
			if(employees.get(index).getState()){
				if( employees.get(index) instanceof AssistCoach ){
					AssistCoach a = (AssistCoach) employees.get(index);
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
	/**
	* updates a Player amount of achieved championships.<br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> championships have been changed. <br>
	* @param id. Player id to update. Player is initialized
	* @param salary. New Player salary. salary is initialized
	* @param shirtNumber. New Player shirtNumber. shirtNumber is initialized
	* @param goals. New Player goals. goals is initialized
	* @param averageScore. New Player averageScore. averageScore is initialized
	* @param position. New Player position. position is initialized
	*/
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
	/**
	* Display the info of the displayDressingRoom1 on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an office.<br>
	*/
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
	/**
	* Display the info of the displayDressingRoom2 on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an office.<br>
	*/
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
	/**
	* Display the info of the office on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an office.<br>
	*/
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
	/**
	* Display the alignments of the teams on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an office.<br>
	* @param team Name of the team to display alignments, teams != null
	*/
	public String displayTeamAlignments(String team){
		int teamIndex =findTeam(team);
		String alignment = "["+team+"], no es un equipo existente.";
		if(teamIndex != -1){
			alignment = teams[teamIndex].displayAlignments();
		}//End if
		return alignment;
	}//End displayAlignments
	/**
	* Display the alignments training of the teams on a String.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> info of an office.<br>
	* @param team Name of the team to display alignments, teams != null
	* @param i index of the alignment to display, i != null
	* @return Return a string with the training representation
	*/
	public String displayTeamAlignmentTraining(String team,int i){
		int teamIndex = findTeam(team);
		String training = "["+team+"], no es un equipo existente.";
		if(teamIndex != -1){
			training = teams[teamIndex].displayAlignmentTraining(i);
		}
		return training;
	}//End displayAlignmentTraining
	/**
	* Check if the input is a valid training.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param t. input to check. t != null
	*/
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
	/**
	* Check if the input is a valid id.<br>
	* <b>pre:</b> input is initialized.<br>
	* <b>post:</b> true if found. false if not<br>
	* @param id. input to check. id != null
	*/
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