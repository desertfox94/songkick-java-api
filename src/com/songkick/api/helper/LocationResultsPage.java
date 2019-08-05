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

public class LocationResultsPage implements ResultsPage {
	private LocationResultsPageContents resultsPage;

	public LocationResultsPageContents getResultsPage() {
		return resultsPage;
	}

	public void setResultsPage(LocationResultsPageContents resultsPage) {
		this.resultsPage = resultsPage;
	}

	public ResultsPageContents getResultsPageContents() {
		return resultsPage;
	}
	
	
}
