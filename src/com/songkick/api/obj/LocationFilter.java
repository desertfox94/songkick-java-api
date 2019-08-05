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

/**
 * Expresses a filter for searching Songkick for events, so we don't need a million different method signatures
 * to allow for all possible combinations of search types and parameters
 * 
 * @author twhume
 *
 */

public class LocationFilter {
	private String metroId = null;
	private double lat = Double.MAX_VALUE, lng = Double.MAX_VALUE;
	private String ip = null;
	private boolean clientIp = false;
	
	public void reset() {
		this.metroId = null;
		this.lat = Double.MAX_VALUE;
		this.lng = Double.MAX_VALUE;
		this.ip = null;
		this.clientIp = false;
	}

	public String getMetroId() {
		return metroId;
	}

	public void setMetroId(String metroId) {
		this.metroId = metroId;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public boolean isClientIp() {
		return clientIp;
	}

	public void setClientIp(boolean clientIp) {
		this.clientIp = clientIp;
	}
	
	public String toString() {
		return "LocationFilter(metroId="+metroId+",lat="+lat+",lng="+lng+",ip="+ip+",clientIp="+clientIp+")";
	}
}
