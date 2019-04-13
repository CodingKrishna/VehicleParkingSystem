package com.bhaskar.project_type.utility;

public class ResourceBundle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.ResourceBundle rs = java.util.ResourceBundle.getBundle("/com/bhaskar/project_type/resources/MessageResources.properties");
		System.out.println(rs.getString("driverName"));
	}

}
