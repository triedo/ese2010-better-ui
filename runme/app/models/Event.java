package models;
import play.*;
import play.db.jpa.*;
import javax.persistence.*;

import org.joda.time.DateTime;

import java.util.*;
import play.*;


public class Event {
	public String name;
	public Date  startDate;
	public Date  endDate;
	public boolean visible;
	public User owern;
	
	public Event(String name, Date startDate, Date endDate, boolean visible, User owner) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.visible = visible;
		this.owern = owner;
	}
	
	public boolean isAtDay(Date dt) {
		int factor = 1000 * 60 * 60 * 24;
		return (this.startDate.getTime()/factor <= dt.getTime()/factor && (this.endDate.getTime()/factor >= dt.getTime()/factor));
	}

	public boolean isPublic(){
		return visible;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date  getStartDate() {
		return startDate;
	}

	public void setStartDate(Date  startDate) {
		this.startDate = startDate;
	}

	public Date  getEndDate() {
		return endDate;
	}

	public void setEndDate(Date  endDate) {
		this.endDate = endDate;
	}

}
