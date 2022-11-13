package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.PoliceInfoDao;
import com.masai.dao.PoliceInfoDaoImpl;
import com.masai.exception.PoliceInfoException;
import com.masai.model.Policeinfo;

public class PoliceUsecase {
	
	public static void AddAdmin() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter UserName :");
		String name= sc.next();

		System.out.println("Enter Password :");
		String password= sc.next();

		
		Policeinfo pa= new Policeinfo();
		pa.setUsername(name);
		pa.setPassaword(password);
		
		PoliceInfoDao dao = new PoliceInfoDaoImpl();
		
		try {
		String result= dao.registerPolice(pa);
		
		System.out.println(result);
		
		
		}catch (PoliceInfoException e) {
			System.out.println(e.getMessage());
		}		
		
	}
	
	
	   public static int LoginAdmin() {
		
		   int x = 0;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username :");
		String username= sc.next();

		System.out.println("Enter Password :");
		String password= sc.next();
		
		
		PoliceInfoDao dao = new PoliceInfoDaoImpl();
		
		try {
	 	String pa = dao.LoginInPolice(username, password);
		
	 	System.out.println("Login Successfull..");
	 	x=1;

		}catch (PoliceInfoException e) {
			System.out.println(e.getMessage());
		}
		
		return x;
		
	}
	
	

}
