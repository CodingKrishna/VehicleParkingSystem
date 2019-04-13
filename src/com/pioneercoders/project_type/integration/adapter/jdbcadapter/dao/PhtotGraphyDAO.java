package com.bhaskar.project_type.integration.adapter.jdbcadapter.dao;

import java.util.List;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.DAO;

public class PhtotGraphyDAO extends DAO implements DAOInterface{
	
	public int RegisterPhotoGraphy(String photograpy_token_no ,String empcode ,String dob,String bloodgroup,String dept ,String designation ,String Phtograpy_date , String photograpy_tim ,String location) throws DaoException{
		String query = SqlQueryConstants.PHOTOGRAPHY_REGISTER;
		String[] parms = { photograpy_token_no ,empcode ,dob, bloodgroup,dept , designation , Phtograpy_date ,  photograpy_tim , location};
		return executeUpdate(query,parms);		 
		
	}
	public List getRegisteredPhotographyList() throws DaoException{
		String query = SqlQueryConstants.PHOTOGRAPHY_LIST;
		return executeQuery(query);		 
		
	}

}
