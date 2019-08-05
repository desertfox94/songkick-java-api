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

public class MetroArea implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8581862344272630688L;
	private String uri;
	private String displayName;
	private NamedItem country;
	private String id;
	private float lat, lng;
	private NamedItem state;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public NamedItem getCountry() {
		return country;
	}
	public void setCountry(NamedItem country) {
		this.country = country;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public NamedItem getState() {
		return state;
	}
	public void setState(NamedItem state) {
		this.state = state;
	}
}
