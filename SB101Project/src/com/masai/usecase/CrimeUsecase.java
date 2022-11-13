package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CrimeInfoDao;
import com.masai.dao.CrimeInfoDaoImpl;
import com.masai.exception.CrimeInfoException;
import com.masai.model.CrimeInfo;

public class CrimeUsecase {
	
	//1
	public static void AddCrimeRecord() {
		
		Scanner sc= new Scanner (System.in);
			
		System.out.println("Enter Crime Date YYYY-MM-DD Format: ");
		String date=sc.nextLine();
		
		System.out.println("Enter Crime Place : ");
		String place=sc.nextLine();
		
		System.out.println("Enter crime Type : ");
		String crime=sc.nextLine();
		
		System.out.println("Enter Victims Name : ");
		String victim=sc.nextLine();
		
		System.out.println("Enter Detail Description of crime: ");
		String desc=sc.nextLine();
		
		System.out.println("Enter Crime Suspected name : ");
		String suspect=sc.nextLine();
		
//		System.out.println("Enter Crime Status : ");
//		String status=sc.nextLine();
		
		CrimeInfoDao dao = new CrimeInfoDaoImpl();
		
		CrimeInfo c = new CrimeInfo();
		
		c.setCdate(date);
		c.setCplace(place);
		c.setCrime_type(crime);
		c.setVictim(victim);
		c.setDescription(desc);
		c.setSuspect(suspect);
//		c.setSuspect(status);
		
		String result;
		try {
			result = dao.AddCrime(c);
			
			System.out.println(result);
		} catch (CrimeInfoException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	//=============================================================================================
	
	//2
	public static void UpdateCrimeInfo() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter CrimeId");
		int roll= sc.nextInt();
		
		System.out.println("Enter field");
		String field = sc.next();
		
		System.out.println("Enter value");
		String value = sc.next();
		
		CrimeInfoDao dao = new CrimeInfoDaoImpl();
//		Student1 dao= new StudentIMP();
		
		try {
			String res= dao.EditCrimeById(roll, field, value);
			System.out.println(res);
		} catch (CrimeInfoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	
	
	//=============================================================================================
	
	//3
	public static void viewcrimerecord() {
		
		CrimeInfoDao dao = new CrimeInfoDaoImpl();
		
		try {
			List<CrimeInfo> show = dao.ViewAllCrime();
		
				show.forEach(s -> {
					
					System.out.println("Crime Id :"+s.getCrimeid());
					System.out.println("Crime Date : "+s.getCdate());
					System.out.println("Crime Place: "+s.getCplace());
					System.out.println("Crime Name: "+s.getCrime_type());
					System.out.println("Crime Victims: "+s.getVictim());
					System.out.println("Crime Description: "+s.getDescription());
					System.out.println("Crime Suspected name : "+s.getSuspect());
					System.out.println("Crime Case Status: "+s.getStatus());
//			        System.out.println(s);
					System.out.println("================================================");
					
					
					
				});
			
			
			
		} catch (CrimeInfoException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	//=============================================================================================
	
	//4
	public static void Totalcrime() {
		
		CrimeInfoDao dao = new CrimeInfoDaoImpl();
		
//		Scanner sc= new Scanner (System.in);
		
//		System.out.println("Enter the value of Case status");
//		String s=sc.next();
		
		try {
			int count = dao.TotalCrime();
			System.out.println("Total Number Of Crime : "+count);
		} catch (CrimeInfoException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	//=============================================================================================
	
	//5

	public static void countcrimestatus() {
		
		CrimeInfoDao dao = new CrimeInfoDaoImpl();
		
		Scanner sc= new Scanner (System.in);
		
		System.out.println("Enter the value of Case status");
		String s=sc.next();
		
		try {
			int count = dao.CountCrimeStatus(s);
			System.out.println(count);
		} catch (CrimeInfoException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	//=============================================================================================
	
		//7
	public static void CrimeInMonth() {
		
		CrimeInfoDao dao = new CrimeInfoDaoImpl();
		
		Scanner sc= new Scanner (System.in);
		System.out.println("Enter the  Date of the Month Start :");
		String date1=sc.next();
		System.out.println("Enter the Date of the Month End: ");
		String date2=sc.next();
		
		try {
			int count = dao.CrimeInMonth(date1, date2);
			
			System.out.println("Number of crimes recorded in the current month : "+count);
			
		} catch (CrimeInfoException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	

}
