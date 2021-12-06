package model;

public class Server
{
	//Attributes
	private int cacheMemoryAmountGB;
	private int processorNumber;
	private Brand brand;
	private int discAmount;
	private int discCapacityTB;
	
	

	public Server(int cacheMemoryAmountGB, int processorNumber, int brand, int discAmount, int discCapacityTB) 
	{
		this.cacheMemoryAmountGB = cacheMemoryAmountGB;
		this.processorNumber = processorNumber;
		this.discAmount = discAmount;
		this.discCapacityTB = discCapacityTB;
		switch (brand) {
		case 1: this.brand=Brand.INTEL;
		break;
		case 2: this.brand=Brand.AMD;
		break;
		}
	}

	/**
	 * @return the cacheMemoryAmountGB of the object.
	 */
	public int getCacheMemoryAmountGB() {
		return cacheMemoryAmountGB;
	}

	/**
	 * Replaces the cacheMemoryAmountGB with a new one sent as a parameter.
	 * @param cacheMemoryAmountGB that will be used as a replacement.
	 */
	public void setCacheMemoryAmountGB(int cacheMemoryAmountGB) {
		this.cacheMemoryAmountGB = cacheMemoryAmountGB;
	}

	/**
	 * @return the processorNumber of the object.
	 */
	public int getProcessorNumber() {
		return processorNumber;
	}

	/**
	 * Replaces the processorNumber with a new one sent as a parameter.
	 * @param processorNumber that will be used as a replacement.
	 */
	public void setProcessorNumber(int processorNumber) {
		this.processorNumber = processorNumber;
	}

	/**
	 * @return the brand of the object.
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * Replaces the brand with a new one sent as a parameter.
	 * @param brand that will be used as a replacement.
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the discAmount of the object.
	 */
	public int getDiscAmount() {
		return discAmount;
	}

	/**
	 * Replaces the discAmount with a new one sent as a parameter.
	 * @param discAmount that will be used as a replacement.
	 */
	public void setDiscAmount(int discAmount) {
		this.discAmount = discAmount;
	}

	/**
	 * @return the discCapacityTB of the object.
	 */
	public int getDiscCapacityTB() {
		return discCapacityTB;
	}

	/**
	 * Replaces the discCapacityTB with a new one sent as a parameter.
	 * @param discCapacityTB that will be used as a replacement.
	 */
	public void setDiscCapacityTB(int discCapacityTB) {
		this.discCapacityTB = discCapacityTB;
	}
	
	

}
