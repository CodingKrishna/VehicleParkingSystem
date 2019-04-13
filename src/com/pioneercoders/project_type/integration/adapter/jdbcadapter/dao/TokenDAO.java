package com.bhaskar.project_type.integration.adapter.jdbcadapter.dao;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.bhaskar.project_type.integration.adapter.jdbcadapter.DBConnection;



public class TokenDAO  extends DAO implements DAOInterface { 

	
	public List getEnrollmentFlag(String empcode) throws DaoException{
		String query = SqlQueryConstants.ENROLL_TYPE_FLAG;
		System.out.println(query);
		String[] parms = {empcode};
		return executeQuery(query,parms);		 
		
	}
	public List getPhotographyFlag(String empcode) throws DaoException{
		String query = SqlQueryConstants.ENROLL_TYPE_FLAG;
		System.out.println(query);
		String[] parms = {empcode};
		return executeQuery(query,parms);		 
		
	}
	
	public List getEmployeeTokenNo(String enrolldate)throws DaoException{
		String query = SqlQueryConstants.EMP_TOKEN_NO;
		String[] parms = { enrolldate};
		return executeQuery(query,parms);		 
		
	}
	public List getNonEmployeeTokenNo(String enrolldate) throws DaoException{
		String query = SqlQueryConstants.NON_EMP_TOKEN_NO;
		String[] parms = { enrolldate};
		return executeQuery(query,parms);		 
		
	}
	public int enrollForToken(String empcode,String genration_date,String tokenNo,String enrollment_type,String enrollment_date,String enrollment_time, String card_code) throws DaoException{
		String query = SqlQueryConstants.ENROLL;
		String[] parms = { empcode, genration_date, tokenNo, enrollment_type, enrollment_date, enrollment_time,  card_code};
		return executeUpdate(query,parms);		 
		
	}
	

	
	public List getEnrollmentCount(Date enrolldate,String enrollmenttype) throws DaoException{
		String query = SqlQueryConstants.ENROLLMENTCOUNTS;
		Object[] parms = {enrolldate,enrollmenttype};
		return executeQuery(query,parms);		 
		
	}
	public List getEnrollmentTimes(String enrolldate,String enrollmenttype) throws DaoException{
		String query = SqlQueryConstants.ENROLLMENT_TIMES;
		String[] parms = {enrolldate,enrollmenttype};
		return executeQuery(query,parms);		 
		
	}
	
	public List getToken(String tokenNo) throws DaoException{
		String query = SqlQueryConstants.SEARCH_TOKEN;
		System.out.println(query);
		String[] parms = {tokenNo};
		return executeQuery(query,parms);		 
		
	}
	public List getTokenListByDate(String enrollDate) throws DaoException{
		String query = SqlQueryConstants.SEARCH_TOKEN_BY_DATE;
		System.out.println(query);
		String[] parms = {enrollDate};
		return executeQuery(query,parms);		 
		
	}
	
	public int enrollCard(String tokenNo,String empcode, String card_code) throws DaoException{
		String query = SqlQueryConstants.ENROLL_CARD;
		String[] parms = {  tokenNo,empcode,card_code};
		return executeUpdate(query,parms);		 
		
	}
}
