package com.bhaskar.project_type.mediator.service;

import java.util.ArrayList;
import java.util.List;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.exception.ServiceException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.JDBCAdapter;
import com.bhaskar.project_type.mediator.ServiceInterface;

public class BillService implements ServiceInterface{
	
	public List genrateBillType()throws ServiceException{
		JDBCAdapter adapter=JDBCAdapter.getJDBCAdapterInstance();
		List billList=new ArrayList();
		
		try {
			  billList=adapter.getBillType();
			 
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e);
		}
		
		
		return billList;
	}
   public int generateNewBill(String pBillNo,String pBillAmount,String pFromDate,String pToDate,String pPendingAmount,String pDueDate,String pBillTypeId)throws ServiceException{
	   
	   JDBCAdapter adapter=JDBCAdapter.getJDBCAdapterInstance();
	   int count;
	         try {
				   count=adapter.addNewBill(pBillNo, pBillAmount, pFromDate, pToDate, pPendingAmount, pDueDate, pBillTypeId);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				throw new ServiceException(e.getMessage(),e);
			}
	      return count;
	   
   }
   
   public List generateAllBillsInfo()throws ServiceException{
	   
	   JDBCAdapter adapter=JDBCAdapter.getJDBCAdapterInstance();
		List billsList=new ArrayList();
		try {
			billsList=adapter.getAllBillsInfo();
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(),e);
		}
		return billsList;
	   
   }
	
	/*public static void main(String k[]){
		BillService bs=new BillService();
	    try {
			List l=bs.genrateBillType();
			System.out.println(l);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}
