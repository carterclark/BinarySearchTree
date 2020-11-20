/**
 * This class represents a single item picked from a menu
 * 
 * @author Carter Clark
 */

import java.text.NumberFormat;

public class MenuItem implements Comparable<MenuItem>{
	
	//instance variables
	private String name;
	private double price;
	private int quantity;
	
	//static object for formatting output
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
	//constructors
	MenuItem(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	MenuItem(String name){
		this.name = name;
		this.price = 0;
		this.quantity = 0;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * determines the equality of two MenuItems by entering the name of one
	 * 
	 * @param name - name of other MenuItem
	 * 
	 * @return 	TRUE if the MenuItems have the same name
	 * 			FALSE if MenuItems do not have the same name
	 */
	@Override
	public boolean equals(Object other) {
		boolean equal = false;
		
		if(other instanceof MenuItem) {
			if(((MenuItem) other).getName().equalsIgnoreCase(this.getName())) {
				equal = true;
			}
		}
		
		return equal;
	}
	
	/**
	 * Converts the properties of MenuItem into a formatted string
	 * 
	 * @return Formatted string
	 */
	@Override
	public String toString(){
		
		String str = (addSpaces(this.name)			
					+ formatter.format(this.price) + "\t  "
					+ this.quantity + "\t"
					+ formatter.format(this.quantity * this.price))
					+ "\n";
		
		return str;
	}
	
	/**
	 * Method for formatting the toString() method
	 * 
	 * @param str - a string value, which will be the name of a MenuItem
	 * @return the inputed string with the correct spacing after it
	 */
	private String addSpaces(String str) {
		
		int len = 16 - str.length();
		
		for(int i=0; i<len; i++) {
			str += " ";
		}
		
		return str;
	}
	
	/**
	 * compares one MenuItem to a different MenuItem
	 * 
	 * @param other - the other TechJob to compare
	 * 
	 * @return 	an number less than 0		if the other TechJob has a higher precedence
	 * 			0 							if the TechJobs have equal precedence
	 * 			an number greater than 0	if the other TechJob has lower precedence
	 */
	@Override
	public int compareTo(MenuItem other) {
		return this.getName().compareToIgnoreCase(other.getName());
	}

}
