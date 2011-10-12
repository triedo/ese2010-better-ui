package controllers;

import play.libs.*;
import play.*;
import play.mvc.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import models.*;

@With(Security.class)
public	 class Application extends Controller {

    public static void index() {
    	List<User> users = Database.getUsers();
    	User currentUser = Database.getcurrentuser();
        render(users, currentUser);
    }

    public static void showCalendars(String username){
    	User user = Database.getUserByName(username);
    	List<MyCalendar> calendars = user.getCalendars();
    	render(user, calendars);
    }
    
    public static void showEvents(String username, String calendarname, String message){
    	User user = Database.getUserByName(username);
    	MyCalendar calendar = user.getCalendarByName(calendarname);
    	List<Day> days = new LinkedList<Day>();
    	List<Event> events = new LinkedList<Event>();
    	Month currentM = null;
    	
    	for(Month month1: Database.months){
			if (month1.monthOfYear == Database.intOfCurrentMonth){
				currentM = month1;
				days = month1.days;
			}
			for (Day day1: days){
				if (day1.dayOfTheMonth == Database.intOfCurrentDay){
					events = day1.getVisibleEvents();
				}
			}
		}
    	render(user, calendar, days, events, message, currentM);
    }
    
    public static void clickOnDay(String username, String calendarname, String message, int i){
    	Database.intOfCurrentDay = i;
    	showEvents(username, calendarname, message);
    }
    
    public static void nextMonth(String username, String calendarname, String message){
    	Database.intOfCurrentMonth++;
    	showEvents(username, calendarname, message);
    }
    
    public static void prevMonth(String username, String calendarname, String message){
    	Database.intOfCurrentMonth--;
    	showEvents(username, calendarname, message);
    }
    
    public static void createEvent(){
    	render();
    }
    public static void addEvent(String eventName, String eventStart, String eventEnd, String eventVisibility){
    	SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    	User user = Database.getcurrentuser();
    	MyCalendar calendar = user.calendars.get(0);
    	String message = "done";
    	boolean visibility = false;
    	if (eventVisibility.equalsIgnoreCase("public")) { visibility = true;}
    	
    	Date startDate;
		try {
			startDate = df.parse(eventStart);
		
    	Date endDate = df.parse(eventEnd);
    	Event event= new Event(eventName, startDate,endDate, visibility, user);
        calendar.addEvent(event);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
		showEvents(user.getName(), calendar.getName(), message);

    }

}