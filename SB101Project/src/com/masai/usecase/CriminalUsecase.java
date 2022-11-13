package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CriminalDao;
import com.masai.dao.CriminalDaoImpl;
import com.masai.exception.CriminalException;
import com.masai.model.Criminal;

public class CriminalUsecase {
	
	public static void AddCriminalRecord() {
		
		Scanner sc= new Scanner (System.in);
			
		System.out.println("Enter Criminal name : ");
		String name=sc.nextLine();
		
		System.out.println("Enter Criminal Age : ");
		int age=sc.nextInt();
		
		System.out.println("Enter criminal Gender : ");
		String gender=sc.next();
		sc.nextLine();
		
		System.out.println("Enter Criminal Address : ");
		String address=sc.nextLine();
		
		System.out.println("Enter Criminal Identity : ");
		String identity=sc.nextLine();
		
		System.out.println("Enter Area Of Crime : ");
		String area=sc.nextLine();
		
		System.out.println("Enter Crime Type : ");
		String ctype=sc.nextLine();
		
		System.out.println("Enter Criminal CrimeId : ");
		int Cid=sc.nextInt();
		
		CriminalDao dao = new CriminalDaoImpl();
		
		Criminal c = new Criminal();
		
		c.setName(name);
		c.setAge(age);
		c.setGender(gender);
		c.setAddress(address);
		c.setIdentity(identity);
		c.setArea_of_crime(area);
		c.setCrime_type(ctype);
		c.setCrimeid(Cid);
		
		String result;
		try {
			result = dao.AddCriminal(c);
			
			System.out.println(result);
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
	}

	//====================================================================================================
    
	//2	
	public static void UpdateCriminalRecord() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Id");
		int roll= sc.nextInt();
		
		System.out.println("Enter field");
		String field = sc.next();
		
		System.out.println("Enter value");
		String value = sc.next();
		
		CriminalDao dao = new CriminalDaoImpl();
//		Student1 dao= new StudentIMP();
		
		try {
			String res= dao.EditCriminalById(roll, field, value);
			System.out.println(res);
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	//====================================================================================================

	//3
	public static void viewcriminalrecord() {
		
		CriminalDao dao = new CriminalDaoImpl();
		
		try {
			List<Criminal> show = dao.ViewAllCriminal();
			
//			List<CrimeInfo> ans = new LinkedList<>();
//			
//			ans = dao.ViewAllCrime();
//			
				show.forEach(s -> {
					
					System.out.println("Criminal Id :"+s.getId());
					System.out.println("Criminal Name : "+s.getName());
					System.out.println("Criminal Age : "+s.getAge());
					System.out.println("Criminal Gender : "+s.getGender());
					System.out.println("Criminal Address : "+s.getAddress());
					System.out.println("Criminal Identity : "+s.getIdentity());
					System.out.println("Crime Area : "+s.getArea_of_crime());
					System.out.println("Criminal Crime Type : "+s.getCrime_type());
					System.out.println("Criminal CrimeId :"+s.getCrimeid());
//			        System.out.println(s);
					System.out.println("================================================");
					
					
					
				});
			
			
			
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	//====================================================================================================

		//4
	public static void TotalCriminal() {
		CriminalDao dao = new CriminalDaoImpl();
		
		try {
			int count = dao.NoOfCriminal();
			System.out.println("Total Number Of Criminal : "+count);
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
}
