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

public class SingleEventResultsPageContents extends ResultsPageContents {

	private SingleEventResults results;
	
	public void setResults(SingleEventResults results) {
		this.results = results;
	}
	public Results getResults() {
		return results;
	}
	
	
}
