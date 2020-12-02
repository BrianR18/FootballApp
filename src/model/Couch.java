package model;

public abstract class Couch extends Employee{
	private int expYears;
	
	public Couch(){
		super();
		expYears = 0;
	}//End contructor1
	
	public Couch(String name, String id, double salary, boolean state, int expYears){
		super(name,id,salary,state);
		this.expYears = expYears;
	}//End contructor2
	
	public void setExpYears(int years){
		expYears = years;
	}//End setExpYears
	public int getExpYears(){
		return expYears;
	}//End getExpYears
	
	@override
	public String toString(){
		String obj = super.toString() + "\nAnios de experiencia: " + expYears;
		return obj;
	}//End toString.
}//End Couch