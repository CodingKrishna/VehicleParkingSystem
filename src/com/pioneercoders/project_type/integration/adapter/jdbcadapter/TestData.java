package com.bhaskar.project_type.integration.adapter.jdbcadapter;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCAdapter adapter = JDBCAdapter.getJDBCAdapterInstance();
		try{
			System.out.println(new Date(1900+111,01,01).getDate());
			
      // int classes = adapter.updateCustomer("2", "3", "asfsadlfjsal", "aaaa", "sadfadsfads","00000");
      //    int classes = adapter.addExpenditureDetails("4","2010-03-08", "2000", "sdfsdfdsfds");
         // int classes = adapter.enrollForToken("1921843", "15-Dec-2011", "E-20-111", "NO_EMPLOYEE", "15-Dec-2011", "133052", "12345");
		    
			List classes = adapter.getEnrollmentCount(new Date(112,0,01),"NON_EMPLOYEE");
		//List classes = adapter.getEmployeeName("2120917333");
			System.out.println(new Date(1900+111,0,1));
             for(int i = 0; i < classes.size(); i ++)
	      {
		     HashMap hm = (HashMap)classes.get(i);
	         Set s =	hm.keySet();
	         Iterator it = s.iterator();
	         while(it.hasNext())
	         {
		         System.out.print(hm.get(it.next().toString())+"   ");
	         }
	         System.out.println("");
	     
	       }   
		}
		catch(Exception e)
		{
			 System.out.println(e.getMessage());
			System.out.println(e);
		}  

	}  
		
	/*	 final Logger logger = Logger.getLogger(TestData.class);
		 PropertyConfigurator.configure("log4j.properties");
		 logger.debug("Sample debug message");
			logger.info("Sample info message");
			logger.warn("Sample warn message");
			logger.error("Sample error message");
			logger.fatal("Sample fatal message");
	
	}  */
			
		
			
	
}
