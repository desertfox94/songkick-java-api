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
package com.songkick.api.obj;

import java.util.Date;

public class EventFilter {
	private String artistName = null;
	private Date minDate = null;
	private Date maxDate = null;
	private LocationFilter location = null;
	
	public void reset() {
		location = null;
		minDate = null;
		maxDate = null;
		artistName = null;
	}
	
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public Date getMinDate() {
		return minDate;
	}
	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}
	public LocationFilter getLocation() {
		return location;
	}
	public void setLocation(LocationFilter location) {
		this.location = location;
	}
	
	public String toString() {
		return "EventFilter(artistName="+artistName+",minDate="+minDate+",maxDate="+maxDate+",location="+location+")";
	}
	
}
