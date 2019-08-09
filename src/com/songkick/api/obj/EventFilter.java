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

	public static final String CONCERT = "Concert";

	public static final String FESTIVAL = "Festival";

	private String artistName = null;

	private Date minDate = null;

	private Date maxDate = null;

	private String type = null;

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

	@Override
	public String toString() {
		return "EventFilter(artistName=" + artistName + ",minDate=" + minDate + ",maxDate=" + maxDate + ",location=" + location + ")";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
