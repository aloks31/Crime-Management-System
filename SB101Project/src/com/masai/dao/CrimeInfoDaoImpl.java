package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.masai.exception.CrimeInfoException;
import com.masai.model.CrimeInfo;
import com.masai.utility.DBUtil;

public class CrimeInfoDaoImpl implements CrimeInfoDao {

	@Override
	public String AddCrime(CrimeInfo crimeinfo) throws CrimeInfoException {

		
		String message = "CrimeRecord Inserted....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into crimeinfo(cdate,cplace,crime_type,victim,description,suspect) values(?,?,?,?,?,?)");
			
			
			ps.setString(1, crimeinfo.getCdate());
			ps.setString(2, crimeinfo.getCplace());
			ps.setString(3, crimeinfo.getCrime_type());
			ps.setString(4, crimeinfo.getVictim());
			ps.setString(5, crimeinfo.getDescription());
			ps.setString(6, crimeinfo.getSuspect());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "CrimeRecord Inserted Succefully : "+crimeinfo.getCrimeid() ;
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
//			e.printStackTrace();
			throw new CrimeInfoException(e.getMessage());
			
		}
		
		return message;
	}
	
	//========================================================================================

	
	@Override
	public List<CrimeInfo> ViewAllCrime() throws CrimeInfoException {
		
		List<CrimeInfo> crime  =  new LinkedList<>();
//     	List<CrimeInfo> crime = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from crimeinfo");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int cid = rs.getInt("crimeid");
				String cd = rs.getString("cdate");
				String cp = rs.getString("cplace");
				String ct = rs.getString("crime_type");
				String cv = rs.getString("victim");
				String cs = rs.getString("description");
				String csp = rs.getString("suspect");
				String cst = rs.getString("status");
				
				crime.add(new CrimeInfo(cid,cd,cp,ct,cv,cs,csp,cst));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
//			e.printStackTrace();
			throw new CrimeInfoException(e.getMessage());
			
		}
		
		if(crime.size() == 0)
			throw new CrimeInfoException("No CrimeRecord Found...");
		
		
		return crime;
	}
	
	//========================================================================================

	@Override
	public String EditCrimeById(int crimeid, String field, String Data) throws CrimeInfoException {
		
		String message = "Not Update...";
		
	       try (Connection conn= DBUtil.provideConnection();){
			
			PreparedStatement ps = conn.prepareStatement ("update crimeinfo set "+field+"=? where Crimeid = ?");
				ps.setString(1,Data);
				ps.setInt(2, crimeid);
		
				
            int x= ps.executeUpdate();
			
			if(x>0) {
				message = "Crime Record Update Successfully...";
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new CrimeInfoException(e.getMessage());
		}
		
		return message;
		
		
	}

	//========================================================================================
	
	@Override
	public int CountCrimeStatus(String s) throws CrimeInfoException {
		
		int count=0;
		
			
			try (Connection conn= DBUtil.provideConnection();){
				
				PreparedStatement ps = conn.prepareStatement ("select count(*) from crimeinfo where status = ?");
				
					ps.setString(1,s);
					
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					
					count= rs.getInt("count(*)");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new CrimeInfoException(e.getMessage());
			}
		
		return count;
	}

	
	//========================================================================================

	@Override
	public int CrimeInMonth(String date1, String date2) throws CrimeInfoException {
		
        int count=0;
		
		try (Connection conn= DBUtil.provideConnection();){
			
			PreparedStatement ps = conn.prepareStatement ("select count(*) from crimeinfo where cdate between ? AND ?");
				ps.setString(1,date1);
				ps.setString(2, date2);
		
				
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				count= rs.getInt("count(*)");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			throw new CrimeInfoException(e.getMessage());
		}
	
	      return count;
	}
	
	//========================================================================================

	@Override
	public String SolveCrimeById(int crimeid, String status) throws CrimeInfoException {
		
		String message = "Not Updated....";
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps = conn.prepareStatement("update crimeinfo set status=? where crimeId=?");
				
			
			ps.setInt(1, crimeid);
			ps.setString(2,status);
			
			ps.executeUpdate();
			
		
				
			message = "Case Status Updated Successfully";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return message;
	}
	
	
//	//========================================================================================

	@Override
	public int TotalCrime() throws CrimeInfoException {

		
		int count=0;
		
			
			try (Connection conn= DBUtil.provideConnection();){
				
				PreparedStatement ps = conn.prepareStatement ("select count(crimeid) from crimeinfo;");
				
					
					
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()) {
					
					count= rs.getInt("count(crimeid)");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				throw new CrimeInfoException(e.getMessage());
			}
		
		return count;
		
	}

}
