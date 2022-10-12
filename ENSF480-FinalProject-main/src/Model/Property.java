/**Property.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package Model;

import java.sql.Date;
import java.time.LocalDate;

import Controller.DbConnector;

public class Property {

    private String houseType;
    private int numBed;
    private int numBath;
    private boolean furnished;
    private String cityQuadrant;
    private String address;
    private String landlordEmail;
    private String state;
    private int period;
    private int id;
    private Date startDate;
    private Date endDate;
    private LocalDate sDate;
    private LocalDate eDate;

    /**
     * Constructor method for the Property class
     * @param houseType String parameter representing the type of property
     * @param numBed int parameter representing the # of bedrooms
     * @param numBath int parameter representing the # of bathrooms
     * @param furnished boolean parameter representing wether the house is furnished or not
     * @param cityQuadrant String parameter representing the quadrant of the city in which the house is located
     * @param address String parameter representing the address of the property
     * @param landlordEmail String parameter representing the email address of the landlord 
     * @param state String parameter representing the state of the property
     * @param period int parameter representing the fee period on the property
     * @param id int parameter representing the id of the house in the property table
     */
    public Property(String houseType, int numBed, int numBath, boolean furnished, String cityQuadrant, String address, String landlordEmail, String state, int period, int id){
        this.setHouseType(houseType);
        this.setNumBed(numBed);
        this.setNumBath(numBath);
        this.setFurnished(furnished);
        this.setQuadrant(cityQuadrant);
        this.setAddress(address);
        this.landlordEmail = landlordEmail;
        this.state = state;
        this.period = period;
        this.id = id;
    }

    public Property(String houseType, int numBed, int numBath, boolean furnished, String cityQuadrant, String address, String landlordEmail, String state, int id){
        this.setHouseType(houseType);
        this.setNumBed(numBed);
        this.setNumBath(numBath);
        this.setFurnished(furnished);
        this.setQuadrant(cityQuadrant);
        this.setAddress(address);
        this.landlordEmail = landlordEmail;
        this.state = state;
        this.id = id;
    }

    /**
     * Getter method for the house type
     * @return returns a string representing the house tuype
     */
    public String getHouseType(){
        return houseType;
    }

    /**
     * Setter method for the house type
     * @param houseType String parameter representing the type the house will be set to 
     */
    public void setHouseType(String houseType){
        this.houseType = houseType;
    }

    /**
     * Getter method for the number of bedrooms in the property
     * @return returns an integer representing the number of bedrooms in the property
     */
    public int getNumBed(){
        return numBed;
    }

    /**
     * Setter method for the number for bedrooms in the property
     * @param numBed int parameter representing the number of bedrooms that will be set for the property
     */
    public void setNumBed(int numBed){
        this.numBed = numBed;
    }

    /**
     * Getter method for the number of bathrooms in the property
     * @return returns an integer representing the number of bathrooms in the property
     */
    public int getNumBath(){
        return numBath;
    }

    /**
     * Setter method for the number for bathrooms in the property
     * @param numBed int parameter representing the number of bathrooms that will be set for the property
     */
    public void setNumBath(int numBath){
        this.numBath = numBath;
    }

    /**
     * Getter method for the furnished status of the property
     * @return returns a boolean representing wether the property is furnished or not
     */
    public boolean getFurnished(){
        return furnished;
    }

    /**
     * Setter method for the furnished status of the property
     * @param furnished boolean parameter that the furnished status will be set to for the property
     */
    public void setFurnished(boolean furnished){
        this.furnished = furnished;
    }

    /**
     * Getter method for the city quadrant in which the property is located
     * @return returns a String representing the quadrant of the city
     */
    public String getQuadrant(){
        return cityQuadrant;
    }

    /**
     * Setter method for the city quadrant 
     * @param cityQuadrant String parameter representing the city quadrant in which the property is located
     */
    public void setQuadrant(String cityQuadrant){
        this.cityQuadrant = cityQuadrant;
    }

    /**
     * Getter method for the email address of the property
     * @return returns a String representing the address of the property
     */
    public String getAddress(){
        return address;
    }

    /**
     * Setter method for the address of the property
     * @param address String parameter representing the address that the property will be set to
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * Getter method for the email address of the landlord
     * @return returns a String representing the email address of the landlord
     */
    public String getLandlordEmail() {
        return this.landlordEmail;
    }

    /**
     * Setter method for the email address of the landlord
     * @param landlordEmail String parameter representing the email address the landlord email will be set to
     */
    public void setLandlordEmail(String landlordEmail) {
        this.landlordEmail = landlordEmail;
    }

    /**
     * Getter method for the state of the property
     * @return returns a String corresponding to the state of the property
     */
    public String getState(){
        return this.state;
    }
    
    /**
     * Getter method for the period fee of the property
     * @return returns an integer value corresponding to the period
     */
    public int getPeriod(){
        return this.period;
    }

    /**
     * Getter method for the id of the property
     * @return returns an integer value corresponding to the id of the property
     */
    public int getID(){
        return this.id;
    }
}
