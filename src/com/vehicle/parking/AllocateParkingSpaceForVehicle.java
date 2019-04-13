package com.vehicle.parking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.bhaskar.project_type.exception.DaoException;
import com.bhaskar.project_type.integration.adapter.jdbcadapter.DBConnection;

/**
 * This class is used for the Allocating Parking Space for the Vehicle
 * @author HariKrishn Yalamati.
 */
public class AllocateParkingSpaceForVehicle {
	
	/**
	 * This method is used for allocating the parking space for the vehicle. 
	 * After successful allocation of the parking space it will return the allocated parking space id.
	 * 	if any failure it will return -1, if wrong input it will return -2
	 * @param pVehicleNumber -
	 * 			vehicle id.
	 * @param pVehicleTypeId -
	 * 			vehicle type id indicates the type of the vehicle like 2 for 2 wheelers or 4 for 4 wheelers.
	 * @return - 
	 * 			allocated parking space id.
	 */
	public int allocateParkingSpace(String pVehicleNumber,int pVehicleTypeId){
		/*if(pVehicleNumber == null || pVehicleNumber.trim().isEmpty()){
			return -2;
		}*/
		Connection connection = null;
		CallableStatement callableStatement;
		int result = 0;
		int allocated_parking_space_id = -1;
		try {
			connection = DBConnection.getInstance().getConnection();
			//set the auto commit to false to commit occurs when the statement completes.		  
			connection.setAutoCommit(false);
			callableStatement = connection.prepareCall("call allocateParkingSpaceForVehicle(?,?,?)");
			callableStatement.setString(1, pVehicleNumber);
			callableStatement.setInt(2, pVehicleTypeId);
		    callableStatement.registerOutParameter("allocated_parking_space_id", java.sql.Types.VARCHAR);
		    result = callableStatement.executeUpdate();
		    allocated_parking_space_id = callableStatement.getInt("allocated_parking_space_id");
		    System.out.println("AllocatedParkingSpaceId ::"+allocated_parking_space_id);	
		    //On successfull allocation of the parking space for vehicle 
		    //it will return the Allocated Parking Space Id. else it will return 0.
		    if(result == 0){
		    	connection.rollback();
		    	allocated_parking_space_id = -1;		    	
		    }else{
		    	//commite transaction if no errors.
		    	connection.commit();
		    }
		} catch (SQLException e) {			
			e.printStackTrace();		
		} catch (DaoException e) {			
			e.printStackTrace();
		}	
		return allocated_parking_space_id;
	}
	
	/**
	 * This method is used to update the Vehicle out info and deallocation of the allocated parking space for this vehicle.
	 * After successfully updation it will return Transaction Id. 
	 * if any failure it will return -1, if wrong input it will return -2
	 * @param pVehicleNumber --
	 * 		Vehicle Number.
	 * @return --
	 * 		TransactionId for this parking. 
	 */
	public int  updateVehicleOutPunch(String pVehicleNumber){
		/*if(pVehicleNumber == null || pVehicleNumber.trim().isEmpty()){
			return -2;
		}*/
		Connection connection =null;
		CallableStatement callableStatement;
		int result = 0;
		int vehicle_transaction_id= -1;
		try {
			connection = DBConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			callableStatement = connection.prepareCall("call updateVehicleOutPunch(?,?)");
			callableStatement.setString(1, pVehicleNumber);			
		    callableStatement.registerOutParameter("vehicle_transaction_id", java.sql.Types.VARCHAR);
		    result = callableStatement.executeUpdate();
		    vehicle_transaction_id = callableStatement.getInt("vehicle_transaction_id");
		    System.out.println("Vehicle Transaction Id ::" + vehicle_transaction_id);	
		    //On successfull allocation of the parking space for vehicle 
		    //it will return the Allocated Parking Space Id. else it will return 0.
		    if(result == 0){		    	
		    	vehicle_transaction_id = -1;
		    	connection.rollback();
		    }else{
		    	connection.commit();
		    }
		} catch (SQLException e) {			
			e.printStackTrace();		
		} catch (DaoException e) {			
			e.printStackTrace();
		}	
		return vehicle_transaction_id;
	}	

	/**
	 * To test the application in stand alone mode.
	 * @param args--
	 * 			Command Line arguments if required.
	 */
	public static void main(String[] args) {
		AllocateParkingSpaceForVehicle allocateParkingSpace = new AllocateParkingSpaceForVehicle();
		//call for allocate for space returns allocated space id.
		int allocatedSpaceId = allocateParkingSpace.allocateParkingSpace("KA 12 HK 1212",2);
		if(allocatedSpaceId == -1){
			System.out.println("No Parking Space Available now.");
		}else if(allocatedSpaceId == -2){
				System.out.println("Please enter valid vehicle number.");
		}else{
		System.out.println("Allocated Parking Space Id:: "+allocatedSpaceId);
		}
		
		//call for updating Vehicle Out Punch, returns the transaction id.
		/*int vehicleTransactionId = allocateParkingSpace.updateVehicleOutPunch("KA 12 HK 1212");
		if(vehicleTransactionId == -1){
			System.out.println("No Vehicle Transaction Id found.");
		}else if(vehicleTransactionId == -2){
				System.out.println("Please enter valid vehicle number.");
		}else{
		System.out.println("Vehicle Transaction Id:: "+ vehicleTransactionId);
		}*/
	}

}
