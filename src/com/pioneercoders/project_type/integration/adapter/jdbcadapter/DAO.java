/**
 * 
 */
package com.bhaskar.project_type.integration.adapter.jdbcadapter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Types;


import com.bhaskar.project_type.exception.DaoException;




//import javax.naming.Exception;  replaced Naming Exception with Exception



/** 
 * @author Ravi Shankar Birlangi
 */
public abstract class DAO {
	
	public List executeQuery(String sql,Object[] params) throws DaoException {
		
		
		System.out.println("execute query with parms: "+params.length);
		System.out.println("sql "+sql);
		System.out.println("parm "+params[0]);
		List rowlist = new ArrayList();
		Connection con = null;
		try{
		con=DBConnection.getInstance().getConnection();

		Map colMap = null;
		
		PreparedStatement ps = con.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			Object obj = params[i];
			System.out.println("obj class"+obj.getClass());
			if(obj instanceof String){
				System.out.println("obj instanceof String::"+params[i]);
				ps.setString(i+1, (String)params[i]);
			}
			if(obj instanceof java.util.Date){
				
				java.sql.Date sqlDate = new java.sql.Date(((java.util.Date) obj).getTime());
				System.out.println(sqlDate.getYear()+"test"+sqlDate.getDay()+"te"+sqlDate.getMonth() +"test");
				ps.setDate(i+1, sqlDate);
			}
		}
		System.out.println("Enrollment");
		//ResultSetMetaData data = ps.getMetaData();
		//System.out.println("col1 "+data.getColumnName(1));
		//System.out.println("col2 "+data.getColumnName(2));
        System.out.println("metaData");
		ResultSet rs = ps.executeQuery();

		ResultSetMetaData rsm = rs.getMetaData();
		System.out.println("rs="+rs);
		String colName = null;
		Object colValue = null;
		while(rs.next()){
			colMap=new HashMap();
			for(int i=1;i<=rsm.getColumnCount();i++){
				colValue = rs.getObject(i);
				colName = rsm.getColumnName(i);
				System.out.println("colName: "+colName+" value: "+colValue); 
				
				colMap.put(colName, colValue);
			}
			rowlist.add(colMap);
		}
	//	System.out.println("rowlist="+rowlist.size());
		}catch(SQLException e){
			//e.printStackTrace();
			//System.out.println(e.getMessage(),e);
			throw  new DaoException(e.getMessage(), e);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	System.out.println(e.getMessage(),e);
			throw  new DaoException(e.getMessage(), e);
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					new DaoException(e.getMessage(), e);
				}
			}
		}
		return rowlist;		
	}
	
	public List executeQuery(String sql) throws DaoException {
		
		System.out.println("in side execute query");
	
		System.out.println("sql is :"+sql);
		List rowlist = new ArrayList();
		Connection con = null;
		try{		
		con=DBConnection.getInstance().getConnection();

		Map colMap = null;
		
		PreparedStatement ps = con.prepareStatement(sql);		
		
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsm = rs.getMetaData();
		
		String colName = null;
		Object colValue = null;
		while(rs.next()){
			colMap=new HashMap();
			for(int i=1;i<=rsm.getColumnCount();i++){				
				//log.debug("cloumn count"+rsm.getColumnCount());
				colValue = rs.getObject(i);
				colName = rsm.getColumnName(i);
				//System.out.println("columen name and value are: "+colName+" : "+colValue);
				colMap.put(colName, colValue);
				
			}
			rowlist.add(colMap);
		}
	}catch(SQLException e){
		//e.printStackTrace();
	//	log.error(e.getMessage(),e);
		throw  new DaoException(e.getMessage(), e);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//log.error(e.getMessage(),e);
		throw  new DaoException(e.getMessage(), e);
	}finally{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw  new DaoException(e.getMessage(), e);
			}
		}
	}
	System.out.println("NO. of rows list "+rowlist.size());
		return rowlist;
		
	}

	/** 
	
	 */
  /*	 public int executeUpdate(String sql,Object[] params) throws SQLException, Exception {
		
		System.out.println("executeUpdate query "+sql);
		Connection con = null;
		PreparedStatement ps = null;
		int rowsModified =0;
		try{		
		con=DBConnection.getInstance().getConnection();
		if(con!=null){
			System.out.println("Connection is successful");
		}
		else
		{
			System.out.println("Connection is not successful");
		}
		System.out.println("SQL:"+ sql);
		ps = con.prepareStatement(sql);
		
		for(int i=0;i<=params.length;i++){
			System.out.println("param is "+i+":"+params[i]); 
			Object obj = params[i];
			if(obj instanceof String){
				System.out.println("obj class"+obj.getClass());
				try {
					ps.setString(i+1, (String)params[i]);
				} catch (Exception e) {
					System.out.println(e.getMessage()+e.getCause());
					e.printStackTrace();
				}
			}
			if(obj instanceof java.util.Date){
				System.out.println("obj class"+obj.getClass());
				ps.setDate(i+1, (java.sql.Date)params[i]);
			}
		}
		
		System.out.println("after for loop");
		rowsModified = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("sql exception "+e.getMessage()+e.getErrorCode());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Here is the exception"+e.getMessage()+e.getCause());
			throw new Exception("Exception got "+e.getMessage()+e.getCause());
		}finally{
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		}		
		return rowsModified;
		
	}   */
	
public int executeUpdate(String sql,Object[] params)  throws DaoException  {
		
	//Log log = ConciergeLogManager.getLogger();
		System.out.println("sql : "+sql); 
		System.out.println("parms "+params);
		Connection con = DBConnection.getInstance().getConnection();
		for(int i=0;i<params.length;i++){
			System.out.println("params "+params[i]);
		}
		if(con!=null)
			System.out.println("connection successful");
		PreparedStatement ps = null;
		int rowsModified =0;
		try{		
		//con=DBConnection.getInstance().getConnection();
		ps = con.prepareStatement(sql);
		System.out.println("before for " );
		for(int i=0;i<params.length;i++){
			Object obj = params[i];
			if(obj instanceof String){
				ps.setString(i+1, (String)params[i]);
			}
			if(obj instanceof java.util.Date){
				ps.setDate(i+1, (java.sql.Date)params[i]);
			}
		}
		System.out.println("after for " );
		rowsModified = ps.executeUpdate();
		System.out.println("rowsModified "+rowsModified);
		}catch(SQLException e){
			e.printStackTrace();
			throw  new DaoException(e.getMessage(), e);
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw  new DaoException(e1.getMessage(), e1);
			}
			try {
				con.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw  new DaoException(e1.getMessage(), e1);
			}
			System.out.println("Exception "+e.getMessage()); 
			// TODO Auto-generated catch block
			throw  new DaoException(e.getMessage(), e);
		}finally{
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw  new DaoException(e.getMessage(), e);
				}
		}
		return rowsModified;
		
	}
	
	
	 
	 
	public int executeUpdate(String sql) throws  DaoException  {
		// Log log = ConciergeLogManager.getLogger();
		Connection con = null;
		PreparedStatement ps = null;
		int rowsModified =0;
		System.out.println("sql:"+sql);
		try{				
		con=DBConnection.getInstance().getConnection();
		ps = con.prepareStatement(sql);	
		rowsModified = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw  new DaoException(e.getMessage(), e);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw  new DaoException(e.getMessage(), e);
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw  new DaoException(e.getMessage(), e);
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw  new DaoException(e.getMessage(), e);
				}
			}
		}			
		return rowsModified;
		
	}
	
	/*	public String executeCall(String strSProcedure, String strParameters[])
		throws SQLException
		{  
			Log log = ConciergeLogManager.getLogger();
			log.debug("in side execute call proc name is "+strSProcedure);
			String resultCall = " ";
			String arrError = "";
			Connection con = null;
			CallableStatement cs = null;
			try  
			{
				con	= DBConnection.getInstance().getConnection();
				
			}
			catch(Exception e)
			{
				arrError = "Exception occured while establishing Database connection.Please check the config file and try after some time, connection could be down " + e.getMessage();
				return arrError;
			}
			if(con!=null)
				log.debug("connected to db");
			try{
				String proc = "{call " + strSProcedure + "}";
				log.debug("proc is "+ proc); 
				 cs = con.prepareCall(proc);
				int arrayLength = strParameters.length;
				/*cs.setString(1, strParameters[0]);
				cs.setString(2, strParameters[1]);
				cs.setString(3, strParameters[2]);
				cs.setString(4, strParameters[3]);
				cs.setString(5, strParameters[4]);
				cs.registerOutParameter(6, Types.INTEGER);
				
				cs.registerOutParameter(arrayLength + 1, Types.VARCHAR);
				log.debug("length of array "+strParameters.length);
				for(int iIndex = 0; iIndex < arrayLength; iIndex++){
					log.debug("parm is "+strParameters[iIndex]);
					cs.setString(iIndex + 1, strParameters[iIndex]);
				}
			
				cs.execute();
				resultCall = cs.getString(arrayLength + 1);
				cs.close();
			}catch(Exception e){
				log.error("Exception occured "+e.getMessage());
			}finally{
				if(cs!=null){
					cs.close();
				}
				if(con != null)
					con.close();
			}
			
				
			
			log.debug("Result call"+resultCall);
			return resultCall;
			
		} */
}