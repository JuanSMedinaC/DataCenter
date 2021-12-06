package ui;
import java.util.Scanner;
import model.*;
/**
 * @author Juan Medina
 */
public class DataCenterMain 
{
	//Attributes
	private Scanner reader;
	/**
	 * Controller that will be used for creating all of the necessary objects in the model package.
	 */
	public DataCenter dataCenter;
	
	/**
	 * This method is the constructor of the main its necessary for creating an object of this type and starting the algorithm.
	 */
	public DataCenterMain() 
	{
		reader=new Scanner(System.in);
		dataCenter=new DataCenter("Enterprises Center");
	}
	
	/**
	 * This method is the main method were is supposed to happen the principal activities and the distribution of responsibilities.
	 * @param args  Its supposed to contain the execution of the menu for choosing activities and therefore the continuation of each one of them.
	 */
	public static void main(String[] args)
	{
		DataCenterMain dataMain= new DataCenterMain();
		int opt=0;
		
		do{
			opt=dataMain.menu();
			
			switch (opt) {
			case 1: dataMain.displayAvaliableMiniRooms();
			break;
			case 2: dataMain.rentMiniRoom();
			break;
			case 3: dataMain.cancelRent();
			break;
			case 4:dataMain.dataCenterMap();
			break;
			case 5: dataMain.turnAllOn();
			break;
			case 6: dataMain.turnOffByLetter();
			break;
			}
			
		}while(opt!=0);
	}	
	/**
	 * This method is in charge of displaying the different options that the user can choose and ask for an answer.
	 * @return opt this is the option chosen by the user as an int in this case.
	 */
	public int menu(){
		int opt=0;
		System.out.println("What do you want to do?");
		System.out.println(
				"1)Display all the avaliable MiniRooms\n"+
				"2)Rent MiniRoom"+
				"\n3)Cancel rent for one or all of the mini rooms"+
				"\n4)Show on and off map of the dataCenter"+
				"\n5)Simulate turning on all of the mini roomns"+
				"\n6)Turn off mini roomns by pressing a letter");
		opt=reader.nextInt();
		return opt;
	}
	
	/**
	 * This method is in charge of printing the different amount of avaliable mini rooms with their main categories.
	 */
	public void displayAvaliableMiniRooms() {
		System.out.println(dataCenter.displayAvaliableMiniRooms());
	}
	
	/**
	 * This method is in charge of asking for the data needed to start a rent and passes it to the data center.
	 */
	public void rentMiniRoom() {
		int roomNum=0;
		boolean roomAvaliable=true;
		int rentDay=0;
		int rentMonth=0;
		int rentYear=0;
		int serverAmount=0;
		
		System.out.println("Which room number would you like to rent?");
		roomNum=reader.nextInt();
		if (roomNum<1||roomNum>400) {
			System.out.println("Room not avaliable");
		}
		else {
			roomAvaliable=dataCenter.checkRoomAvaliability(roomNum);
			if(roomAvaliable==true) {
				
				do {
					System.out.println("What's the rent day?");
					rentDay=reader.nextInt();
					
				}while(rentDay<1||rentDay>31);
				
				do {
					System.out.println("What's the rent month?");
					rentMonth=reader.nextInt();
				}while(rentMonth<1||rentMonth>12);
				
				do {
					System.out.println("What's the rent Year?");
					rentYear=reader.nextInt();
				}while(rentYear<2020||rentYear>2025);
				
				System.out.println("How many servers do you want to add?");
				
				serverAmount=reader.nextInt();
				
				for (int i=0;i<serverAmount;i++) {
					int brand;
					System.out.println("What's the amount of cache memory you want to add for your server number "+i+"?");
					int cacheMemoryAmountGB = reader.nextInt();
					System.out.println("How many processors do you want to add for your server?");
					int processorNumber = reader.nextInt();
					System.out.println("What's the amount of discs you want to add to the server?");
					int discAmount = reader.nextInt();
					System.out.println("How many space in terabytes you want to set for the server disc?");
					int discCapacityTB=reader.nextInt();
					do {
						System.out.println("Which brand do you want for the server?"+
								"\n1)Intel"+
								"\n2)Amd");
					brand= reader.nextInt();
						
					}while(brand<1||brand>2);
					
					System.out.println(dataCenter.addServer(roomNum, cacheMemoryAmountGB, processorNumber, brand, discAmount, discCapacityTB));  
				}
				int project=0;
				String nit="";
				String name="";
				
				do {
					System.out.println("Will the rent be for a project?"+
						"\n1)Yes"+
						"\n2)No");
					project=reader.nextInt();
					
				}while(project<1||project>2);
				
				
				if (project==1) {
					nit="8903167455";
					name="Icesi";
					String regNum="";
					System.out.println("Add the registration number");
					regNum=reader.next();
					System.out.println(dataCenter.addRentData(roomNum, rentDay, rentMonth, rentYear, regNum));
				}
				else if(project==2) {
					System.out.println("What's the enterprise name?");
					reader.nextLine();
					name=reader.nextLine();
					System.out.println("Whats the enterprise nit?");
					nit=reader.next();
					System.out.println(dataCenter.addRentData(roomNum, rentDay, rentMonth, rentYear, ""));
					
				}
				System.out.println(dataCenter.addEnterprise(roomNum, name, nit));
				System.out.println(dataCenter.calculateRentValue(roomNum, serverAmount));
			}
			else {
				System.out.println("Room not avaliable");
			}
		}
		
	}
	
	/**
	 * This method is in charge of canceling the rent process for for just one mini room by typing its number or all of them.
	 */
	public void cancelRent() {
		int opt=0;
		int roomNum=0;
		
		do {
			System.out.println("Do you want to cancel rent for: "+
					"\n1)Just one of the mini roomns"+
					"\n2)All of the mini roomns");
			opt=reader.nextInt();
		}while(opt<1||opt>2);
		if (opt==1) {
			System.out.println("Which room number would you like to cancel rent?");
			roomNum=reader.nextInt();
			if (roomNum<1||roomNum>400) {
				System.out.println("Room not avaliable");
			}
			else {				
				System.out.println(dataCenter.cancelRent(roomNum));
			}
		}
		else if(opt==2) {
			System.out.println(dataCenter.cancelRent());
			
		}
		
	}
	/**
	 * This method is in charge of printing the complete mini room maps with the actual occupied rooms.
	 */
	public void dataCenterMap() {
		System.out.println(dataCenter.dataCenterMap());
	}
	
	/**
	 * This method is in charge of printing a simulation where all of the lights are turned on.
	 */
	public void turnAllOn() {
		System.out.println(dataCenter.turnAllOn());
	}
	/**
	 * This method is in charge of asking the user for a character and then displaying the map of how would the organization be after turning off some rooms.
	 */
	public void turnOffByLetter() {
		char letter=' ';
		int n=0;
		System.out.println("L: Shuts the first rooms on each corridor and the all of the first corridor.\r\n"
				+ "Z:Shuts down the minirooms of the first and last corridor, and the mini rooms of the inverse diagonal.\r\n"
				+ "H: Shuts down all of the minirooms with odd corridor number. \r\n"
				+ "O: Shuts down all of the mini rooms that have a window. \r\n"
				+ "M: Asks the user for a column and shuts down all of the miniroomns in that column\r\n"
				+ "P: Shuts down all of the minirooms of a corridor. \r\n"
				+ "");
		letter=reader.next().toUpperCase().charAt(0);
		
		if (letter!='L'&&letter!='Z'&&letter!='H'&&letter!='O'&&letter!='M'&&letter!='P'){
			System.out.println("Invalid character");
		}
		else if(letter=='L') {
			System.out.println(dataCenter.turnOffByLetter(letter, 0));
		}
		else if(letter=='Z') {
			System.out.println(dataCenter.turnOffByLetter(letter, 0));
		}
		else if(letter=='H') {
			System.out.println(dataCenter.turnOffByLetter(letter, 0));
		}
		else if(letter=='O') {
			System.out.println(dataCenter.turnOffByLetter(letter, 0));
		}
		else if(letter=='M') {
			System.out.println("Which column do you want to turn off? between 1-50");
			n=reader.nextInt();
			if(n>=1&&n<=50) {
				n=n-1;
				System.out.println(dataCenter.turnOffByLetter(letter, n));	
			}
			
		}
		else if(letter=='P') {
			System.out.println("Which Corridor do you want to turn off? between 1-8");
			n=reader.nextInt();
			if(n>=1&&n<=50) {
			n=n-1;
			System.out.println(dataCenter.turnOffByLetter(letter, n));	
			}
		}
	}
}

