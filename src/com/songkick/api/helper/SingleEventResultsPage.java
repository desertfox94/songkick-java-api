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

public class SingleEventResultsPage implements ResultsPage {
	private SingleEventResultsPageContents resultsPage;

	public SingleEventResultsPageContents getResultsPage() {
		return resultsPage;
	}

	public void setResultsPage(SingleEventResultsPageContents resultsPage) {
		this.resultsPage = resultsPage;
	}

	public ResultsPageContents getResultsPageContents() {
		return resultsPage;
	}
	
	
}
