package com.masai.model;

public class Policeinfo {
	
	private int pid;
	private String username;
	private String passaword;
	
	public Policeinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policeinfo(int policeid, String username, String passaword) {
		super();
		this.pid = policeid;
		this.username = username;
		this.passaword = passaword;
	}

	public int getPoliceid() {
		return pid;
	}

	public void setPoliceid(int policeid) {
		this.pid = policeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassaword() {
		return passaword;
	}

	public void setPassaword(String passaword) {
		this.passaword = passaword;
	}

	@Override
	public String toString() {
		return "police [policeid=" + pid + ", username=" + username + ", passaword=" + passaword + "]";
	}

	
}
