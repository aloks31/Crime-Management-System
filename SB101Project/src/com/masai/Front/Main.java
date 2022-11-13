package com.masai.Front;

import java.util.Scanner;

import com.masai.usecase.CrimeFileUsecase;
import com.masai.usecase.CrimeUsecase;
import com.masai.usecase.CriminalUsecase;
import com.masai.usecase.PoliceUsecase;

public class Main {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m"; 
	public static final String ANSI_YELLOW = "\u001B[33m";

       static Scanner sc= new Scanner(System.in);

        static {
		
		System.out.println();
		System.out.println();

		System.out.println("          *******************************************************************************");
		
		System.out.println();

		System.out.println(ANSI_YELLOW
                + "                   \u001B[1m  👮 👉 WELCONE TO CRIME INfORMATION MANAGEMENT SYSTEM 👈 👮"
                + ANSI_RESET);
		System.out.println();

		System.out.println("          *******************************************************************************");
		
		System.out.println();
		System.out.println();
	 
        }
        
        public static void main(String[] args) {
        	mainMenu();
		}
        
   	    public static void mainMenu() {            
			
			System.out.println(ANSI_RED +"PLEASE SELECT ONE OPTION" + ANSI_RESET);
			System.out.println();
			
//			System.out.println("1. SignUp For Admin");
			System.out.println("1. Login As A Admin");
			System.out.println("9. EXIT");
			System.out.println();
			int res = sc.nextInt();
			System.out.println();
			
			PoliceUsecase po = new PoliceUsecase();
			
			switch (res) {
//			case 1:
//			    System.out.println(ANSI_GREEN+"========================"+ ANSI_RESET);
//			    System.out.println();
//			    po.AddAdmin();
//			    mainMenu();
//			    break;
			    
			  case 1:
				System.out.println(ANSI_GREEN+"========================"+ ANSI_RESET);
			    System.out.println();
			    int x = po.LoginAdmin(); 
			    if(x==1) adminTask();
			    else mainMenu();
			    
			    break; 
		
			case 9:
			    System.out.println(ANSI_GREEN+"======THANK YOU======"+ ANSI_RESET);
			    System.out.println(ANSI_GREEN+"====FOR USING APP===="+ ANSI_RESET);
			    break;
				
			default:
				  System.out.println(ANSI_RED +"INVALID SELECTION PLEASE SELECT RIGHT ONE" + ANSI_RESET);
				  System.out.println("=====================================================");
				  System.out.println();
				  mainMenu();
			}
			
   	    }
   	    
   	    

   	 public static void adminTask() {
   		 
   		 System.out.println(ANSI_RED +"PLEASE SELECT ONE OPTION" + ANSI_RESET);
   		 System.out.println();
   			
   		 	System.out.println("1. For Crime Report");
   			System.out.println("2. For Criminal Record");
   			
   			System.out.println("9. EXIT");
   			System.out.println();
   			
   			
   			int rest = sc.nextInt();
   			
   			switch (rest) {
   			  case 1:
   				System.out.println(ANSI_GREEN+"============CRIME============"+ ANSI_RESET);
   			    CrimeRecord();
   			    adminTask();
   			    break;
   			    
   			  case 2:
   				System.out.println(ANSI_GREEN+"============CRIMINAL============"+ ANSI_RESET);
 				CriminalRecord();
   			    adminTask();
   			    break;


   			  case 9:
   			    System.out.println(ANSI_GREEN+"======THANK YOU======"+ ANSI_RESET);
   			    System.out.println(ANSI_GREEN+"====FOR USING APP===="+ ANSI_RESET);
   			    break;
   			  default:
   				  System.out.println(ANSI_RED +"INVALID SELECTION PLEASE SELECT RIGHT ONE" + ANSI_RESET);
   				  adminTask();
   			}
   			
   	 }
   	    
   	 

	 public static void CrimeRecord() {
		 
		 System.out.println(ANSI_RED +"PLEASE SELECT ONE OPTION" + ANSI_RESET);
		 System.out.println();
			
		 	System.out.println("1. Add new Crime Information");
			System.out.println("2. Edit Crime Report");
			System.out.println("3. View All Crime Record");
			System.out.println("4. Total Number of Crime");
			System.out.println("5. Total Number Of Solved and Unsolved Crime");
			System.out.println("6. Total Crime in Month");	
			System.out.println("0. GO BACK");
			System.out.println("9. EXIT");
			System.out.println();
			
			CrimeUsecase cu = new CrimeUsecase();
			
			int rest = sc.nextInt();
			
			switch (rest) {
			  case 1:
			    cu.AddCrimeRecord();
			    CrimeRecord();
			    break;
			  case 2:
				cu.UpdateCrimeInfo();
				CrimeRecord();
			    break;

			  case 3:
				cu.viewcrimerecord();
				CrimeRecord();
				break;
			  case 4:
				cu.Totalcrime();
				CrimeRecord();
				break;
			  case 5:
				cu.countcrimestatus();
				CrimeRecord();
				break;
			  case 6:
				cu.CrimeInMonth();;
				CrimeRecord();
				break;
			  case 0:
//				adminAuthorizetion();
				  adminTask();
				    break;
			  case 9:
			    System.out.println(ANSI_GREEN+"======THANK YOU======"+ ANSI_RESET);
			    System.out.println(ANSI_GREEN+"====FOR USING APP===="+ ANSI_RESET);
			    break;
			  default:
				  System.out.println(ANSI_RED +"INVALID SELECTION PLEASE SELECT RIGHT ONE" + ANSI_RESET);
				  adminTask();
			}
			
	 }
   	    
   	    
	 public static void CriminalRecord() {
		 
		 
		 System.out.println(ANSI_RED +"PLEASE SELECT ONE OPTION" + ANSI_RESET);
		 System.out.println();
			
		 	System.out.println("1. Add new Criminal Information");
			System.out.println("2. Edit Criminal Record");
			System.out.println("3. View All Criminal Record");
			System.out.println("4. Total Number of Criminal");
			System.out.println("5. Criminal Crime Report");
			System.out.println("0. GO BACK");
			System.out.println("9. EXIT");
			System.out.println();

			CriminalUsecase cu = new CriminalUsecase();
			CrimeFileUsecase cf = new CrimeFileUsecase();
			
			int rest = sc.nextInt();
			
			switch (rest) {
			  case 1:
			    cu.AddCriminalRecord();
			    CriminalRecord();
			    break;
			  case 2:
				cu.UpdateCriminalRecord();
				CriminalRecord();
			    break;

			  case 3:
				cu.viewcriminalrecord();
				CriminalRecord();
				break;
			  case 4:
				cu.TotalCriminal();
				CriminalRecord();
				break;
			  case 5:
				cf.filereport();
				CriminalRecord();
				break;

			  case 0:
//				adminAuthorizetion();
				  adminTask();
				    break;
			  case 9:
			    System.out.println(ANSI_GREEN+"======THANK YOU======"+ ANSI_RESET);
			    System.out.println(ANSI_GREEN+"====FOR USING APP===="+ ANSI_RESET);
			    break;
			  default:
				  System.out.println(ANSI_RED +"INVALID SELECTION PLEASE SELECT RIGHT ONE" + ANSI_RESET);
				  adminTask();
			}
   	    
	 }
   	    
   	    
   	    

}
