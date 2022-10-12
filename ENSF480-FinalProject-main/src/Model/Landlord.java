/**Landlord.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package Model;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.DbConnector;

public class Landlord{
    private String name;
    private String email;
    private String password;
    private ArrayList<Property> properties;
    private ArrayList<Message> messages;
    private Property registeredProperty;
    private int feePaid = 0;

    /**
     * Constructor method for the Landlord class
     * @param name String parameter representing landlord name
     * @param email String parameter representing landlord email
     * @param password String parameter representing landlord password
     */
    public Landlord(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Landlord constructor with email as single parameter
     * @param email String parameter representing landlord email
     */
    public Landlord(String email){
        this.email = email;
    }

    /**
     * Method that initializes the registeredProperty data member 
     * @param type String parameter that represents the houseType
     * @param bedrooms int parameter that represents the # of bedrooms
     * @param bathrooms int parameter that represents the # of bathrooms
     * @param furnished boolean parameter that determines if the house is purchased or not
     * @param quad String parameter that represents the city quadrant the house is located in
     * @param address String parameter that represents the address of the house being registered
     * @param period int parameter that represents the period of the house fee
     * @param id int parameter that represents the number in which the house was added to the database
     */
    public void registerProperty(String type, int bedrooms, int bathrooms, boolean furnished, String quad, String address, int id){
        registeredProperty = new Property(type, bedrooms, bathrooms, furnished, quad, address, this.email, "Suspended", id);
    }

    /**
     * Method that connects to the database to post a Property
     */
    public void postProperty(){
        DbConnector dbCon = new DbConnector();
        dbCon.initializeConnection();
        dbCon.addProperty(registeredProperty);
    }

    /**
     * Getter method to return the name of the landlord
     * @return returns a String representing the name of the landlord
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name of the landlord
     * @param name String parameter that corresponds to the name that the landlord will be set to 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the password of the landlord
     * @return returns a String representing the password of the landlord
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for the password of the landlord
     * @param password String parameter that corresponds to what the password of the landlord will be set to
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for the email address of the landlord
     * @return returns a String representing the email of the landlord
     */
    public String getEmailAddress() {
        return email;
    }

    /**
     * Setter method for the email address of the landlord
     * @param emailAddress String parameter that corresponds to what the email address of the landlord will be set to
     */
    public void setEmailAddress(String emailAddress) {
        this.email = emailAddress;
    }

    /**
     * Getter method for the registered property
     * @return returns a Property object corresponding to the registeredProperty
     */
    public Property getRegisteredProperty(){
        return this.registeredProperty;
    }

}
