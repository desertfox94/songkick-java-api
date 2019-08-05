/**
§ * $Revision$
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

import java.io.Serializable;
import java.util.List;

public class Reason implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 53507783836589498L;
	private List<Artist> trackedArtist;

	public List<Artist> getTrackedArtist() {
		return trackedArtist;
	}

	public void setTrackedArtist(List<Artist> trackedArtist) {
		this.trackedArtist = trackedArtist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((trackedArtist == null) ? 0 : trackedArtist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reason other = (Reason) obj;
		if (trackedArtist == null) {
			if (other.trackedArtist != null)
				return false;
		} else if (!trackedArtist.equals(other.trackedArtist))
			return false;
		return true;
	}
	
	
}
