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

public class ArtistResultsPage implements ResultsPage {
	private ArtistResultsPageContents resultsPage;

	public ArtistResultsPageContents getResultsPage() {
		return resultsPage;
	}

	public void setResultsPage(ArtistResultsPageContents resultsPage) {
		this.resultsPage = resultsPage;
	}

	public ResultsPageContents getResultsPageContents() {
		return resultsPage;
	}
	
	
}
