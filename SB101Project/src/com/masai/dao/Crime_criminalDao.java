package com.masai.dao;

import java.util.List;

import com.masai.exception.CriminalException;
import com.masai.model.CrimeCriminalDTO;

public interface Crime_criminalDao {
	
	public List<CrimeCriminalDTO>  CrimeFile(String name)  throws CriminalException;

}
