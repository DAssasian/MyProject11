package com.nic.dash.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.MessagingException;

public class DataAccessFromDataBase 

{ 
	 
	 private static String emailValue;
	 private static int mail_id ;
	 private static int remNo;
	 private static String attachpathData="D:\\noteicon.png",subjectData="test",ccData="dikshant.ds@gmail.com";
    
    public static void main(String[] args) throws MessagingException, IOException
    {
    	mainEmail mailsend=new mainEmail();
    	
    	 Properties properties = loadProperties("config.prop");

         String dbUrl = properties.getProperty("database.url");
         String dbUsername = properties.getProperty("database.username");
         String dbPassword = properties.getProperty("database.password");
    	
        try(Connection conn = getCoonnection(dbUrl, dbUsername, dbPassword))
         
        {
        	   	   
             String combinedPairs = DataAccessFromDataBase.getToFromGenMail(conn);

                		String[] saLkPairs = combinedPairs.split("@");
        
                		for (String saLkPair : saLkPairs) 
        				{
                				String[] values = saLkPair.split(";");
                				String sa1 = values[0];
                				String sa=sa1.trim();
                				String lk1 = values[1];
                				String lk=lk1.trim();
                			if (checkCombinationExists(conn, sa, lk)) 
        					  {
            					String emailId=fetchData(conn, sa, lk);
            					mailsend.sendMail(subjectData,attachpathData,emailId,ccData);           					
        					  }
                			else 
            					System.out.println("Combination not found in the database.");
        				}
                		
//           	        }
                		boolean status = updateReminder(conn);
    					System.out.println("Status of reminder mail been updated is "+status);
    					
    			        conn.close();

        	  }
        
        catch (SQLException e) 
            {
                  e.printStackTrace();
             }
    	
    }   
    
//for establishing connection
    
    
    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = DataAccessFromDataBase.class.getClassLoader().getResourceAsStream(fileName)) 
        {
            if (input == null) 
            {
                System.out.println("Sorry, unable to find " + fileName);
                return properties;
            }
            // Load the properties file
            properties.load(input);
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        return properties;
    }

    private static Connection getCoonnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    
    
//For checking if combination of sa and lk exists
    
	private static boolean checkCombinationExists(Connection conn, String sa, String lk) throws SQLException
    {
        PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM wlip WHERE sa = ? AND lk = ?"); 
       
            stmt.setString(1, sa);
            stmt.setString(2, lk);
            
            ResultSet rs = stmt.executeQuery();
                if (rs.next()) 
                {
                    return rs.getInt(1) > 0;
                }  
                
                stmt.close();
        return false;
    }

	//Fetching data of emailid from wlip for matched sa and lk
	
    private static String fetchData(Connection conn, String sa, String lk) throws SQLException 
    {
        PreparedStatement stmt = conn.prepareStatement("SELECT distinct email FROM wlip WHERE sa = ? AND lk = ?");
            stmt.setString(1, sa);
            stmt.setString(2, lk);
            
           ResultSet rs = stmt.executeQuery();
                while (rs.next())
                {
                	emailValue= rs.getString("email");                                   
                }
                stmt.close();
                
                return emailValue;
       
    }
    
//    Retrieving "to" from generic_mail
    
    public static String getToFromGenMail(Connection conn) throws SQLException
    {
    	String toData="";
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM generic_mail WHERE mail_id=?");
        stmt.setInt(1, 2);   // We can change the value of mail_id which we want(second value)
        ResultSet rs = stmt.executeQuery(); 

            while (rs.next()) 
            {
                 toData = rs.getString("to");
                 mail_id=rs.getInt("mail_id");
//                 attachpathData=rs.getString("attachment");
//                 ccData=rs.getString("cc");
//                 subjectData=rs.getString("subject");
            }
            stmt.close();
            
         return toData;
    }
    
    // Check if the table is empty
    private static boolean isTableEmpty(Connection conn ) throws SQLException 
    {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM generic_reminder WHERE reminder_against_mail=?" );
        stmt.setInt(1, mail_id);
  	    ResultSet rs=stmt.executeQuery();
  	     int count=0;
  	   if (!rs.next())
  	    {
           System.out.println("First row is added for corresponding mail");
           return count == 0;
         }
  	   return count == 1;      	
    }
//    Method to update reminder data in reminder_mail database
    
     public static boolean updateReminder(Connection conn) throws SQLException      
   	 { 
         PreparedStatement stmt = conn.prepareStatement("SELECT reminder_no FROM generic_reminder WHERE reminder_against_mail=?");
   	     stmt.setInt(1,mail_id);
   	     ResultSet rs=stmt.executeQuery();
   	  while(rs.next())
	     { 
			remNo=rs.getInt(1);		
		  } 	   
   
   	  if(isTableEmpty(conn))
   	  {
   		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String formattedDate = dateFormat.format(new Date());
	        Timestamp currentTime=Timestamp.valueOf(formattedDate);
			PreparedStatement stmt1 =conn.prepareStatement("INSERT INTO generic_reminder (reminder_no,reminder_date,reminder_against_mail) VALUES(?,?,?)");
			stmt1.setInt(1,0);
			stmt1.setTimestamp(2,currentTime);
			stmt1.setInt(3,mail_id);
			stmt1.executeUpdate();
			stmt1.close();			
   	  }   	  
   	  else if(remNo>=0) 	
   	      {
   	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   	        String formattedDate = dateFormat.format(new Date());
   	        Timestamp currentTime=Timestamp.valueOf(formattedDate);
   			PreparedStatement stmt1 =conn.prepareStatement("INSERT INTO generic_reminder (reminder_no,reminder_date,reminder_against_mail) VALUES(?,?,?)");
   			stmt1.setInt(1,remNo+1);
   			stmt1.setTimestamp(2,currentTime);
   			stmt1.setInt(3,mail_id);
   			stmt1.executeUpdate();
   			stmt1.close();
   		  }  
   	  return true;
    }
     
 }
 
