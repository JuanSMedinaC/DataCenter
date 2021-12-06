package model;

public class RentData {
	//Attributes
	private int rentDay;
	private int rentMonth;
	private int rentYear;
	private String regNum;
	/**
	 * This method is in charge of saving as an object the most important data of facturation.
	 * @param rentDay The day that the rent is programmed for.
	 * @param rentMonth The month that the rent is programmed for.
	 * @param rentYear The year that the rent is programmed for.
	 * @param regNum The registration number, that  is only necessary for projects.
	 */
	public RentData(int rentDay, int rentMonth, int rentYear, String regNum) {
		super();
		this.rentDay = rentDay;
		this.rentMonth = rentMonth;
		this.rentYear = rentYear;
		this.regNum = regNum;
	}
	
	
	
	
}
