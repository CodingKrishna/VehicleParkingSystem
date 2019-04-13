package com.bhaskar.project_type.utility;

public  class  FormateTime {
	
	public static String formatetimehhmmss(String time,int count)
	{
		
		   int HH =Integer.parseInt(time.substring(0,2));
		   int MM =Integer.parseInt(time.substring(2,4));
		   int SS =Integer.parseInt(time.substring(4,6));
		   String enrollment_time = null;
		 		 
		   
		   MM = MM+count*5;
		   
		   if(MM >= 60){
		   
			   	if(MM == 60){
			   
			   			HH = HH+1;
			   			MM = 0;
			   		}
			   	else {
			   		HH = HH+1;
			   		MM = MM%60;
			   	}
		   }
		   String MM1 = null;
		   String HH1 = null;
		   String SS1 = null;
		   
		   if(Integer.toString(MM).length() == 1)
		   {
			   MM1 = "0"+MM;
		   }
		   else
		   {
			   MM1 = Integer.toString(MM) ;
		   }
		   if(Integer.toString(HH).length() == 1)
		   {
			   HH1 = "0"+HH;
		   }
		   else {
			   HH1 = Integer.toString(HH) ;
		   }
		   
		   if(Integer.toString(SS).length() == 1)
		   {
			   SS1 = "0"+SS;
		   }
		   else {
			   SS1 = Integer.toString(SS) ;
		   }
		   
		   enrollment_time = HH1+":"+MM1+":"+SS1;
		   
		   return enrollment_time ;
		
	}

}
