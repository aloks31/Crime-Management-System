package com.masai.model;

public class Criminal {
	
	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String identity;
	private String area_of_crime;
	private String crime_type;
	private int Crimeid;
	
	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criminal(int id, String name, int age, String gender, String address, String identity, String area_of_crime,
			String crime_type, int crimeid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identity = identity;
		this.area_of_crime = area_of_crime;
		this.crime_type = crime_type;
		Crimeid = crimeid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getArea_of_crime() {
		return area_of_crime;
	}

	public void setArea_of_crime(String area_of_crime) {
		this.area_of_crime = area_of_crime;
	}

	public String getCrime_type() {
		return crime_type;
	}

	public void setCrime_type(String crime_type) {
		this.crime_type = crime_type;
	}

	public int getCrimeid() {
		return Crimeid;
	}

	public void setCrimeid(int crimeid) {
		Crimeid = crimeid;
	}

	@Override
	public String toString() {
		return "Criminal [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", identity=" + identity + ", area_of_crime=" + area_of_crime + ", crime_type=" + crime_type
				+ ", Crimeid=" + Crimeid + "]";
	}
	
	
	

}
