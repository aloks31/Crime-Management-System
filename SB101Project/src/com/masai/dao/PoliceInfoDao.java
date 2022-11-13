package com.masai.dao;

import com.masai.exception.PoliceInfoException;
import com.masai.model.Policeinfo;

public interface PoliceInfoDao {
	
	public String registerPolice(Policeinfo policeinfo) throws PoliceInfoException;
	
	public String LoginInPolice(String username, String password) throws PoliceInfoException;

}
