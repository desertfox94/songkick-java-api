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

public class CalendarResultsPageContents extends ResultsPageContents {

	private CalendarResults results;
	private int totalEntries;
	private int perPage;
	private int page;
	
	public Results getResults() {
		return results;
	}
	public void setResults(CalendarResults results) {
		this.results = results;
	}
	public int getTotalEntries() {
		return totalEntries;
	}
	public void setTotalEntries(int totalEntries) {
		this.totalEntries = totalEntries;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
