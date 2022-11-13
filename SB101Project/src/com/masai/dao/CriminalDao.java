package com.masai.dao;

import java.util.List;

import com.masai.exception.CriminalException;
import com.masai.model.Criminal;

public interface CriminalDao {
	
	public String AddCriminal(Criminal criminal) throws CriminalException;
	
	public List<Criminal> ViewAllCriminal() throws CriminalException;
	
	public String EditCriminalById(int id, String field, String Data) throws CriminalException;
	
	public int NoOfCriminal() throws CriminalException;

}
