package org.sdet40.practice;

import java.sql.SQLException;
import java.util.List;

import com.zalando.GenericUtility.DataBaseUtility;
import com.zalando.GenericUtility.IConstantPath;

public class FetchDataBaseFromDataBaseUtility {
	public static void main(String[] args) throws SQLException {
		DataBaseUtility db = new DataBaseUtility();
		db.openDataBaseConnection(IConstantPath.DB_URL, "root", "root");
	 List<String> data = db.getDataFromDataBase("select * from sdet40", "emp_name");
		System.out.println(data);
		
		 boolean status = db.verifyDataIntoDatabase("select * from sdet40", "emp_name", "sejal");
		 System.out.println(status);
		 boolean status2 = db.verifyDataIntoDatabase("select * from sdet40", "address","gokul");
		 System.out.println(status2);
		
		db.closeDB();
	}
}