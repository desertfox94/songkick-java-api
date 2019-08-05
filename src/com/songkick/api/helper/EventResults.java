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

import com.songkick.api.obj.Event;

public class EventResults implements Results {
	private List<Event> event;

	public List<Event> getEvent() {
		return event;
	}

	public void setArtist(List<Event> event) {
		this.event = event;
	}

	public List<Event> getList() {
		return event;
	}
}
