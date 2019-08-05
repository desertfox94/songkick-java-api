/**
 * $Revision$
 * $Date$
 * $Author$
 * 
 * $Log$
 *
 *
 * (c) 2008 Future Platforms
 * 
 */ 
package com.songkick.api.helper;
import java.util.List;

import com.songkick.api.obj.CalendarEntry;

public class CalendarResults implements Results {
	private List<CalendarEntry> calendarEntry;


	public List<CalendarEntry> getList() {
		return calendarEntry;
	}


	public List<CalendarEntry> getCalendarEntry() {
		return calendarEntry;
	}


	public void setCalendarEntry(List<CalendarEntry> calendarEntry) {
		this.calendarEntry = calendarEntry;
	}
}
