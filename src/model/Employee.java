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
	
	public Employee(){
		name = new String();
		id = new String();
		salary = 0;
		state = false;
	}//End constructor
	
	public Employee(String n, String i, double s, boolean t){
		name = n;
		id = i;
		salary = s;
		state = t;
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
	
	public String toString(){
		String obj = "Nombre: " + name + "\nIdentificacion: " + id + 
		"\nSalario: " + salary + "\n" + "Estado: " + (state)?"Activo":"Inactivo";
		return obj;
	}//End toString
}//End Employee