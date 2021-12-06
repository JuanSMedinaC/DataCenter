package model;

public class DataCenter {

	//Attributes
	private String name;
	private MiniRoom[][] miniroom;
	public static final double RENT=800;

	/**
	 * Thjs method is in charge if generating an object of the type data center which will work as a controller.
	 * @param name the name of the datacenter.
	 */
	public DataCenter(String name) {
		this.name = name;
		miniroom=new MiniRoom[8][50];
		int number=1;
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
            	
            	if (miniroom[r][c]==null&&c==0){
            		
            		miniroom[r][c]=new MiniRoom(number,true,false);
            		number++;
            	}	
            	else if(miniroom[r][c]==null&&c==49){
            		miniroom[r][c]=new MiniRoom(number,true,false);
            		number++;
            	}
            	else if(miniroom[r][c]==null&&r==0){
            		
            		miniroom[r][c]=new MiniRoom(number,true,false);
            		number++;
            	}
            	else {
            		miniroom[r][c]=new MiniRoom(number,false,false);
            		number++;
            	}
            }
        }
	}
	/**
	 * Sends the information of the avaliable rooms, such as the address, price estimation.
	 * @return The information of all of the rooms.
	 */
	public String displayAvaliableMiniRooms() {
		String msg="";
		double rentVal=0;
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
            	
            	if (miniroom[r][c].getRented()!=true)
            	{
            		msg+="\n";
                	msg+="\n"+miniroom[r][c].toString();
                	msg+="\nThe miniroom is in the "+ c + " column";
                	msg+="\nThe miniroom rent value is: ";
                	if(miniroom[r][c].isWindow()==true){
                		rentVal=RENT-(RENT*0.10);
                	}
                	else if(r==6) {
                		rentVal=RENT-(RENT*0.15);
                	}
                	else if(r>=1&&r<=5) {
                		rentVal=RENT*1.25;
                	}
                	msg+="$"+rentVal;
                	msg+="\nIf you use less than 4 servers the rent value would be: ";
                	rentVal+=RENT*0.15;
                	msg+="$"+rentVal;
            	}
            	
            }
            
		}
		if (msg.equalsIgnoreCase("")) {
			msg="No avaliable rooms";
		}
		return msg;
	}
	/**
	 * Receives as a parameter a room number and checks if its already rented. 
	 * @param roomNum The number of the miniroom which will be compared with the whole matrix of mini rooms.
	 * @return a boolean that defines if the room is avaliable or not.
	 */
	public boolean checkRoomAvaliability(int roomNum) {
		boolean avaliable=true;
		for (int r=0; r<miniroom.length;r++){
					
            for(int c=0;c<miniroom[0].length;c++){
		            	
            	if (miniroom[r][c].getNumber()==roomNum) {
            		if (miniroom[r][c].getRented()==true) {
		            			avaliable=false;
            		}
            	}
            }
		}
		return avaliable;
	}
	/**
	 * Method in charge of creating a server for the miniRoom rack, by receiving all of its data as parameter
	 * @param roomNum the number of the room that will contain the servers
	 * @param cacheMemoryAmountGB The memory cache amount of the server
	 * @param processorNumber The number of processors that the server will have
	 * @param brand The brand of the server.
	 * @param discAmount The amount of discs that the server can have.
	 * @param discCapacityTB The capacity of each one of the discs.
	 * @return A message confirming the work could be don.
	 */
	public String addServer(int roomNum, int cacheMemoryAmountGB, int processorNumber, int brand, int discAmount, int discCapacityTB) {
		String msg="";
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
		            	
            	if (miniroom[r][c].getNumber()==roomNum) {
            		msg=miniroom[r][c].addServer(cacheMemoryAmountGB, processorNumber, brand, discAmount, discCapacityTB);
            	}
            }
		}
		return msg;
	}
	/**
	 * Method in charge of creating an enterprise for the miniRoom , by receiving all of its data as parameter
	 * @param roomNum the number of the room that will be rented.
	 * @param name The name of the enterprise that will rent.
	 * @param nit The nit of the enterprise that they'll add.
	 * @return A Message confirming the object could be added succesfully.
	 */
	public String addEnterprise(int roomNum, String name, String nit) {
		String msg="";
		for (int r=0; r<miniroom.length;r++){
					
            for(int c=0;c<miniroom[0].length;c++){
				            	
            	if (miniroom[r][c].getNumber()==roomNum) {
            		msg=miniroom[r][c].addEnterprise(name, nit);
            		miniroom[r][c].setOn(true);
            	}
            }
            
		}            
		return msg;
	}
	/**
	 * This mehtod is in charge of saving as an object the most important data of facturation.
	 * @param roomNum the number of the room that will contain the rent data.
	 * @param rentDay The day that the rent is programmed for.
	 * @param rentMonth The month that the rent is programmed for.
	 * @param rentYear The year that the rent is programmed for.
	 * @param regNum The registration number, that  is only necessary for projects.
	 * @return
	 */
	public String addRentData(int roomNum, int rentDay, int rentMonth, int rentYear, String regNum) {
		String msg="";
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
				            	
            	if (miniroom[r][c].getNumber()==roomNum) {
            		miniroom[r][c].addRentData(rentDay, rentMonth, rentYear, regNum);
            	}
            }
		}
		return msg;
	}
	/**
	 * Returns the value to be paid monthly for the room.
	 * @param roomNum roomNum the number of the room that will contain the rent data.
	 * @param servAmount The amount of server that can vary the price of the room.
	 * @return
	 */
	public String calculateRentValue(int roomNum, int servAmount)
	{
		String msg="";
		msg="The rent value is: ";
		double rentVal=0;
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
            	if (miniroom[r][c].getNumber()==roomNum) {	            		
	            	
		            	if(miniroom[r][c].isWindow()==true)
		            	{
	                		rentVal=RENT-(RENT*0.10);
	                	}
		            	else if(r==6) {
		            		rentVal=RENT-(RENT*0.15);
		            	}
		            	else if(r>=1&&r<=5) {
		            		rentVal+=RENT*1.25;
		            	}
		            	else {
		            		rentVal=RENT;
		            	}
		            	if(servAmount<4) {
		            		rentVal+=RENT*0.15;
		            		msg+="$"+rentVal;
	            	}
            	}
            }
		}
		return msg;
	}
	/**
	 * This method is in charge of calling the one on the mini room object for each of the rented objects, that will eventually delete all of the rent information and will leave the mini room free.
	 * @return a message with the succesful cancelation of the minirooms.
	 */
	public String cancelRent() {
		String msg="";
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
            	if(miniroom[r][c].getRented()==true) {
            		msg+=miniroom[r][c].getRackInfo();
            		msg+="\n"+miniroom[r][c].cancelRent();
            	}           	
            }
		}
		return msg;
	}
	/**
	 * This method is in charge of canceling rent for a determinate mini room.
	 * @param roomNum the number of the room that is going to be canceled for rent.
	 * @return a message with the succesful cancelation of the minirooms rent.
	 */
	public String cancelRent(int roomNum) {
		String msg="";
		for (int r=0; r<miniroom.length;r++){
			
            for(int c=0;c<miniroom[0].length;c++){
            	if (miniroom[r][c].getNumber()==roomNum&&miniroom[r][c].getRented()==true) {
            		msg+=miniroom[r][c].getRackInfo();
            		msg+="\n"+miniroom[r][c].cancelRent();
            	}
            	else if(miniroom[r][c].getNumber()==roomNum&&miniroom[r][c].getRented()==false){
            		msg="Mini room already avaliabe for rent";
            	}
            }
		}
		return msg;
	}
	/**
	 * This method is in charge of printing the complete mini room maps with the actual occupied rooms.
	 * @return An String with the complete map.
	 */
	public String dataCenterMap() {
		String msg="";	
		for (int r=0; r<miniroom.length;r++){
			msg+="\n";
			for(int c=0;c<miniroom[0].length;c++){
				if(miniroom[r][c].getRented()==false) {
					miniroom[r][c].setOn(false);
					msg+="Of -";
				}
				if(miniroom[r][c].getRented()==true) {
					msg+="ON -";
				}
				if(c==49) {
					msg+="|";
				}
			}
		}
		return msg;
	}
	/**
	 * This method is in charge of recreating a total turn of lights in the map.
	 * @return A message with the map distribution.
	 */
	public String turnAllOn() {
		String msg="";	
		for (int r=0; r<miniroom.length;r++){
			msg+="\n";
			for(int c=0;c<miniroom[0].length;c++){
				msg+="ON -";
				if(c==49) {
					msg+="|";
				}
			}
		}
		return msg;
	}
	/**
	 * This method is in charge of asking the user for a character and then displaying the map of how would the organization be after turning off some rooms.
	 * @param letter the selection of the user.
	 * @param column the possible seconde selection of the user, only used for some sports.
	 * @return The new map with all of the updated light statuses.
	 */
	public String turnOffByLetter(char letter, int Column) {
		String msg="";
		if(letter=='L') {
			for (int r=0; r<miniroom.length;r++){
				msg+="\n";
				for(int c=0;c<miniroom[0].length;c++){
					if(c==0) {
						msg+="Of-";
					}
					else if(r==0) {
						msg+="Of -";
					}
					else {
						msg+="On -";
					}
					if(c==49) {
						msg+="|";
					}
				}
			}
		
		}
		else if(letter=='Z') {
			int number=1;
			for (int r=0; r<miniroom.length;r++){
				msg+="\n";
				for(int c=0;c<miniroom[0].length;c++){
					if(miniroom[r][c].getNumber()==number) {
						msg+="Of-";
						number+=51;
					}
					else if(r==0) {
						msg+="Of-";
					}
					else if(r==7) {
						msg+="Of-";
					}
					else {
						msg+="ON-";
					}
					
				}
			}
			
		}
		else if(letter=='H') {
			for (int r=0; r<miniroom.length;r++){
				msg+="\n";
				for(int c=0;c<miniroom[0].length;c++){
					if(r%2==0) {
						msg+="Of-";
					}
					else {
						msg+="ON-";
					}
				}
			}
		}
		else if(letter=='O') {
			for (int r=0; r<miniroom.length;r++){
				msg+="\n";
				for(int c=0;c<miniroom[0].length;c++){
					if(miniroom[r][c].isWindow()==true) {
						msg+="Of-";
					}
					else {
						msg+="ON-";
					}
				}
			}
		}
		else if(letter=='M') {
			for (int r=0; r<miniroom.length;r++){
				msg+="\n";
				for(int c=0;c<miniroom[0].length;c++){
					if(c==Column) {
						msg+="Of-";
					}
					else {
						msg+="ON-";
					}
				}
			}
		}
		else if(letter=='P') {
			for (int r=0; r<miniroom.length;r++){
				msg+="\n";
				for(int c=0;c<miniroom[0].length;c++){
					if(r==Column) {
						msg+="Of-";
					}
					else {
						msg+="ON-";
					}
				}
			}
		}
		
		return msg;		
	}
}
