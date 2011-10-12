package models;
import play.*;
import play.db.jpa.*;
import javax.persistence.*;

import org.joda.time.DateTime;

import java.util.*;

import play.*;

public class Day {
	public Integer dayOfTheMonth;
	public Month month;
	public List<Event> events;

	public Day(int dayOfTheMonth, Month month){
		this.dayOfTheMonth = dayOfTheMonth;
		this.events = new LinkedList<Event>();
		this.month = month;
	}
	public void addEvent(String name, Date startDate, Date endDate, boolean visible){
		events.add(new Event(name, startDate, endDate, visible, Database.getcurrentuser()));
	}
	public void addEvent(Event event){
		events.add(event);
	}
	
	public boolean isEmpty(){
		return (!events.isEmpty());
	}
	
	public List<Event> getVisibleEvents(){
		List<Event> eventList = new LinkedList<Event>();
		for(Event event: events){
			if (event.visible || (event.owern.equals(Database.getcurrentuser()))){
				eventList.add(event);
			}
		}
		return eventList;
	}
}
