package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.masai.exception.CrimeInfoException;
import com.masai.exception.CriminalException;
import com.masai.model.Criminal;
import com.masai.utility.DBUtil;

public class CriminalDaoImpl implements CriminalDao {

	@Override
	public String AddCriminal(Criminal criminal) throws CriminalException {
		
        String message = "Criminal Record Inserted....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into criminal(name,age,gender,address,identity,area_of_crime,crime_type,crimeid) values(?,?,?,?,?,?,?,?)");
			
			
			ps.setString(1, criminal.getName());
			ps.setInt(2, criminal.getAge());
			ps.setString(3, criminal.getGender());
			ps.setString(4, criminal.getAddress());
			ps.setString(5, criminal.getIdentity());
			ps.setString(6, criminal.getArea_of_crime());
			ps.setString(7, criminal.getCrime_type());
			ps.setInt(8, criminal.getCrimeid());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Criminal Record Inserted Succefully...";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
//			e.printStackTrace();
			throw new CriminalException(e.getMessage());
			
		}
		
		return message;
	}
	
	//========================================================================================

	@Override
	public List<Criminal> ViewAllCriminal() throws CriminalException {
		
		List<Criminal> criminal = new LinkedList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from criminal");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String n = rs.getString("name");
				int a = rs.getInt("age");
				String g = rs.getString("gender");
				String ad = rs.getString("address");
				String i = rs.getString("identity");
				String aoc = rs.getString("area_of_crime");
				String ct = rs.getString("crime_type");
				int cid = rs.getInt("Crimeid");
				
				criminal.add(new Criminal(id,n,a,g,ad,i,aoc,ct,cid));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
//			e.printStackTrace();
			throw new CriminalException(e.getMessage());
			
		}
		
		if(criminal.size() == 0)
			throw new CriminalException("No Criminal Record Found...");
		
		
		return criminal;
	
	}
	
	//========================================================================================

	@Override
	public String EditCriminalById(int id, String field, String Data) throws CriminalException {
		 
		String message = "Criminal Data Not Update...";
		
	       try (Connection conn= DBUtil.provideConnection();){
			
			PreparedStatement ps = conn.prepareStatement ("update criminal set "+field+"=? where id = ?");
				ps.setString(1,Data);
				ps.setInt(2, id);
		
				
         int x= ps.executeUpdate();
			
			if(x>0) {
				message = "Criminal Record Update Successfully...";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new CriminalException(e.getMessage());
		}
		
		return message;
	
		
	}
	
	//========================================================================================

	@Override
	public int NoOfCriminal() throws CriminalException {

		
		   int count=0;
			
			try (Connection conn= DBUtil.provideConnection();){
				
				PreparedStatement ps = conn.prepareStatement ("select count(id) from criminal");
				

					
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					
					count= rs.getInt("count(id)");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new CriminalException(e.getMessage());
			}
		
		   return count;
	}
	
	//========================================================================================

}
