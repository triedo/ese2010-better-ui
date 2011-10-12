package models;

import java.util.*;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import play.*;
import play.db.jpa.Model;

public class Database {
	private static Map<String, User> users =  new HashMap<String, User>();
	private static User currentuser;
	private static DateTime currentDT = new DateTime(new Date());
	public static int intOfCurrentMonth =currentDT.getMonthOfYear();
	public static int intOfCurrentDay = currentDT.getDayOfMonth();
	public static List<Month> months;
	public static User getUserByName(String name){
		return users.get(name);
	}
	
	public static List<User> getUsers(){
		return new LinkedList<User>(users.values());
	}

	public static void addUser(User user) {
		if(!users.containsKey(user.getName()))
			users.put(user.getName(), user);
	}
	
	public static void initMonths(){
		months = new LinkedList<Month>();
		months.add(new Month(9,2011));
		months.add(new Month(10,2011));
		months.add(new Month(11,2011));
		months.add(new Month(12,2011));
		months.add(new Month(1,2012));
	}
	
	public static User getcurrentuser(){
		return currentuser;
	}
	public static void setCurrentUser(User user){
		currentuser = user;
	}
	
	
}
