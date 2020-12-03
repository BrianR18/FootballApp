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
	private final int EXIT = 10;
	
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
	
	public void displayMainMenu(){
		System.out.println("\n\nMostrando menu....");
		System.out.println("\n[1]Contratar empleado.");
		System.out.println("[2]Despedir empleado.");
		System.out.println("[3]Agregar empleado a un equipo.");
		System.out.println("[4]Agregar alineacion al equipo.");
		System.out.println("[5]Actualizar informacion del empleado.");
		System.out.println("[6]Mostrar informacion de un empleado.");
		System.out.println("[7]Mostrar la informacion de los empleados.");
		System.out.println("[8]Mostrar informacion de un equipo.");
		System.out.println("[9]Mostrar la informacion de todos los equipos.");
		System.out.println("[10]Salir del programa.");
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
				while(club.checkExpertiseEnum(expertise)){
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
				  System.out.print("Cantidad de goles metidos por el jugador: ");
				  goals = sc.nextInt();
				  sc.nextLine();
				}while(goals < 0);
				do{
				  System.out.print("Ingrese la calificacion promedio del jugador: ");
				  averageScore = sc.nextDouble();
				  sc.nextLine();
				}while(averageScore < 0);
				System.out.println("\nMostrando posibles posiciones en el campo...");
				System.out.print("\n"+club.displayPositionEnum());
				System.out.print("Ingrese la posicion del jugador: ");
				position = sc.nextLine();
				while(club.checkPositionEnum(position)){
					System.out.println("[" + position + "] no es una posicion valida.");
					System.out.println("\nMostrando posibles posiciones en el campo...");
				System.out.print("\n"+club.displayPositionEnum());
				System.out.print("Ingrese la posicion del jugador: ");
				position = sc.nextLine();
				}//End while
				msg = club.hireEmployee(name,id,salary,shirt,goals,averageScore,position);
				break;
			default:
				System.out.println("Nunca deberías de poder ver este mensaje."); break;
		}//End switch
		System.out.println(msg);
	}//End hireEmployee.
	
	public void fireEmployee(){
		String id = new String();
		System.out.print("Por favor ingrese el ID del empleado a despedir.");
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
		while(club.checkTacticsEnum(tactic)){
			System.out.println("\n["+tactic+"], no es una tactica valida...");
			System.out.println("\nMostrando posibles tacticas....\n" + club.displayTacticsEnum());
			System.out.print("Ingrese el nombre de la tactica que usara: ");
			tactic = sc.nextLine();
		}//End while
		System.out.print("Ingrese la formacion (el formato debe ser X-X-X, ej: 4-4-2): ");
		training = sc.nextLine();
		System.out.println(club.addTrainingToTeam(teamName,day,month,year,tactic,training));
	}//End addTrainingToTeam
	
	public void updateEmployeeInformation(){
		
	}//End updateEmployeeInformation
	
	public void displayEmployeeInformation(){
		
	}//End displayEmployeeInformation
	
	public void displayAllEmployeesInformation(){
		
	}//End displayAllEmployeesInformation
	
	public void displayTeamInformation(){
		
	}//End displayTeamInformation
	
}//End Menu