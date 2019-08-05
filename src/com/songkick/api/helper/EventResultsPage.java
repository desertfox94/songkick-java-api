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

public class EventResultsPage implements ResultsPage {
	private EventResultsPageContents resultsPage;

	public EventResultsPageContents getResultsPage() {
		return resultsPage;
	}

	public void setResultsPage(EventResultsPageContents resultsPage) {
		this.resultsPage = resultsPage;
	}
	
	public ResultsPageContents getResultsPageContents() {
		return resultsPage;
	}
	
	
}
