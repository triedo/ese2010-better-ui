package models;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import play.*;
import play.db.jpa.Model;


public class User {
	public String name;
	public String password;
	public List<MyCalendar> calendars;
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		this.calendars = new LinkedList<MyCalendar>();
	}
	
	public void addCalendar(MyCalendar calendar){
		this.calendars.add(calendar);
	}
	
//	public List<Event> getEventsAfterNow(MyCalendar calendar){
//		return calendar.getEventsAfterNow(this);
//	}
//	
//	public List<Event> getEventsAtDay(MyCalendar calendar, Date date){
//		return calendar.getEventsAtDay(this, date);
//	}
	
	public MyCalendar getCalendarByName(String name){
		for(MyCalendar calendar: calendars)
			if(calendar.getName().equals(name))
				return calendar;
		return null;
	}
	
	@Override
	public boolean equals(Object o){
		return false;
	}
	
	public boolean equals(User u){
		return this.name.equals(u.getName());
	}
	
	///Getters&Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<MyCalendar> getCalendars() {
		return calendars;
	}

	
}
