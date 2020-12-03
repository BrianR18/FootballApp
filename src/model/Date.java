package model;
import java.util.Arrays; 

public class Date{
	
	private int[] THIRTYONEDAYSMONTHS = {1,3,5,7,8,10,12};
	private int day;
	private int month;
	private int year;
	
	public Date(){
		day = 23;
		month = 11;
		year = 2020;
	}//End constructor
	
	public boolean setDate(int day, int month, int year){
		boolean set = false;
		if(checkDate(day,month,year)){
			this.day = day;
			this.month = month;
			this.year = year;
			set = true;
		}//End if
		return set;
	}//End setDate
	
	public boolean checkDate(int day, int month, int year){
		boolean check = false;
		if(checkMonth(month) && checkYear(year) ){
			if(month != 2)
				check = checkDay(day,month);
			else
				check = checkFebruaryDay(day,year);
		}//End if
		return check;
	}//End checkDate
	
	public boolean checkMonth(int month){
		boolean check = (month > 0 && month < 13)?true:false;
		return check;
	}//End month
	
	public boolean checkDay(int day, int month){
		boolean check = false;
		if(day > 0 && day < 32){
			if( day == 31 && Arrays.binarySearch(THIRTYONEDAYSMONTHS,month) > -1 )
				check = true;
		}//End if
		return check;
	}//End checkDay
	
	public boolean checkFebruaryDay(int day, int year){
		boolean check = false;
		if( day > 0 && day < 30)
			if( (day == 29 && checkLeapYear(year)) || day != 29 )
				check = true;
		return check;
	}//End checkFebruaryDay
	
	public boolean checkYear(int year){
		boolean check = (year > 0)?true:false;
		return check;
	}//End year
	
	public boolean checkLeapYear(int year){
		boolean leapYear = false;
		if((year%4 == 0))
			if((year%100 == 0)&&(year%400 == 0))
				leapYear = true;
		return leapYear;
	}//End checkLeapYear
	
	public String toString(){
		String obj = day + "/" + month + "/" + year;
		return obj;
	}//End toString
}//End Date