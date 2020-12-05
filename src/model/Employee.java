package model;
/**
*This class allows to represent a employee.
*@author Brian Romero
*/
public abstract class Employee{
	private String name;
	private String id;
	private double salary;
	private boolean state;
	private String team;
	
	public Employee(){
		name = new String();
		id = new String();
		salary = 0;
		state = false;
		team = new String();
	}//End constructor
	
	public Employee(String n, String i, double s, boolean t){
		name = n;
		id = i;
		salary = s;
		state = t;
		team = new String();
	}//End constructor
	/**
	*Changes the employee name.
	*
	*@param name The new employee name
	*/
	public void setName(String name){
		this.name = name;
	}//End setName
	
	public String getName(){
		return name;
	}//End getName
	
	public void setId(String id){
		this.id = id;
	}//End setId
	
	public String getId(){
		return id;
	}//End getId
	
	public void setSalary(double salary){
		this.salary = salary;
	}//End setSalary
	
	public double getSalary(){
		return salary;
	}//End getSalary
	
	public void setState(boolean state){
		this.state = state;
	}//End setState
	
	public boolean getState(){
		return state;
	}//End getState
	
	public void setTeam(String team){
	this.team = team;
	}//End setName
	
	public String getTeam(){
		return team;
	}//End getTeam
	
	
	public String toString(){
		String obj = "Nombre: " + name + "\nIdentificacion: " + id + 
		"\nSalario: " + salary + "\n" + "Estado: " + ((state)?"Activo":"Inactivo");
		return obj;
	}//End toString
}//End Employee