package model;
/**
*This class allows to represent a employee.
*@author Brian Romero
*/
public abstract class Employee{
	
	//Atributtes
	private String name;
	private String id;
	private double salary;
	private boolean state;
	private String team;
	
	/**
	* constructor of the Employee class.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> .<br>
	*/
	public Employee(){
		name = new String();
		id = new String();
		salary = 0;
		state = false;
		team = new String();
	}//End constructor
	
	/**
	* constructor of the Employee class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Employee class object created.<br>
	* @param n. Employee name. name != null. name != ""
	* @param i. Employee id. id != null.
	* @param s. Employee salary. salary > 0
	* @param t. Employee state. state is initialized
	*/
	public Employee(String n, String i, double s, boolean t){
		name = n;
		id = i;
		salary = s;
		state = t;
		team = new String();
	}//End constructor
	/**
	* changes the Employee name.<br>
	* <b>pre:</b> name is initialized.<br>
	* <b>post:</b> name has been changed.<br>
	* @param name. New Employee name. name != null. name != ""
	*/
	public void setName(String name){
		this.name = name;
	}//End setName
	/**
	* returns the Employee name.<br>
	* <b>pre:</b> name is initialized. name is not null<br>
	* <b>post:</b> Employee name.<br>
	* @return Return the employee name<br>
	*/
	public String getName(){
		return name;
	}//End getName
	/**
	* changes the Employee id.<br>
	* <b>pre:</b> id is initialized. id is not null.<br>
	* <b>post:</b> Employee id has been changed.<br>
	* @param id. New Employee id. id != null. <br>
	*/
	public void setId(String id){
		this.id = id;
	}//End setId
	/**
	* returns de Employee id.<br>
	* <b>pre:</b> id is initialized.<br>
	* <b>post:</b> Employee id.<br>
	* @return Return the employee id<br>
	*/
	public String getId(){
		return id;
	}//End getId
	/**
	* changes the Employee salary.<br>
	* <b>pre:</b> salary is initialized. salary is not null.<br>
	* <b>post:</b> Employee salary has been changed.<br>
	* @param salary. New Employee salary. salary > 0<br>
	*/
	public void setSalary(double salary){
		this.salary = salary;
	}//End setSalary
	/**
	* returns the Employee salary.<br>
	* <b>pre:</b> salary is initialized.<br>
	* <b>post:</b> Employee salary.<br>
	* @return Return the employee salary<br>
	*/
	public double getSalary(){
		return salary;
	}//End getSalary
	/**
	* changes the Employee state.<br>
	* <b>pre:</b> state is initialized.<br>
	* <b>post:</b> Employee state has been changed.<br>
	* @param state. New Employee state. state is initialized<br>
	*/
	public void setState(boolean state){
		this.state = state;
	}//End setState
	/**
	* returns the Employee state.<br>
	* <b>pre:</b> state is initialized. state is not null.<br>
	* <b>post:</b> Employee state.<br>
	* @return Return the employee state.<br>
	*/
	public boolean getState(){
		return state;
	}//End getState
	/**
	* changes the Employee team.<br>
	* <b>pre:</b> team is initialized.<br>
	* <b>post:</b> Employee team has been changed.<br>
	* @param team. New Employee team. team is initialized<br>
	*/
	public void setTeam(String team){
	this.team = team;
	}//End setName
	/**
	* returns the Employee team.<br>
	* <b>pre:</b> team is initialized. team is not null.<br>
	* <b>post:</b> Employee team.<br>
	* @return Return the employee team.<br>
	*/
	public String getTeam(){
		return team;
	}//End getTeam
	/**
	* saves the Employee info in a String.<br>
	* <b>pre:</b> name, id, salary and state are initialized.<br>
	* <b>post:</b> String with the Employee info.<br>
	* @return Return a String representation of the employee <br>
	*/
	public String toString(){
		String obj = "Nombre: " + name + "\nIdentificacion: " + id + 
		"\nSalario: " + salary + "\n" + "Estado: " + ((state)?"Activo":"Inactivo");
		return obj;
	}//End toString
}//End Employee