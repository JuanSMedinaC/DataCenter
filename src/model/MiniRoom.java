package model;

import java.util.ArrayList;

public class MiniRoom 
{
	//Attributes
	private int number;
	private boolean window;
	private boolean on;
	private ArrayList<Server> rack;
	private Enterprise enterprise;
	private RentData rentData;
	
	public MiniRoom(int number, boolean window, boolean on){
		this.number = number;
		this.window= window;
		this.on=on;		
		rack=new ArrayList<Server>();
	}

	/**
	 * @return the number of the room.
	 */
	public int getNumber(){
		return number;
	}
	/**
	 * Sets the number of the room for a new one.
	 * @param number The new number sent as a paramter.
	 */
	public void setNumber(int number){
		this.number = number;
	}
	/**
	 * @return the boolean that confirms if its on a window or no.
	 */
	public boolean isWindow() {
		return window;
	}
	/**
	 * Sets the room window status for a new one..
	 * @param window The boolean that verifies if the room's on a window.
	 */
	public void setWindow(boolean window) {
		this.window = window;
	}
	/**
	 * The boolean for checking if there's any room on.
	 * @return a boolean with the on/off status. 
 	*/
	public boolean isOn() {
		return on;
	}
	/**
	 * Changes the on status for an off status or in the other way.
	 * @param on A boolean with on/off status, representas as true/false.
	 */
	public void setOn(boolean on) {
		this.on = on;
	}
	/**
	 * This method confirms if the mini room is being rented by verifying the enterprise.
	 * @return a Boolean with the confirmation of the rent status.
	 */
	public boolean getRented(){
		
		boolean rented=false;
		
		if(enterprise==null){
			rented=false;		
		}
		
		else if(enterprise!=null) {
			rented=true;
		}
		return rented;
	}
	/**
	 * Method in charge of creating a server for the miniRoom rack, by receiving all of its data as parameter
	 * @param cacheMemoryAmountGB The memory cache amount of the server
	 * @param processorNumber The number of processors that the server will have
	 * @param brand The brand of the server.
	 * @param discAmount The amount of discs that the server can have.
	 * @param discCapacityTB The capacity of each one of the discs.
	 * @return A message confirming the work could be don.
	 */
	public String addServer(int cacheMemoryAmountGB, int processorNumber, int brand, int discAmount, int discCapacityTB) {
		String msg="";
		Server objSever=new Server(cacheMemoryAmountGB, processorNumber, brand, discAmount, discCapacityTB);
		rack.add(objSever);
		msg="Server added succesfully";
		return msg;
	}
	/**
	 * Method in charge of creating an enterprise for the miniRoom , by receiving all of its data as parameter
	 * @param name The name of the enterprise that will rent.
	 * @param nit The nit of the enterprise that they'll add.
	 * @return A Message confirming the object could be added succesfully.
	 */
	public String addEnterprise(String name, String nit) {
		String msg="";
		enterprise=new Enterprise(nit, name);
		msg="Enterprise added correctly";
		return msg;
	}
	/**
	 * This method is in charge of saving as an object the most important data of facturation.
	 * @param rentDay The day that the rent is programmed for.
	 * @param rentMonth The month that the rent is programmed for.
	 * @param rentYear The year that the rent is programmed for.
	 * @param regNum The registration number, that  is only necessary for projects.
	 * @return
	 */
	public String addRentData(int rentDay, int rentMonth, int rentYear, String regNum) {
		String msg="";
		rentData=new RentData(rentDay, rentMonth, rentYear, regNum);
		msg="Rent data added succesfully";
		return msg;
	}
	/**
	 * This method is in charge of calling the one on the mini room object for each of the rented objects, that will eventually delete all of the rent information and will leave the mini room free.
	 * @return a message with the successful cancellation of the minirooms.
	 */
	public String cancelRent() {
		rack.clear();
		enterprise=null;
		rentData=null;
		on=false;
		
		return "Rent cancelled succesfully";
	}
	/**
	 * Returns the information of the sum of the disc memory the server had and the ram memory.
	 * @return the information of the sum of the disc memory the server had and the ram memory.
	 */
	public String getRackInfo() {
		String msg="";
		int totalDiscCapacity=0;
		int totalRam=0;
		
		for (int i=0;i<rack.size();i++) {
			
			totalDiscCapacity+=rack.get(i).getDiscAmount()*rack.get(i).getDiscCapacityTB();
			
			totalRam+=rack.get(i).getCacheMemoryAmountGB();
		}
		msg="The Disc capacity of the mini room was: "+ totalDiscCapacity+"Tb, and the total ram was: "+totalRam;
		return msg;
	}
	
	/**
	 * The toString method used for showing the most important data of the mini room.
	 */
	public String toString()
	{
		String msg="";
		msg="The miniroom number is "+number;
		if (window==true) {
			msg+="\nThe miniroom has a window view";
		}
		else if(window==false) {
			msg+="\nThe miniroom does not have a window view";
		}
		
		return msg; 
	}
	
	
}
