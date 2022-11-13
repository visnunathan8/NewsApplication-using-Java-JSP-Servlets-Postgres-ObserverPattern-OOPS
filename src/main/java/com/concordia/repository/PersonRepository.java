package com.concordia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.concordia.connection.ConnectToSql;
import com.concordia.entity.Person;

public class PersonRepository {
	public static int insertToPersonTable(Person person) {
		
		ConnectToSql.loadDriver();
		Connection con = ConnectToSql.getConnection();
		
		int number = -1;
		String sql = "Insert into person(firstname,middleaname,lastname,qualifier,title,role,organisation,rank,) values(?,?,?,?,?,?,?,?)";
		String sqlmulti ="Select personId from person WHERE firstname=? AND lastname=?";

		PreparedStatement ps;
		try{
			ps = con.prepareStatement(sql);
			if(person!=null && person.getFirstName()!=null) {
				ps.setString(1, person.getFirstName());
			}else {
				ps.setString(1, null);
			}
			if(person!=null && person.getMiddleName()!=null) {
				ps.setString(2, person.getMiddleName());
			}else {
				ps.setString(2, null);
			}
			if(person!=null && person.getLastName()!=null) {
				ps.setString(3, person.getLastName());
			}else {
				ps.setString(3, null);
			}
			if(person!=null && person.getQualifier()!=null) {
				ps.setString(4, person.getQualifier());
			}else {
				ps.setString(4, null);
			}
			if(person!=null && person.getTitle()!=null) {
				ps.setString(5, person.getTitle());
			}else {
				ps.setString(5, null);
			}
			if(person!=null && person.getRole()!=null) {
				ps.setString(6, person.getRole());
			}else {
				ps.setString(6, null);
			}
			if(person!=null && person.getOrganisation()!=null) {
				ps.setString(7, person.getOrganisation());
			}else {
				ps.setString(7, null);
			}
			if(person!=null) {
				ps.setInt(7, person.getRank());
			}else {
				ps.setString(7, null);
			}
		
			ps.executeUpdate();
			
			
			ps = con.prepareStatement(sqlmulti);
			
			if(person!=null && person.getFirstName() != null) {
				ps.setString(1, person.getFirstName());
			}else {
				ps.setString(1, null);
			}
			
			if(person!=null && person.getLastName() != null) {
				ps.setString(2, person.getLastName());
			}else {
				ps.setString(2, null);
			}
			
			ResultSet val = ps.executeQuery();
			
			if(val.next()) {
				number = val.getInt("headLineId");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (con != null) 
				try { 
					con.close(); 
				} 
				catch (SQLException ignore) {
					ignore.printStackTrace();
				}
		}
		return number;
	}

}