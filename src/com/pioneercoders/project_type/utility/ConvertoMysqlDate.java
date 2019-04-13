package com.bhaskar.project_type.utility;

public class ConvertoMysqlDate {
	
	public static String ConverDate(String converdate)
	{
		String[] x =  converdate.split("/");
      	 String date = "";
      	for( int i =  x.length - 1; i >=0 ; i --)
	   {
		   System.out.println(x[i]);
		   if( i !=0 )
		   {
			  date = date+ x[i]+"-";
		   }
		   if( i == 0)
		   {
			  date = date + x[i];
		   }
	   }
      	return date;
	}

}
