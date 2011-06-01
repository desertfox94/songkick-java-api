package com.songkick.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.gson.Gson;
import com.songkick.api.helper.ArtistResultsPage;
import com.songkick.api.helper.EventResultsPage;
import com.songkick.api.helper.LocationResultsPage;
import com.songkick.api.obj.Artist;
import com.songkick.api.obj.Event;
import com.songkick.api.obj.EventFilter;
import com.songkick.api.obj.LocationFilter;
import com.songkick.api.obj.Location;

/**
 * Java API for Songkick
 * 
 * Released under the BSD license
 * 
 */

public class Songkick {
	private String apiKey;
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public Songkick(String a) {
		this.apiKey = a;
	}
	
	/**
	 * Helper method; gets a Reader for a specific URL, silently appending our API key
	 * 
	 * @param u
	 * @return
	 * @throws IOException
	 */
	
	private BufferedReader getReader(String u) throws IOException {
		String urlStr = u + "&apikey="+apiKey;
		System.err.println("url="+urlStr);
		URL url = new URL(urlStr);
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		return new BufferedReader(new InputStreamReader(c.getInputStream()));
	}

	/**
	 * Helper method; pulls in a page of Artists matching a given name and returns it 
	 * 
	 * @param name
	 * @param page
	 * @return
	 * @throws IOException
	 */
	private ArtistResultsPage getArtistResultsPage(String name, int page) throws IOException {
		BufferedReader reader = getReader("http://api.songkick.com/api/3.0/search/artists.json?page=" + page + "&query=" + URLEncoder.encode(name, "UTF-8"));
		Gson gson = new Gson();
		return gson.fromJson(reader, ArtistResultsPage.class);
	}
	
	/**
	 * Return a page of all Artists matching a given name
	 * 
	 * @param name
	 * @param page
	 * @return
	 * @throws IOException
	 */
	public List<Artist> getArtists(String name, int page) throws IOException {
		return getArtistResultsPage(name, page).getResultsPage().getResults().getArtists();
	}

	/**
	 * Return a list of all Artists matching a given name
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	
	public List<Artist> getArtists(String name) throws IOException {
		List<Artist> artists = new ArrayList<Artist>();
		int pageNum = 1;

		List<Artist> page = getArtists(name, pageNum);
		while (page!=null && (page.size()>0)) {
			artists.addAll(page);

			// If there might be more artists to grab, get another set
			if (page.size()==50) page = getArtists(name, ++pageNum); 
			else page = null;
		}
		return artists;
	}
	
	/**
	 * Helper method; pulls in a page of Location results matching a given name and returns it 
	 * 
	 * @param name
	 * @param page
	 * @return
	 * @throws IOException
	 */
	private LocationResultsPage getLocationResultsPage(String name, int page) throws IOException {
		BufferedReader reader = getReader("http://api.songkick.com/api/3.0/search/locations.json?page=" + page + "&query=" + URLEncoder.encode(name, "UTF-8"));
		Gson gson = new Gson();
		return gson.fromJson(reader,LocationResultsPage.class);
	}

	/**
	 * Return a specific page of Locations matching a given name
	 * 
	 * @param name
	 * @param page
	 * @return
	 * @throws IOException
	 */
	public List<Location> getLocationsByName(String name, int page) throws IOException {
		return getLocationResultsPage(name, page).getResultsPage().getResults().getLocations();
	}
	
	/**
	 * Return all locations matching a given name
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	
	public List<Location> getLocationsByName(String name) throws IOException {
		List<Location> locations = new ArrayList<Location>();
		int pageNum = 1;

		List<Location> page = getLocationsByName(name, pageNum);
		while (page!=null && (page.size()>0)) {
			locations.addAll(page);
			// If there might be more locations to grab, get another set
			if (page.size()==50) page = getLocationsByName(name, ++pageNum);
			else page = null;
		}
		return locations;
	}
	
	/**
	 * Helper method; pulls in a page of location results specified by lat and lng and returns it 
	 * 
	 * @param lat
	 * @param lng
	 * @param page
	 * @return
	 * @throws IOException
	 */

	private LocationResultsPage getLocationResultsPage(double lat, double lng, int page) throws IOException {
		BufferedReader reader = getReader("http://api.songkick.com/api/3.0/search/locations.json?location=geo:" + lat + "," + lng +"&page="+page);
		Gson gson = new Gson();
		return gson.fromJson(reader,LocationResultsPage.class);
	}

	/**
	 * Return a specific page of Locations, given a lat and lng
	 * 
	 * @param lat
	 * @param lng
	 * @param page
	 * @return
	 * @throws IOException
	 */
	
	public List<Location> getLocationsByLatLng(double lat, double lng, int page) throws IOException {
		return getLocationResultsPage(lat, lng, page).getResultsPage().getResults().getLocations();
	}
	
	/**
	 * Return a list of all Locations matching a given lat and lng
	 * 
	 * @param lat
	 * @param lng
	 * @return
	 * @throws IOException
	 */
	
	public List<Location> getLocationsByLatLng(double lat, double lng) throws IOException {
		List<Location> locations = new ArrayList<Location>();
		int pageNum = 1;

		List<Location> page = getLocationsByLatLng(lat, lng, pageNum);
		while (page!=null && (page.size()>0)) {
			locations.addAll(page);
			// If there might be more Locations to grab, get another set
			if (page.size()==50) page = getLocationsByLatLng(lat, lng, ++pageNum);
			else page = null;
		}
		return locations;
	}

	
	public List<Event> getEvents(EventFilter ef, int page) throws IOException {
		
		String url = "http://api.songkick.com/api/3.0/events.json?";
		if (ef.getArtistName()!=null) {
			url = url + "&artist_name=" + URLEncoder.encode(ef.getArtistName(), "UTF-8");
		}

		if (ef.getMaxDate()!=null) {
			url = url + "&max_date=" + dateFormatter.format(ef.getMaxDate());
		}

		if (ef.getMinDate()!=null) {
			url = url + "&min_date=" + dateFormatter.format(ef.getMinDate());
		}
		
		if (ef.getLocation()!=null) {
			url = url + "&location=";
			if (ef.getLocation().isClientIp()) url = url + "clientIp";
			else if (ef.getLocation().getIp()!=null) url = url + "ip:" + ef.getLocation().getIp();
			else if (ef.getLocation().getMetroId()!=null) url = url + "sk:" + ef.getLocation().getMetroId();
			else if (ef.getLocation().getLat()!=Double.MAX_VALUE && ef.getLocation().getLng()!=Double.MAX_VALUE) url = url + "geo:" + ef.getLocation().getLat() + "," + ef.getLocation().getLng();
		
		}

		url = url + "&page=" + page;
		
		BufferedReader reader = getReader(url);;
		Gson gson = new Gson();
		return gson.fromJson(reader,EventResultsPage.class).getResultsPage().getResults().getEvent();
	}
	
}
