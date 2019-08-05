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

import java.util.ArrayList;
import java.util.List;

import com.songkick.api.obj.Event;

public class SingleEventResults implements Results {
	private Event event;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Messy. Create a list, because everything else we parse comes out in lists, then put one item in it,
	 * and later on in Songkick.java extract this one item. Eww.
	 */
	public List<? extends Object> getList() {
		List<Event> list = new ArrayList<Event>();
		list.add(event);
		return list;
	}


}
