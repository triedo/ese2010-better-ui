package models;
import play.*;
import play.db.jpa.*;
import javax.persistence.*;

import org.joda.time.DateTime;

import java.util.*;

import play.*;

public class Month {
	public List<Day> days =  new LinkedList<Day>();
	public Integer monthOfYear;
	public Integer year;
	public Integer nr_days;
	public String name;
	
	public Month(int month, int year){
		switch (month){
		  case 1:  name = "January";  		nr_days = 31;     break;
          case 2:  name = "February";    	nr_days = 28;     break;
          case 3:  name = "March";         	nr_days = 31;     break;
          case 4:  name = "April";         	nr_days = 30;     break;
          case 5:  name = "May";          	nr_days = 31;     break;
          case 6:  name = "June";         	nr_days = 30;     break;
          case 7:  name = "July";          	nr_days = 31;     break;
          case 8:  name = "August";        	nr_days = 31;     break;
          case 9:  name = "September";     	nr_days = 30;     break;
          case 10: name = "October";      	nr_days = 31;     break;
          case 11: name = "November";     	nr_days = 30;     break;
          case 12: name = "December";      	nr_days = 31;     break;
		}
		monthOfYear = month;
		this.year = year;
		for (int i =1; i<= nr_days;i++){
			days.add(new Day(i, this));
		}
	}
	
//	public void refreshMonth(MyCalendar calendar){
//		List<Event> events = calendar.events;
//		for(Event event: events){
//			for(Day day: days){
//				Date stDate = event.getStartDate();
//				DateTime dt = new DateTime(stDate);
//				
//						
//			}
//		}
//	}
}
