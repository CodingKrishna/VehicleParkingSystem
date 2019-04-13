package com.vehicle.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.vehicle.parking.AllocateParkingSpaceForVehicle;

public class VehicleInfoScreen {
	JFrame frame = null;
	JPanel panel = null;
	GridLayout geidLayout = null;
	JTextField vehicleNumberField = null;
	JTextField vehicleTypeField = null;
	JLabel vehicleNumberLable = null;
	JLabel vehicleTypeLable = null;
	JButton okButton = null;
	JButton cancelButton = null;
	
	JLabel screenTitle = null;
	
	public VehicleInfoScreen(){
		frame = new JFrame("Vehicle Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		 
		geidLayout = new GridLayout(5,2,20,60);
		panel = new JPanel(geidLayout);	
		screenTitle = new JLabel("Enter Vehicle Information");
		screenTitle.setHorizontalAlignment(JLabel.CENTER);
		screenTitle.setVerticalAlignment(JLabel.CENTER);
		//panel.add(screenTitle);
	}
	void captureVehicleInfo(){
		vehicleNumberLable = new JLabel("Enter Vehicle Number");
		vehicleNumberField = new JTextField(1);
		vehicleTypeLable = new JLabel("Enter Vehicle Type Id");
		vehicleTypeField = new JTextField(2);
		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");
		panel.add(vehicleNumberLable);
		panel.add(vehicleNumberField);
		panel.add(vehicleTypeLable);
		panel.add(vehicleTypeField);		   
		panel.add(okButton);
		panel.add(cancelButton);
		
		okButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent evt) {
			   String vehicleNumber = vehicleNumberField.getText(); 
			   int vehicleTypeId = Integer.parseInt(vehicleTypeField.getText());
			   System.out.println("VehicleNumber::"+vehicleNumber+"  VehicleTypeId::"+vehicleTypeId);
			   insertVehicleInfo(vehicleNumber, vehicleTypeId);			   	
			   }
			   });
		
		cancelButton.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent evt) {
			   vehicleNumberField.setText(""); 
			   vehicleTypeField.setText("");			  
			   }
			   });
			 
	}
	
	void displayPanal(){
		 frame.add(panel);
		 frame.setSize(400,400);
		 frame.setVisible(true);	
	}
	
	
	void insertVehicleInfo(String vehicleNumber,int vehicleTypeId){
		AllocateParkingSpaceForVehicle allocateParkingSpace = new AllocateParkingSpaceForVehicle();
		   int allocatedSpaceId = allocateParkingSpace.allocateParkingSpace(vehicleNumber,vehicleTypeId);
		   if(allocatedSpaceId != 0){
			   vehicleNumberField.setText(""); 
			   vehicleTypeField.setText("");
		   }
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VehicleInfoScreen vinfo  = new VehicleInfoScreen();
		vinfo.captureVehicleInfo();
		vinfo.displayPanal();
		  	 

	}

}
