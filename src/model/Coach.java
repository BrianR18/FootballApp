package model;

/**
* @author Brian Romero
*/
public abstract class Coach extends Employee{
	private int expYears;
	/**
	* constructor of the Coach class.<br>
	* <b>pre:</b> .<br>
	* <b>post:</b> Coach class object created.<br>
	*/
	public Coach(){
		super();
		expYears = 0;
	}//End contructor1
	/**
	* constructor of the Coach class.<br>
	* <b>pre:</b> parameters are initialized.<br>
	* <b>post:</b> Coach class object created.<br>
	* @param name. Coach name. name != null. name != ""
	* @param id. Coach id. id != null.
	* @param salary. Coach salary. salary > 0. 
	* @param state. Coach state. state is initialized
	* @param expYears. Coach experience years. years >= 0
	*/
	public Coach(String name, String id, double salary, boolean state, int expYears){
		super(name,id,salary,state);
		this.expYears = expYears;
	}//End contructor2
	/**
	* changes the Coach experience years.<br>
	* <b>pre:</b> expYears is initialized. expYears > 0.<br>
	* <b>post:</b> expYears have been changed.<br>
	* @param years The couch experience years
	*/
	public void setExpYears(int years){
		expYears = years;
	}//End setExpYears
	/**
	* returns de Coach experience years.<br>
	* <b>pre:</b> expYears is initialized.<br>
	* <b>post:</b> experience years of the Coach.<br>
	* @return Return the experience years.
	*/
	public int getExpYears(){
		return expYears;
	}//End getExpYears
	/**
	* saves the Coach info in a String.<br>
	* <b>pre:</b> name, id, salary, state and expYears are initialized.<br>
	* <b>post:</b> info of the Coach.<br>
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "\nAnios de experiencia: " + expYears;
		return obj;
	}//End toString.
}//End Couch