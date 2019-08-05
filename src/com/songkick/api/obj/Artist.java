package com.songkick.api.obj;

import java.io.Serializable;
import java.util.List;

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

public class Artist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4419899090126483579L;
	private String uri;
	private String displayName;
	private String id;
	private String onTourUntil;
	private List<Identifier> identifier;

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOnTourUntil() {
		return onTourUntil;
	}
	public void setOnTourUntil(String onTourUntil) {
		this.onTourUntil = onTourUntil;
	}
	public List<Identifier> getIdentifier() {
		return identifier;
	}
	public void setIdentifier(List<Identifier> identifier) {
		this.identifier = identifier;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result
				+ ((onTourUntil == null) ? 0 : onTourUntil.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		Artist other = (Artist) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (onTourUntil == null) {
			if (other.onTourUntil != null)
				return false;
		} else if (!onTourUntil.equals(other.onTourUntil))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}
	
}
