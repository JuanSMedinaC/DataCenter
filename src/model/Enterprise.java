package model;

public class Enterprise 
{

	//Attributes
	private String nit;
	private String name;
	
	public Enterprise(String nit, String name)
	{
		super();
		this.nit = nit;
		this.name = name;
	}

	/**
	 * @return the nit of the object.
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * Replaces the nit with a new one sent as a parameter.
	 * @param nit that will be used as a replacement.
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return the name of the object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Replaces the name with a new one sent as a parameter.
	 * @param name that will be used as a replacement.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
