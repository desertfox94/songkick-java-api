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

import java.io.Serializable;

public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1484240369535437752L;
	private City city;
	private MetroArea metroArea;
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public MetroArea getMetroArea() {
		return metroArea;
	}
	public void setMetroArea(MetroArea metroArea) {
		this.metroArea = metroArea;
	}
}
