package com.masai.model;

public class CrimeCriminalDTO {
	

	private int crimeid;
	private String cdate;
	private String cplace;
	private String crime_type;
	private String victim;

	private String name;
	private int age;
	private String gender;
	
	public CrimeCriminalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CrimeCriminalDTO(int crimeid, String cdate, String cplace, String crime_type, String victim, String name,
			int age, String gender) {
		super();
		this.crimeid = crimeid;
		this.cdate = cdate;
		this.cplace = cplace;
		this.crime_type = crime_type;
		this.victim = victim;
		this.name = name;
		this.age = age;
		this.gender = gender;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "CrimeCriminalDTO [crimeid=" + crimeid + ", cdate=" + cdate + ", cplace=" + cplace + ", crime_type="
				+ crime_type + ", victim=" + victim + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	

}
