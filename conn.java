package ASimulatorSystem;
import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conn {
	  Connection c;
	    Statement s;
	    public conn(){  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");     //driver class for mysql
	            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");    
	            s =c.createStatement(); 
	            System.out.println("connection done");
	          
	            
	        }catch(Exception e){ 
	            System.out.println(e);
	        }  
	    }  

}