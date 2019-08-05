package com.songkick.api;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.songkick.api.helper.ArtistResultsPage;
import com.songkick.api.helper.EventResultsPage;
import com.songkick.api.helper.LocationResultsPage;
import com.songkick.api.helper.CalendarResultsPage;
import com.songkick.api.helper.ResultsPage;
import com.songkick.api.helper.SingleEventResultsPage;
import com.songkick.api.obj.Artist;
import com.songkick.api.obj.CalendarEntry;
import com.songkick.api.obj.Event;
import com.songkick.api.obj.EventFilter;
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
	private static final int PAGE_SIZE = 50;
	private static Logger logger = Logger.getLogger(Songkick.class);
	
	public Songkick(String a) {
		this.apiKey = a;
	}
	
	/**
	 * When we're adding a parameter to a URL, we need to know whether to separate it from the rest
	 * of the URL by an & or a ?. This method sticks the appropriate separator onto the end of a URL
	 * and returns it.
	 * 
	 * @param in
	 * @return
	 */
	
	private String appendCorrectSeparator(String in) {
		String urlStr = in;
		if (urlStr.contains("?")) {
			if (!urlStr.endsWith("?")) urlStr += "&";
		} else 
			urlStr += "?";
		return urlStr;
	}
	
	/**
	 * Helper method; gets a Reader for a specific URL, silently appending our API key
	 * 
	 * @param u
	 * @return
	 * @throws IOException
	 */
	
	private BufferedReader getReader(String u) throws IOException {
		String urlStr = appendCorrectSeparator(u);
		urlStr += "apikey="+apiKey;
		logger.debug("connecting to " + urlStr);
		URL url = new URL(urlStr);
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		if (c.getResponseCode()!=200) throw new FileNotFoundException();
		return new BufferedReader(new InputStreamReader(c.getInputStream()));
	}
	
	/**
	 * Return a page of all Artists matching a given name
	 * 
	 * @param name
	 * @param page
	 * @return
	 * @throws IOException
	 */
	
	@SuppressWarnings (value="unchecked")
	public List<Artist> getArtists(String name) throws IOException {
		logger.info("getArtists() name="+name);
		String url = "http://api.songkick.com/api/3.0/search/artists.json?query=" + URLEncoder.encode(name, "UTF-8");
		return (List<Artist>) getAllPages(url, ArtistResultsPage.class);
	}

	/**
	 * Return all locations matching a given name
	 * 
	 * @param name
	 * @param page
	 * @return
	 * @throws IOException
	 */
	
	@SuppressWarnings (value="unchecked")
	public List<Location> getLocationsByName(String name) throws IOException {
		logger.info("getLocationsByName() name="+name);
		String url = "http://api.songkick.com/api/3.0/search/locations.json?query=" + URLEncoder.encode(name, "UTF-8");
		return (List<Location>) getAllPages(url, LocationResultsPage.class);
	}
		
	/**
	 * Return a list of all Locations matching a given lat and lng
	 * 
	 * @param lat
	 * @param lng
	 * @return
	 * @throws IOException
	 */
	
	@SuppressWarnings (value="unchecked")
	public List<Location> getLocationsByLatLng(double lat, double lng) throws IOException {
		logger.info("getLocationsByLatLng() lat="+lat+",lng="+lng);
		String url = "http://api.songkick.com/api/3.0/search/locations.json?location=geo:" + lat + "," + lng;
		return (List<Location>) getAllPages(url, LocationResultsPage.class);
	}
	
	/**
	 * Return all events matching an EventFilter
	 * 
	 * @param ef
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings (value="unchecked")
	public List<Event> getEvents(EventFilter ef) throws IOException {
		logger.info("getEvents() ef="+ef);
		
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
			if (ef.getLocation().isClientIp()) url = url + "&location=clientip";
			else if (ef.getLocation().getIp()!=null) url = url + "&location=ip:" + ef.getLocation().getIp();
			else if (ef.getLocation().getMetroId()!=null) url = url + "&location=sk:" + ef.getLocation().getMetroId();
			else if (ef.getLocation().getLat()!=Double.MAX_VALUE && ef.getLocation().getLng()!=Double.MAX_VALUE) url = url + "&location=geo:" + ef.getLocation().getLat() + "," + ef.getLocation().getLng();
		}
		return (List<Event>) getAllPages(url, EventResultsPage.class);

	}
	
	/**
	 * Get the calendar for a particular artist
	 * 
	 * @param artistId
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings (value="unchecked")
	public List<Event> getArtistCalendar(String artistId) throws IOException {
		logger.info("getArtistCalendar() artistId="+artistId);
		String url = "http://api.songkick.com/api/3.0/artists/" + artistId + "/calendar.json";
		return (List<Event>) getAllPages(url, EventResultsPage.class);
	}
	
	/**
	 * Get the calendar for a particular metro area
	 * 
	 * @param artistId
	 * @return
	 * @throws IOException
	 */
	
	@SuppressWarnings (value="unchecked")
	public List<Event> getMetroAreaCalendar(String areaId) throws IOException {
		logger.info("getMetroAreaCalendar() areaId="+areaId);
		String url = "http://api.songkick.com/api/3.0/metro_areas/" + areaId + "/calendar.json";
		return (List<Event>) getAllPages(url,EventResultsPage.class);
	}
	
	/**
	 * Get the calendar for a specific user
	 * 
	 * @param user
	 * @return
	 * @throws IOException
	 */
	
	@SuppressWarnings (value="unchecked")	
	public List<CalendarEntry> getUserCalendar(String user) throws IOException {
		logger.info("getUserCalendar() user="+user);
		String url = "http://api.songkick.com/api/3.0/users/" + user + "/calendar.json?reason=tracked_artist";
		return (List<CalendarEntry>) getAllPages(url, CalendarResultsPage.class);
	}

	@SuppressWarnings (value="unchecked")	
	public Event getEvent(String id) throws IOException {
		logger.info("getEvent() id="+id);
		String url = "http://api.songkick.com/api/3.0/events/" + id + ".json";
		List<Event> list = (List<Event>) getAllPages(url, SingleEventResultsPage.class);
		if (list.size()>0) return list.get(0);
		return null;
	}
	
	/**
	 * Grabs a single page of results from a given URL, parses them out into a ResultsPage and returns a
	 * List of their contents
	 * 
	 * @param url
	 * @param parsingClass
	 * @param page
	 * @return
	 * @throws IOException
	 */
	
	private List<? extends Object> getSinglePage(String url, Class<? extends ResultsPage> parsingClass, int page) throws IOException {
		String u = appendCorrectSeparator(url);

		u += "page="+page;
		BufferedReader reader = getReader(u);
		Gson gson = new Gson();

		ResultsPage rp = gson.fromJson(reader, parsingClass);
		if (rp.getResultsPageContents()==null)
			return new ArrayList<Object>();

		/* GSon seems to not pass through 404 errors if it gets a JSON response, so look for error
		 * codes in the JSON and commute these to what it should do - i.e. chuck a FileNotFoundException
		 * if we can't complete the request because the user doesn't exist
		 */
		if (rp.getResultsPageContents().getStatus().equals("error")) {
			throw new FileNotFoundException();
		}
		
		if (rp.getResultsPageContents().getResults()==null) return new ArrayList<Object>();
		return rp.getResultsPageContents().getResults().getList();
	}
	
	/**
	 * Cycle through all available pages in a set of results, grabbing them and adding them to a list, which
	 * is then returned.
	 * 
	 * @param url
	 * @param parsingClass
	 * @return
	 * @throws IOException
	 */
	
	private List<? extends Object> getAllPages(String url, Class<? extends ResultsPage> parsingClass) throws IOException {
		List<Object> ret = new ArrayList<Object>();
		int pageNum = 1;

		List<? extends Object> page = getSinglePage(url, parsingClass, pageNum);
		while (page!=null && (page.size()>0)) {
			ret.addAll(page);
			// If there might be more Locations to grab, get another set
			if (page.size()==PAGE_SIZE) page = getSinglePage(url, parsingClass, ++pageNum);
			else page = null;
		}
		return ret;
	}
	
}
