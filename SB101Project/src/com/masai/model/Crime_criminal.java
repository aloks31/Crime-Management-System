package com.masai.model;

public class Crime_criminal {

	private int crimeid;
	private int id;
	
	public Crime_criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Crime_criminal(int crimeid, int id) {
		super();
		this.crimeid = crimeid;
		this.id = id;
	}

	public int getCrimeid() {
		return crimeid;
	}

	public void setCrimeid(int crimeid) {
		this.crimeid = crimeid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "crime_criminal [crimeid=" + crimeid + ", id=" + id + "]";
	}
	
	
}
