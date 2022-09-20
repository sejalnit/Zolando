package org.sdet40.practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class FetchDetafromDataBase {
	 public static void main(String[] args) throws SQLException {
//1.create object for driver
     Driver dbdriver=new Driver();
//2.register driver instance to the object
    DriverManager.registerDriver(dbdriver);
//3.get the database connection
    Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root" );
try {
//4.create the statement
	Statement state =  connect.createStatement();
// 5.execute the query
	ResultSet result= state.executeQuery("select * from sdet40");
//6. verify,iterate or fetch the data
	while(result.next()) {
		System.out.println(result.getString("emp_name"));
	}
}
finally {
	//7. close the database.
	connect.close();
	System.out.println("connection closed successfully");
}
	 }
}


