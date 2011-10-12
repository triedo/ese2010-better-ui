package models;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import play.*;
import play.db.jpa.Model;


public class MyCalendar {
	public User owner;
	public String name;
	
	
	public MyCalendar(User owner, String name) {
		super();
		this.owner = owner;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addEvent(Event event) {
		DateTime dt = new DateTime(event.startDate);
		int month = dt.getMonthOfYear();
		int day = dt.getDayOfMonth();
		for(Month month1: Database.months){
			List<Day> days = month1.days;
			for (Day day1: days){
				if (day1.dayOfTheMonth == day && month1.monthOfYear == month){
					day1.addEvent(event);
				}
			}
		}
	}

}
