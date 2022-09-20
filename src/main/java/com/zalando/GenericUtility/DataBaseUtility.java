package com.zalando.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection connection;

	public void openDataBaseConnection(String dbURL,String dbUserName,String dbPasswrd) throws SQLException {
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		connection=DriverManager.getConnection(dbURL,dbUserName,dbPasswrd);
		
	}
	
	public List<String> getDataFromDataBase(String query,String columnName) throws SQLException {
		Statement st=connection.createStatement();
		ResultSet res=st.executeQuery(query);
		List<String> lis= new ArrayList<String>();
		while (res.next()) {
		lis.add(res.getString(columnName));
			}
		return lis;
	}
	
	public void closeDB() throws SQLException
	{
		connection.close();
	}
	
	public void modifyDataIntoDB(String query) throws SQLException {
		Statement st=connection.createStatement();
		st.executeUpdate(query);
	}
		
	public boolean verifyDataIntoDatabase( String query,String columnName,String expectedData) throws SQLException {
		
	    List<String> list = getDataFromDataBase(query,columnName);
	    boolean flag=false;
	    
	    for(String actualData:list) {
	    	if(actualData.equalsIgnoreCase(expectedData))
	    	{
	    		flag=true;
	    		break;
	    	}
	    }
		return flag;
		
	}
}



