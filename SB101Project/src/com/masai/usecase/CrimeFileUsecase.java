package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.Crime_criminalDao;
import com.masai.dao.Crime_criminalDaoImpl;
import com.masai.exception.CrimeInfoException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeCriminalDTO;
import com.masai.model.Crime_criminal;

public class CrimeFileUsecase {
	
	public static void filereport() {
		

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Criminal Name to Get details of Crime :");
		String cname= sc.next();

		
		Crime_criminalDao dao = new Crime_criminalDaoImpl();
		
		try {
			List<CrimeCriminalDTO> show = dao.CrimeFile(cname);
			
			show.forEach(s -> {
				
				System.out.println("Criminal Name : "+s.getName());
				System.out.println("Criminal Age : "+s.getAge());
				System.out.println("Criminal Gender : "+s.getGender());
				
				System.out.println("Crime Id :"+s.getCrimeid());
				System.out.println("Crime Date : "+s.getCdate());
				System.out.println("Crime Place: "+s.getCplace());
				System.out.println("Crime Name: "+s.getCrime_type());
				System.out.println("Crime Victims: "+s.getVictim());
				
//		        System.out.println(s);
				System.out.println("================================================");
				
				
				
			});
			
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
           System.out.println(e.getMessage());
 		}
		
		
		
//		
//		try {
//		CrimeCriminalDTO dtos= dao.CrimeFile(cname);
//		
//		System.out.println(dtos);
//		
//		
//		
//		}catch(CriminalException c) {
//			System.out.println(c.getMessage());
//		}
		

		
	}
	
}
