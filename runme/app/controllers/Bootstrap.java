package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class Bootstrap extends Job {
 
    public void doJob() {

        if(Database.getUsers().isEmpty()) {
        	User user1,user2,user3;
        	MyCalendar calendar1,calendar2,calendar3;
        	Event analysis_serie1, analysis_serie2,yb_gegen_Basel, grillfest;

    		user1 = new User("Hans", "1");
    		user2 = new User("Urs","abcd");
    		user3 = new User("Anna", "asdf");
    		Database.initMonths();
    		
    		calendar1 = new MyCalendar(user1, "Hausaufgaben");
    		calendar2 = new MyCalendar(user2, "Fussballmatches");
    		calendar3 = new MyCalendar(user3, "Party's");
    		
    		user1.addCalendar(calendar1);
    		user2.addCalendar(calendar2);
    		user3.addCalendar(calendar3);
    		
        	SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        
        	try {
        		Date startDate1 = df.parse("21.10.2011 11:11");
        		Date endDate1 = df.parse("21.10.2011 20:11");
        		Date startDate2 = df.parse("22.10.2011 11:11");
        		Date endDate2 = df.parse("22.10.2011 20:11");
        		Date startDate3 = df.parse("23.10.2011 11:11");
        		Date endDate3 = df.parse("23.10.2011 20:11");
        		Date startDate4 = df.parse("24.10.2011 11:11");
        		Date endDate4 = df.parse("24.10.2011 20:11");
        		
        		analysis_serie1 = new Event("analysis_serie1",  startDate1, endDate1, false, user1);
    	    	analysis_serie2 = new Event("analysis_serie2",  startDate2, endDate2, true, user1);
    	    	yb_gegen_Basel = new Event("yb_gegen_Basel",  startDate3, endDate3, true, user2);
    	    	grillfest = new Event("grillfest",  startDate4, endDate4, false, user3);
    	    	
    	       	calendar1.addEvent(analysis_serie1);
    	    	calendar1.addEvent(analysis_serie2);
    	    	calendar2.addEvent(yb_gegen_Basel);
    	    	calendar3.addEvent(grillfest);
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	
            Database.addUser(user1);
            Database.addUser(user2);
            Database.addUser(user3);
        }

    }
 
}