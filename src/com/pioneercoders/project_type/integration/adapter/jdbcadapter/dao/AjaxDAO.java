package com.bhaskar.project_type.integration.adapter.jdbcadapter.dao;

import java.util.List;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.DAO;

public class AjaxDAO  extends DAO implements DAOInterface { 
	
	public List getEmployeeName(String empcode) throws DaoException{
		String query = SqlQueryConstants.EMPLOYEENAME;
		System.out.println(query);
		String[] parms = {empcode};
		return executeQuery(query,parms);		 
		
	}

}
