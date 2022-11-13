package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import com.masai.exception.CrimeInfoException;
import com.masai.exception.CriminalException;
import com.masai.model.CrimeCriminalDTO;
import com.masai.model.CrimeInfo;
import com.masai.utility.DBUtil;

public class Crime_criminalDaoImpl implements Crime_criminalDao {

	@Override
	public List<CrimeCriminalDTO> CrimeFile(String name) throws CriminalException {

		List<CrimeCriminalDTO> cri = new LinkedList<>();
//		CrimeCriminalDTO cri=new CrimeCriminalDTO();

		try(Connection conn= DBUtil.provideConnection();) {
		
			PreparedStatement ps = conn.prepareStatement ("select c.name,c.age,c.gender,"
					+ "cr.crimeid,cr.cdate,cr.cplace,cr.Crime_type,cr.victim from "
					+ "criminal c inner join crimeinfo cr on c.crimeid = cr.crimeid "
					+ "where c.name = ?");
			
			ps.setString(1,name);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int cid = rs.getInt("crimeid");
				String cd = rs.getString("cdate");
				String cp = rs.getString("cplace");
				String ct = rs.getString("crime_type");
				String cv = rs.getString("victim");

				String n = rs.getString("name");
				int a = rs.getInt("age");
				String age = rs.getString("gender");
				
				cri.add(new CrimeCriminalDTO(cid,cd,cp,ct,cv,n,a,age));
              
//				cri.setCrimeid(rs.getInt("crimeid"));
//				cri.setCdate(rs.getString("cdate"));
//				cri.setCplace(rs.getString("cplace"));
//				cri.setCrime_type(rs.getString("crime_type"));
//				cri.setVictim(rs.getString("victim"));
//				
//			    cri.setName(rs.getString("name"));
//			    cri.setAge(rs.getInt("age"));
//			    cri.setGender(rs.getString("gender"));
     
	           
	
			}
			} catch (SQLException e) {
				throw new CriminalException(e.getMessage());
				
			}
			
	
		    if(cri.size() == 0)
			   throw new CriminalException("No Record Found...");
			
			
			
			return cri;
	
		
	}

}
