package com.bhaskar.project_type.mediator;

import com.bhaskar.project_type.integration.adapter.jdbcadapter.DAOFactory;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.AjaxDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.DAOInterface;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.PhtotGraphyDAO;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.dao.TokenDAO;
import com.bhaskar.project_type.mediator.service.BillService;


public class ServiceFactory {
	
	private static final ServiceFactory servicefactory = new ServiceFactory();
	//private static  DAOFactory daofactory = null;
	
	
	public static ServiceFactory getDAOFactoryInstance() {		
		return servicefactory;		
	}
	public BillService getBillservice() {
		return billservice;
	}

	public void setBillservice(BillService billservice) {
		this.billservice = billservice;
	}

	{	
		
		this.setBillservice(new BillService());
	}
	
public ServiceInterface getServiceByKey(String key) {
		
	   ServiceInterface service = null;
		
		
		if(key.equals(BillService.class.getName())){
			service = this.getBillservice();
		}
	
		return service;		
	}	
	
	private BillService billservice;

}
