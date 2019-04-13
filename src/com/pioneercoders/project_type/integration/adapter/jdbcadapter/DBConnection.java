/**
 * 
 */
package com.bhaskar.project_type.integration.adapter.jdbcadapter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.utility.ReadPropertiesFile;

/** 
 * @author Bhaskar Reddy 
 */
public class DBConnection {
	/** 
	 *
	 */
	
	//This is 
	private static final DBConnection dbconnection = new DBConnection();
	private static InitialContext ctx = null;
	private static DataSource datasource = null; 
	/* static{
		try {
			ctx = new InitialContext();
			datasource = (DataSource) ctx.lookup("jdbc/concierge");			
		} catch (NamingException e) {
			datasource = null;
			System.out.println("Namming exception occured RAVI"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	private DBConnection(){
		
	}
	public static DBConnection getInstance(){
		return dbconnection;
	}
	
	public  Connection getConnection1() throws NamingException,SQLException{ //throws SQLException 
		// begin-user-code
		// System.out.println("INSIDE GET CONNECTION METHOD connection pool");
		Connection conn=null;
		if(datasource == null){
			throw new NamingException("Datasource  is not found using JNDI name jdbc\\Reserve ");
		}
		try {
			conn = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Exception while getting connection from Datasource");
			
		}
		return conn;
		// end-user-code
	}
	public Connection getConnection() throws DaoException {
		
		
		Connection connection = null;
	    try {
	        // Load the JDBC driver
	        //String driverName = "oracle.jdbc.driver.OracleDriver";
	    	String driverName=ReadPropertiesFile.getProperty("driverName");
	    	Class.forName(driverName);
	    
	        // Create a connection to the database
	        	 

	        String db_url =  ReadPropertiesFile.getProperty("db_url");
	        String db_user = ReadPropertiesFile.getProperty("db_user"); 
	        String db_password =  ReadPropertiesFile.getProperty("db_password");
	        System.out.println(driverName+"  "+db_url+"  "+db_user+"  "+db_password);
	        connection = DriverManager.getConnection(db_url, db_user, db_password);
	   
	    } catch (ClassNotFoundException e) {
	        System.out.println("excepton"+e);
	        //throw new SQLException("Exception while getting connection from Datasource");
	        throw new DaoException(e.getMessage(),e);
	    } catch (SQLException e) {
	    	System.out.println("excepton"+e);
	    	throw new DaoException(e.getMessage(),e);
	    }

		
		return connection;
		
	}
	public static void main(String  arg[]){
		DBConnection con=getInstance();
		
		
		
			
			try {
				Connection connection=con.getConnection();
				if(connection!=null){
				//connection.setAutoCommit(false);
				//connection.setTransactionIsolation(3);
				System.out.println("success"+connection.getMetaData().getURL());
				}
				else{
					System.out.println("failed");
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} 
			
		
		
	}
}