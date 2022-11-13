package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.exception.PoliceInfoException;
import com.masai.model.Policeinfo;
import com.masai.utility.DBUtil;

public class PoliceInfoDaoImpl implements PoliceInfoDao {

	@Override
	public String registerPolice(Policeinfo policeinfo) throws PoliceInfoException {
		
		String message = "Not Inserted....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into policeinfo(username,password) values(?,?)");
			
			ps.setString(1, policeinfo.getUsername());
			ps.setString(2, policeinfo.getPassaword());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Registred Succefully...";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new PoliceInfoException(e.getMessage());
			
		}
		
		return message;
		
	}

	@Override
	public String LoginInPolice(String username, String password) throws PoliceInfoException {
		
		String message = "Login Failed...";
		
       try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from policeinfo where username=? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();

			if(rs.next())
			{
				message = "Login Succefully..";
				
			}else
				throw new PoliceInfoException("Invalid Username And password...");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new PoliceInfoException(e.getMessage());
			
		}
		
		return message;
	}

}
