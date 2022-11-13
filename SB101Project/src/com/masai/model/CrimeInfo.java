package com.masai.model;

import java.util.Objects;

public class CrimeInfo  {

	private int crimeid;
	private String cdate;
	private String cplace;
	private String crime_type;
	private String victim;
	private String description;
	private String suspect;
	private String status;
	
	public CrimeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CrimeInfo(int crimeid, String cdate, String cplace, String crime_type, String victim, String description,
			String suspect, String status) {
		super();
		this.crimeid = crimeid;
		this.cdate = cdate;
		this.cplace = cplace;
		this.crime_type = crime_type;
		this.victim = victim;
		this.description = description;
		this.suspect = suspect;
		this.status = status;
	}

	public int getCrimeid() {
		return crimeid;
	}

	public void setCrimeid(int crimeid) {
		this.crimeid = crimeid;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getCplace() {
		return cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}

	public String getCrime_type() {
		return crime_type;
	}

	public void setCrime_type(String crime_type) {
		this.crime_type = crime_type;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuspect() {
		return suspect;
	}

	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "crimeInfo [crimeid=" + crimeid + ", cdate=" + cdate + ", cplace=" + cplace + ", crime_type="
				+ crime_type + ", victim=" + victim + ", description=" + description + ", suspect=" + suspect
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cdate, cplace, crime_type, crimeid, description, status, suspect, victim);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrimeInfo other = (CrimeInfo) obj;
		return Objects.equals(cdate, other.cdate) && Objects.equals(cplace, other.cplace)
				&& Objects.equals(crime_type, other.crime_type) && crimeid == other.crimeid
				&& Objects.equals(description, other.description) && Objects.equals(status, other.status)
				&& Objects.equals(suspect, other.suspect) && Objects.equals(victim, other.victim);
	}
	
	
	
}
