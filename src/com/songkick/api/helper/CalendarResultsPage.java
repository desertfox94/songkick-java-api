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

public class CalendarResultsPage implements ResultsPage {
	private CalendarResultsPageContents resultsPage;

	public CalendarResultsPageContents getResultsPage() {
		return resultsPage;
	}

	public void setResultsPage(CalendarResultsPageContents resultsPage) {
		this.resultsPage = resultsPage;
	}

	public ResultsPageContents getResultsPageContents() {
		return resultsPage;
	}
	
	
}
