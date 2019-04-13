/**
 * @author Ravi S Birlangi
 */
package com.bhaskar.project_type.integration.adapter.jdbcadapter;


import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.AjaxDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.BillDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.DAOInterface;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.PhtotGraphyDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.TokenDAO;





public class DAOFactory {
	
	private static final DAOFactory daofactory = new DAOFactory();
	//private static  DAOFactory daofactory = null;
	
	
	public static DAOFactory getDAOFactoryInstance() {		
		return daofactory;		
	}

	{
		
		this.setTokendao(new TokenDAO());
		this.setAjaxdao(new AjaxDAO());
		this.setPhotographydao(new PhtotGraphyDAO());
		this.setBilldao(new BillDAO());
	}
	
	//return the DAO object based on the class name passed
	public DAOInterface getDAOByKey(String key) {
		
		DAOInterface dao = null;
		
		if(key.equals(TokenDAO.class.getName())){
			dao = this.getTokendao();
		}
		if(key.equals(AjaxDAO.class.getName())){
			dao = this.getAjaxdao();
		}
		if(key.equals(PhtotGraphyDAO.class.getName())){
			dao = this.getPhotographydao();
		}
		if(key.equals(BillDAO.class.getName())){
			dao = this.getBilldao();
		}
		
		return dao;		
	}

	
	private TokenDAO tokendao;
	private AjaxDAO ajaxdao;
	private PhtotGraphyDAO photographydao;
	private BillDAO billdao;
	
	public BillDAO getBilldao() {
		return billdao;
	}
	public void setBilldao(BillDAO billdao) {
		this.billdao = billdao;
	}
	public TokenDAO getTokendao() {
		return tokendao;
	}
	public void setTokendao(TokenDAO tokendao) {
		this.tokendao = tokendao;
	}
	public void setAjaxdao(AjaxDAO ajaxdao) {
		this.ajaxdao = ajaxdao;
	}
	public AjaxDAO getAjaxdao() {
		return ajaxdao;
	}
	public void setPhotographydao(PhtotGraphyDAO photographydao) {
		this.photographydao = photographydao;
	}
	public PhtotGraphyDAO getPhotographydao() {
		return photographydao;
	}
	

	

}