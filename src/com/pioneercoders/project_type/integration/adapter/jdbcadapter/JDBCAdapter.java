/**
 * 
 */
package com.bhaskar.project_type.integration.adapter.jdbcadapter;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.AjaxDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.BillDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.DAOInterface;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.PhtotGraphyDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.TokenDAO;


/** 
 * @author Ravi Shankar Birlangi
 * This is a single ton class
 */
public class JDBCAdapter {
	
	
	private static final JDBCAdapter adapter= new JDBCAdapter();
	private static final DAOFactory daofactory = DAOFactory.getDAOFactoryInstance();
	public static JDBCAdapter getJDBCAdapterInstance() {		
		return adapter;		
	}
	private JDBCAdapter(){
		
	}	
	
	
	
	
	public List getEnrollmentFlag(String empcode) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getEnrollmentFlag(empcode);
		
	}
	public List getPhotographyFlag(String empcode) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getPhotographyFlag(empcode);
		
	}
	
	
	public List getEmployeeTokenNo(String enrolldate) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getEmployeeTokenNo( enrolldate);
		
	}
	public List  getNonEmployeeTokenNo(String enrolldate)   throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getNonEmployeeTokenNo( enrolldate);
		
	}
	public int enrollForToken(String empcode,String genration_date,String tokenNo,String enrollment_type,String enrollment_date,String enrollment_time, String card_code) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.enrollForToken(empcode, genration_date, tokenNo, enrollment_type, enrollment_date, enrollment_time, card_code);
	}
	

	
	public List getEnrollmentCount(Date enrolldate,String enrollmenttype) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getEnrollmentCount(enrolldate,enrollmenttype);
	}
	public List getEnrollmentTimes(String enrolldate,String enrollmenttype)  throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getEnrollmentTimes(enrolldate,enrollmenttype);
	}
	public List getToken(String tokenNo) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getToken(tokenNo);
	}
	public List getTokenListByDate(String enrollDate) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getTokenListByDate(enrollDate);
	}
	public List getEmployeeName(String empcode) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(AjaxDAO.class.getName());
		AjaxDAO dao=(AjaxDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.getEmployeeName( empcode);
	}
	
	public int enrollCard(String tokenNo,String empcode, String card_code) throws DaoException{
		DAOInterface inter = daofactory.getDAOByKey(TokenDAO.class.getName());
		TokenDAO dao=(TokenDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.enrollCard(tokenNo, empcode, card_code);
	
	}
	
	public int RegisterPhotoGraphy(String photograpy_token_no ,String empcode ,String dob,String bloodgroup,String dept ,String designation ,String Phtograpy_date , String photograpy_tim ,String location) throws DaoException{
	    DAOInterface inter = daofactory.getDAOByKey(PhtotGraphyDAO.class.getName());
		PhtotGraphyDAO dao=(PhtotGraphyDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
		return dao.RegisterPhotoGraphy(photograpy_token_no, empcode,dob, bloodgroup, dept, designation, Phtograpy_date, photograpy_tim, location);
	}
	public List getRegisteredPhotographyList() throws DaoException{
		
		 DAOInterface inter = daofactory.getDAOByKey(PhtotGraphyDAO.class.getName());
			PhtotGraphyDAO dao=(PhtotGraphyDAO)inter;//daofactory.getDAOByKey(PaymentsDAO.class.getName());
			return dao.getRegisteredPhotographyList();
			
	}
	
    public List getBillType()throws DaoException{
		
    	DAOInterface inter=daofactory.getDAOByKey(BillDAO.class.getName());
    	 BillDAO dao=(BillDAO)inter;
    	 return dao.getBillType();
	 }
    
    public int addNewBill(String pBillNo,String pBillAmount,String pFromDate,String pToDate,String pPendingAmount,String pDueDate,String pBillTypeId) throws DaoException{
    	DAOInterface inter=daofactory.getDAOByKey(BillDAO.class.getName());
   	    BillDAO dao=(BillDAO)inter;
   	    return dao.addNewBill(pBillNo, pBillAmount, pFromDate, pToDate, pPendingAmount, pDueDate, pBillTypeId);
    }
    
    public List getAllBillsInfo() throws DaoException{
    	DAOInterface inter=daofactory.getDAOByKey(BillDAO.class.getName());
   	    BillDAO dao=(BillDAO)inter;
   	    return dao.getAllBillsInfo();
    }
	
	
}