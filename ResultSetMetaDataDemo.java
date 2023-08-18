package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Registered");
			
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "root");
			System.out.println("Connected");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from Employee");
			ResultSetMetaData rsmd=rs.getMetaData();
			
			int count=rsmd.getColumnCount();
			for(int i=1; i<=count; i++){
				System.out.println(rsmd.getColumnName(i));
				System.out.println("\t"+rsmd.getColumnTypeName(i));
				System.out.println("\t"+rsmd.getColumnDisplaySize(i));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
