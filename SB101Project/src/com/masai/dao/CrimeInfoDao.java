package com.masai.dao;

import java.util.List;

import com.masai.exception.CrimeInfoException;
import com.masai.model.CrimeInfo;

public interface CrimeInfoDao {
	
	public String AddCrime(CrimeInfo crimeinfo) throws CrimeInfoException;	
	
	public List<CrimeInfo> ViewAllCrime() throws CrimeInfoException;
	
	public String EditCrimeById(int crimeid, String field, String Data) throws CrimeInfoException;
	
	public int CountCrimeStatus(String s) throws CrimeInfoException;
	
	public int TotalCrime() throws CrimeInfoException;
//	
//	public int NoUnsolvedCrime(int crimeid) throws CrimeInfoException;
	
	public int CrimeInMonth(String date1, String date2) throws CrimeInfoException;
	
	public String SolveCrimeById(int crimeid, String status) throws CrimeInfoException;

}
