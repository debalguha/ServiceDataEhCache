package org.petalsoft.dataservice.model;

import java.io.Serializable;

public class Instrument implements Comparable<Instrument>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3547290455101760912L;
	private Long quorumListingId;
	private String ric;
	private String isin;
	private String sedol;
	public Long getQuorumListingId() {
		return quorumListingId;
	}
	public void setQuorumListingId(Long quorumListingId) {
		this.quorumListingId = quorumListingId;
	}
	public String getRic() {
		return ric;
	}
	public void setRic(String ric) {
		this.ric = ric;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getSedol() {
		return sedol;
	}
	public void setSedol(String sedol) {
		this.sedol = sedol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quorumListingId == null) ? 0 : quorumListingId.hashCode());
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
		Instrument other = (Instrument) obj;
		if (quorumListingId == null) {
			if (other.quorumListingId != null)
				return false;
		} else if (!quorumListingId.equals(other.quorumListingId))
			return false;
		return true;
	}
	public Instrument(Long quorumListingId, String ric, String isin, String sedol) {
		super();
		this.quorumListingId = quorumListingId;
		this.ric = ric;
		this.isin = isin;
		this.sedol = sedol;
	}
	public Instrument() {}
	public int compareTo(Instrument o) {
		return quorumListingId.compareTo(o.quorumListingId);
	}
	
	
}
