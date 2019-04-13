package com.bhaskar.project_type.utility;

import java.io.IOException;



public class ReadPropertiesFile {
    static String filePath="";
    static java.util.Properties p;
    static {
    	filePath="";
    	p = new java.util.Properties();
    	//p.load(new java.io.FileInputStream(new File(filepath)));
    	ClassLoader loader = ReadPropertiesFile.class.getClassLoader();
    	try {
			p.load(loader.getResourceAsStream("com/bhaskar/project_type/resources/MessageResources.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	public static String getProperty(String key)
	{
		// Modify this after implementing the actual properties reading from file
		if (key.equalsIgnoreCase("db_url"))
				
  		  return p.getProperty("db_url");
		else if (key.equalsIgnoreCase("driverName"))
			return p.getProperty("driverName");
		else if (key.equalsIgnoreCase("db_user"))
			return p.getProperty("db_user");
		else if (key.equalsIgnoreCase("db_password"))
			return p.getProperty("db_password");
	
		return null;
	}
	
	/**
	 * Searches for the property with the specified key in this property file. 
	 * If the key is not found in this property list, the default property list, and its defaults, recursively, are then checked. 
	 * The method returns null if the property is not found. 
	 * @param pKey -
	 *          key in the  property file. 
	 * @return -
	 * 			corresponding value to the key.
	 */
	public static String getSearchProperty(String pFileName, String pKey){
		ClassLoader loader = ReadPropertiesFile.class.getClassLoader();
		try {
			p.load(loader.getResourceAsStream(pFileName));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return p.getProperty(pKey);
	}
	
}
