package ui;
import java.util.Scanner;
import model.Club;
public class Menu{
	
	//Main menu
	private final int HIREEMPLOYEE = 1;
	private final int FIREEMPLOYEE = 2;
	private final int ADDEMPLOYEETOTEAM = 3;
	private final int ADDTRAININGTOTEAM = 4;
	private final int UPDATEEMPLOYEEINFORMATION = 5;
	private final int DISPLAYEMPLOYEEINFORMATION = 6;
	private final int DISPLAYALLEMPLOYEESINFORMATION = 7;
	private final int DISPLAYTEAMINFORMATION = 8;
	private final int DISPLAYALLTEAMSINFORMATION = 9;
	private final int LOCATE = 10;
	private final int DISPLAYLOCATE = 11;
	private final int DISPLAYTRAINING = 12;
	private final int DISPLAYTRAININGSTRING = 13;
	private final int EXIT = 14;
	
	//Sub menu
	private final int MAINCOUCH = 1;
	private final int ASSISTCOUCH = 2;
	private final int PLAYER = 3;
	//
	private Scanner sc;
	private Club club;
	
	public Menu(String name,String NIT){
		club = new Club(name,NIT);
		boolean a = club.addDate(2,12,2020);
		sc = new Scanner(System.in);
	}//End Menu
	
	public int readOption(){
		int opt = 0;
		System.out.print("\nIngrese la opcion: ");
		opt = sc.nextInt();
		sc.nextLine();
		return opt;
	}//End readOption
	
	public void displayMainMenu(){
		System.out.println("\n\nMostrando menu....");
		System.out.println("\n["+HIREEMPLOYEE+"]Contratar empleado.");
		System.out.println("["+FIREEMPLOYEE+"]Despedir empleado.");
		System.out.println("["+ADDEMPLOYEETOTEAM+"]Agregar empleado a un equipo.");
		System.out.println("["+ADDTRAININGTOTEAM+"]Agregar alineacion al equipo.");
		System.out.println("["+UPDATEEMPLOYEEINFORMATION+"]Actualizar informacion del empleado.");
		System.out.println("["+DISPLAYEMPLOYEEINFORMATION+"]Mostrar informacion de un empleado.");
		System.out.println("["+DISPLAYALLEMPLOYEESINFORMATION+"]Mostrar la informacion de los empleados.");
		System.out.println("["+DISPLAYTEAMINFORMATION+"]Mostrar informacion de un equipo.");
		System.out.println("["+DISPLAYALLTEAMSINFORMATION+"]Mostrar la informacion de todos los equipos.");
		System.out.println("["+LOCATE+"]Ubicar empleados en las instalaciones.");
		System.out.println("["+DISPLAYLOCATE+"]Mostrar empleados en las instalaciones.");
		System.out.println("["+DISPLAYTRAINING+"]Mostrar formacion.");
		System.out.println("["+DISPLAYTRAININGSTRING+"]Mostrar formacion de los jugadores en el campo.");
		System.out.println("["+EXIT+"]Salir del programa.");
	}//End displayOption
	
	public void displaySubMenu(){
		System.out.println("\n[1]Entrenador principal.");
		System.out.println("[2]Entrenador asistente.");
		System.out.println("[3]Jugador.");
	}//End displayOption
	
	public void hireEmployee(){
		String name = new String();
		String id = new String();
		double salary = 0.0;
		String msg = new String();
		int opt = 0;
		int anio = 0;
		int nTeams = 0;
		int CSWon = 0;
		boolean exPlayer = false;
		int shirt = 0;
		int goals = 0;
		double averageScore = 0;
		String position = new String();
		String expertise = new String();
		do{
			System.out.println("\nMostrando posibles empleados a contratar...");
			displaySubMenu();
			System.out.print("\nElegir empleado a contratar: ");
			opt = sc.nextInt();
			sc.nextLine();
		}while(opt < 1 || opt > 3);	
		System.out.print("Ingresar el nombre del empleado: ");
		name = sc.nextLine();
		System.out.print("Ingresar el id del empleado: ");
		id = sc.nextLine();
		while(club.checkId(id)){
			System.out.println("El id ["+id+"] ya esta ocupado por otro empleado.");
			System.out.print("Ingresar el id del empleado: ");
			id = sc.nextLine();
		}//End while
		do{
		  System.out.print("Ingresar el salario del empleado: ");
		  salary = sc.nextDouble();
		}while(salary < 0);
		if(opt != PLAYER){
			do{
			  System.out.print("Ingrese los anios de experiencia del entrenador: ");
			  anio = sc.nextInt();
			  sc.nextLine();
			}while(anio < 0);//End do while
		}//End if
		switch(opt){
			case MAINCOUCH:
				do{
					System.out.print("Numero de equipos a cargo en toda la carrera: ");
					nTeams = sc.nextInt();
					sc.nextLine();
				}while(nTeams < 0);
				do{
					System.out.print("Numero de victorias en toda la carrera: ");
					CSWon = sc.nextInt();
					sc.nextLine();
				}while(CSWon < 0);
				msg = club.hireEmployee(name,id,salary,anio,nTeams,CSWon);
				break;
			case ASSISTCOUCH:
				do{
					System.out.println("El asistente fue un jugador anteriormente?");
					System.out.println("[1]Si\n[2]No");
					System.out.print("Ingrese la opcion: ");
					opt = sc.nextInt();
					sc.nextLine();
				}while( opt< 1 || opt > 2);
				exPlayer = (opt == 1)?true:false;
				System.out.println("\nMostrando experticias...");
				System.out.print("\n" + club.displayExpertiseEnum());
				System.out.print("Ingrese la experticia del asistente: ");
				expertise = sc.nextLine();
				while(!club.checkExpertiseEnum(expertise)){
					System.out.println("["+expertise + "] no es una experticia valida.");
					System.out.println("\nMostrando experticias...");
					System.out.print("\n" + club.displayExpertiseEnum());
					System.out.print("Ingrese la experticia del asistente: ");
					expertise = sc.nextLine();
				}//End while
				msg = club.hireEmployee(name,id,salary,anio,exPlayer,expertise);
				break;
			case PLAYER:
				do{
				  System.out.print("Ingrese el numero de la camiseta del jugador: ");
				  shirt = sc.nextInt();
				  sc.nextLine();
				}while(shirt<0);
				do{
				  System.out.print("Ingrese la calificacion promedio del jugador: ");
				  averageScore = sc.nextDouble();
				  sc.nextLine();
				}while(averageScore < 0);
				System.out.println("\nMostrando posibles posiciones en el campo...");
				System.out.print("\n"+club.displayPositionEnum());
				System.out.print("Ingrese la posicion del jugador: ");
				position = sc.nextLine();
				while(!club.checkPositionEnum(position)){
					System.out.println("[" + position + "] no es una posicion valida.");
					System.out.println("\nMostrando posibles posiciones en el campo...");
				System.out.print("\n"+club.displayPositionEnum());
				System.out.print("Ingrese la posicion del jugador: ");
				position = sc.nextLine();
				}//End while
				if(!position.equalsIgnoreCase("portero")){
					do{
						System.out.print("Cantidad de goles metidos por el jugador: ");
						goals = sc.nextInt();
						sc.nextLine();
					}while(goals < 0);
				}//End if
				msg = club.hireEmployee(name,id,salary,shirt,goals,averageScore,position);
				break;
			default:
				System.out.println("Nunca deberías de poder ver este mensaje."); break;
		}//End switch
		System.out.println("\n"+msg);
	}//End hireEmployee.
	
	public void fireEmployee(){
		String id = new String();
		System.out.print("Por favor ingrese el ID del empleado a despedir: ");
		id = sc.nextLine();
		System.out.println(club.fireEmployee(id));
	}//End fireEmployee
	
	public void addEmployeeToTeam(){
		String id = new String();
		String teamName = new String();
		System.out.print("\nIngrese el ID del empleado a agregar: ");
		id = sc.nextLine();
		System.out.println("Mostrando equipos...\n-A\n-B");
		System.out.print("Ingrese el nombre del equipo al que agregar al empleado: ");
		teamName = sc.nextLine();
		teamName = teamName.toUpperCase();
		System.out.print("\n" + club.addEmployeeToTeam(id,teamName));
	}//End addEmployeeToTeam
	
	public void addTrainingToTeam(){
		String teamName = new String();
		int day = 0;
		int month = 0;
		int year = 0;
		String tactic = new String();
		String training = new String();
		System.out.println("Mostrando equipos...\n-A\n-B");
		System.out.print("Ingrese el nombre del equipo al que agregara la alineacion: ");
		teamName = sc.nextLine();
		while(club.findTeam(teamName) == -1){
			System.out.println("\n["+teamName+"], no es un equipo existente...");
			System.out.println("Mostrando equipos...\n-A\n-B");
			System.out.print("Ingrese el nombre del equipo al que agregara la alineacion: ");
			teamName = sc.nextLine();
		}//End 
		System.out.println("\nAgregar fecha de creacion...");
		System.out.print("Ingrese el dia: ");
		day = sc.nextInt();
		System.out.print("Ingrese el mes: ");
		month = sc.nextInt();
		System.out.print("Ingrese el anio: ");
		year = sc.nextInt();
		sc.nextLine();
		System.out.println("\nMostrando posibles tacticas....\n" + club.displayTacticsEnum());
		System.out.print("Ingrese el nombre de la tactica que usara: ");
		tactic = sc.nextLine();
		while(!club.checkTacticsEnum(tactic)){
			System.out.println("\n["+tactic+"], no es una tactica valida...");
			System.out.println("\nMostrando posibles tacticas....\n" + club.displayTacticsEnum());
			System.out.print("Ingrese el nombre de la tactica que usara: ");
			tactic = sc.nextLine();
		}//End while
		System.out.print("Ingrese la formacion (el formato debe ser X-X-X, ej: 4-4-2): ");
		training = sc.nextLine();
		while(!club.checkTraining(training)){
			System.out.println("La formacion ingresada no es valida.");
			System.out.print("Ingrese la formacion (el formato debe ser X-X-X, ej: 4-4-2): ");
			training = sc.nextLine();
		}//End while
		System.out.println(club.addTrainingToTeam(teamName,day,month,year,tactic,training));
	}//End addTrainingToTeam
	
	public void updateEmployeeInformation(){
		double salary = 0;
		int expYears = 0;
		int numberTeams = 0;
		int championshipWon = 0;
		boolean explayer = false;
		String expertise = new String();
		int shirtNumber = 0;
		int goals = 0;
		double averageScore = 0;
		String position = new String();
		String msg = new String();
		String id = new String();
		int opt = 0;
		System.out.println("\nMostrando tipos de empleados...");
		do{
			displaySubMenu();
			System.out.print("\nIngrese la opcion: ");
			opt = sc.nextInt();
			sc.nextLine();
		}while( opt < MAINCOUCH || opt > PLAYER);
		System.out.print("Ingrese el id del empleado al que desea actualizarle su informacion: ");
		id = sc.nextLine();
		if(club.findId(id) != -1){
			do{
				System.out.print("Ingrese el nuevo sueldo: ");
				salary = sc.nextDouble();
				sc.nextLine();
			}while(salary < 0);
			switch(opt){
				
				case MAINCOUCH:
					do{
						System.out.print("Ingrese los anios de experiencia: ");
						expYears = sc.nextInt();
						sc.nextLine();
					}while(expYears < 0);
					do{
						System.out.print("Ingrese el numero de equipos a cargo: ");
						numberTeams = sc.nextInt();
						sc.nextLine();
					}while(numberTeams<0);
					do{
						System.out.print("Ingrese el numero de campeonatos ganados: ");
						championshipWon = sc.nextInt();
						sc.nextLine();
					}while(championshipWon<0);
					msg = club.updateMainCoachInfo(id,salary,expYears,numberTeams,championshipWon);
				break;
				case ASSISTCOUCH:
					do{
						System.out.print("Ingrese los anios de experiencia: ");
						expYears = sc.nextInt();
					}while(expYears < 0);
					do{
						System.out.println("El asistente fue un jugador anteriormente?");
						System.out.println("[1]Si\n[2]No");
						System.out.print("Ingrese la opcion: ");
						opt = sc.nextInt();
						sc.nextLine();
					}while( opt< 1 || opt > 2);
					explayer = (opt == 1)?true:false;
					System.out.println("\nMostrando experticias...");
					System.out.print("\n" + club.displayExpertiseEnum());
					System.out.print("\nIngrese la experticia del asistente: ");
					expertise = sc.nextLine();
					while(!club.checkExpertiseEnum(expertise)){
						System.out.println("["+expertise + "] no es una experticia valida.");
						System.out.println("\nMostrando experticias...");
						System.out.print("\n" + club.displayExpertiseEnum());
						System.out.print("Ingrese la experticia del asistente: ");
						expertise = sc.nextLine();
					}//End while
					msg = club.updateAssistCoachInfo(id,salary,expYears,explayer,expertise);
				break;
				case PLAYER:
					do{
						System.out.print("Ingrese el numero de la camiseta del jugador: ");
						shirtNumber = sc.nextInt();
						sc.nextLine();
					}while(shirtNumber<0);
					do{
						System.out.print("Ingrese la calificacion promedio del jugador: ");
						averageScore = sc.nextDouble();
						sc.nextLine();
					}while(averageScore < 0);
					System.out.println("\nMostrando posibles posiciones en el campo...");
					System.out.print("\n"+club.displayPositionEnum());
					System.out.print("Ingrese la posicion del jugador: ");
					position = sc.nextLine();
					while(!club.checkPositionEnum(position)){
						System.out.println("[" + position + "] no es una posicion valida.");
						System.out.println("\nMostrando posibles posiciones en el campo...");
						System.out.print("\n"+club.displayPositionEnum());
						System.out.print("Ingrese la posicion del jugador: ");
						position = sc.nextLine();
					}//End while
					if(!position.equalsIgnoreCase("portero")){
						do{
							System.out.print("Cantidad de goles metidos por el jugador: ");
							goals = sc.nextInt();
							sc.nextLine();
						}while(goals < 0);
					}//End if
					msg = club.updatePlayerInfo(id,salary,shirtNumber,goals,averageScore,position);
				break;
			}//End switch
		}//End if
	}//End updateEmployeeInformation
	
	public void displayEmployeeInformation(){
		String id = new String();
		System.out.print("Ingrese la id del empleado: ");
		id = sc.nextLine();
		System.out.print("\n"+club.displayEmployeeInformation(id));
	}//End displayEmployeeInformation
	
	public void displayAllEmployeesInformation(){
		System.out.println("\nMostrando informacion de todos los empleados...\n");
		System.out.print(club.displayAllEmployeeInformation());
	}//End displayAllEmployeesInformation
	
	public void displayTeamInformation(){
		String teamName = new String();
		System.out.print("Ingrese el nombre del equipo: ");
		teamName = sc.nextLine();
		System.out.print("\n"+club.displayTeamInformation(teamName));
	}//End displayTeamInformation
	
	public void displayAllTeamInformation(){
		System.out.println("\nMostrando informacion de los equipos....");
		System.out.println("\n"+club.displayAllTeamInformation());
	}//End displayTeamInformation
	
	public void locateInPremises(){
		int opt = 0;
		System.out.println("\nQue empleados desea ubicar?");
		do{
			System.out.print("\n[1]Entrenadores.\n[2]Jugadores equipo A.\n[3]Jugadores equipo B.");
			System.out.print("\nIngrese la opcion: ");
			opt = sc.nextInt();
			sc.nextLine();
		}while( opt < 1 || opt > 3);
		switch(opt){
			case 1:
				club.fillOffices();
				break;
			case 2:
				club.fillDressingRoomTeamA();
				break;
			case 3:
				club.fillDressingRoomTeamB();
				break;
			default:
				System.out.println("\nNunca deberias poder ver esto.");
		}//End switch
		System.out.println("\nEmpleados ubicados correctamente.");
	}//End locateInPremises
	
	public void displayLocate(){
		int opt = 0;
		String locate = "\n";
		System.out.println("\nQue ubicaciones desea ver?");
		do{
			System.out.print("\n[1]Entrenadores.\n[2]Jugadores equipo A.\n[3]Jugadores equipo B.");
			System.out.print("\nIngrese la opcion: ");
			opt = sc.nextInt();
			sc.nextLine();
		}while( opt < 1 || opt > 3);
		switch(opt){
			case 1:
				locate += club.displayOffices();
				break;
			case 2:
				locate += club.displayDressingRoom1();
				break;
			case 3:
				locate += club.displayDressingRoom2();
				break;
			default:
				System.out.println("\nNunca deberias poder ver esto.");
		}//End switch
		System.out.println("\n"+locate);
	}//End locateInPremises
	
	public void displayTraining(){
		String team = new String();
		System.out.println("Mostrando equipos existentes...\n-A\n-B");
		System.out.print("Ingrese el equipo: ");
		team = sc.nextLine();
		System.out.println("\n"+ club.displayTeamAlignments(team));
	}//End displayTraining
	
	public void displayTrainingString(){
		String team = new String();
		int index = 0;
		System.out.println("Mostrando equipos existentes...\n-A\n-B");
		System.out.print("Ingrese el equipo: ");
		team = sc.nextLine();
		System.out.println("Mostrando alineaciones...");
		System.out.println(club.displayTeamAlignments(team));
		System.out.print("Ingrese la alineacion que desea mostrar en el campo: ");
		index = sc.nextInt();
		sc.nextLine();
		index--;
		System.out.println("\n\n"+club.displayTeamAlignmentTraining(team,index));
	}//End displayTraining
	
	public void doOperation(int opt){
		switch(opt){
			case HIREEMPLOYEE:
				hireEmployee();
				break;
			case FIREEMPLOYEE:
				fireEmployee();
				break;
			case ADDEMPLOYEETOTEAM:
				addEmployeeToTeam();
				break;
			case ADDTRAININGTOTEAM:
				addTrainingToTeam();
				break;
			case UPDATEEMPLOYEEINFORMATION:
				updateEmployeeInformation();
				break;
			case DISPLAYEMPLOYEEINFORMATION:
				displayEmployeeInformation();
				break;
			case DISPLAYALLEMPLOYEESINFORMATION:
				displayAllEmployeesInformation();
				break;
			case DISPLAYTEAMINFORMATION:
				displayTeamInformation();
				break;
			case DISPLAYALLTEAMSINFORMATION:
				displayAllTeamInformation();
				break;
			case LOCATE:
				locateInPremises();
				break;
			case DISPLAYLOCATE:
				displayLocate();
				break;
			case DISPLAYTRAINING:
				displayTraining();
				break;
			case DISPLAYTRAININGSTRING:
				displayTrainingString();
				break;
			case EXIT:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion erronea.");
		}//End switch
	}//End doOperation
	
	public void startProgram(){
		int opt = 0;
		do{
			displayMainMenu();
			opt = readOption();
			doOperation(opt);
		}while(opt != EXIT);
	}//End startProgram
	
}//End Menu