package com.bhaskar.project_type.integration.adapter.jdbcadapter.dao;

import java.util.List;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.DAO;

public class BillDAO extends DAO implements DAOInterface{
	
	public List getBillType()throws DaoException{
		
		String query=SqlQueryConstants.BILL_TYPES;
		
		return executeQuery(query);
	}
	
	public int addNewBill(String pBillNo,String pBillAmount,String pFromDate,String pToDate,String pPendingAmount,String pDueDate,String pBillTypeId) throws DaoException{
		String query=SqlQueryConstants.ADD_BILL;
		String[] params={pBillNo,pBillAmount,pFromDate,pToDate,pPendingAmount,pDueDate,pBillTypeId};
		return executeUpdate(query,params);
	}
	
	public List getAllBillsInfo() throws DaoException{
		String query=SqlQueryConstants.BILLS_LIST;
		return executeQuery(query);
	}
	
	
	

}
