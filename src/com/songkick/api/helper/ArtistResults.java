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
import java.util.List;
import com.songkick.api.obj.Artist;

public class ArtistResults implements Results {
	private List<Artist> artist;

	public List<Artist> getArtist() {
		return artist;
	}

	public void setArtist(List<Artist> artist) {
		this.artist = artist ;
	}
	
	public List<Artist> getList() {
		return artist;
	}
}
