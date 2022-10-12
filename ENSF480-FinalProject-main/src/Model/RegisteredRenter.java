/**RegisteredRenter.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package Model;
import Controller.Subject;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.NameList;

public class RegisteredRenter implements Observer{

    private String name;
    private String password;
    private String emailAddress;
    private String state;
    private Subject subject;

    /**
     * Default constructor method for the RegisteredRenter class
     */
    public RegisteredRenter() {
        this.name = "";
        this.password = "";
        this.emailAddress = "";
        this.subject = null;
        this.state = "Searching";
    }

    /**
     * Constructor method for the RegisteredRenter class with 4 parameters
     * @param name String parameter representing the name of the Registered Renter
     * @param password String parameter representing the password of the Registered Renter
     * @param emailAddress String parameter representing the email address of the Registered Renter
     * @param subject Subject parameter 
     */
    public RegisteredRenter(String name, String password, String emailAddress, Subject subject){
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
        this.subject = subject;
        this.state = "Searching";
    }

    /**
     * Constructor method for the RegisteredRenter class with 3 parameters
     * @param name String parameter representing the name of the Registered Renter
     * @param email String parameter representing the email address of the Registered Renter
     * @param password String parameter representing the password of the Registered Renter
     */
    public RegisteredRenter(String name, String email, String password){
        this.name = name;
        this.emailAddress = email;
        this.state = "Searching";
        this.password = password;
    }

    /**
     * Constructor method for the RegisteredRenter class with 4 parameters
     * @param name String parameter representing the name of the Registered Renter
     * @param email String parameter representing the email address of the Registered Renter
     * @param state String parameter representing the state of the Registered Renter
     * @param password String parameter representing the password of the Registered Renter
     */
    public RegisteredRenter(String name, String email, String state, String password) {
        this.name = name;
        this.emailAddress = email;
        this.state = state;
        this.password = password;
    }


    public ArrayList<Listing> searchProperties(){

        return null;
    }

    /**
     * Method that checks to see wether the RegisteredRenter is subscribed or not
     * @return returns a boolean
     */
    public boolean isSubscribed(){
        return false;
    }

    public void sendEmail(){

    }

    public Listing filterList(){
        return null;
    }

    public void update(Listing newListing){

    }

    public void update(Property newProperty){

    }

    /**
     * Getter method for the name of the Registered Renter
     * @return returns a string corresponding to the name of the Registered Renter
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name of the Registered Renter
     * @param name String parameter that represents the name that the Registered Renter will be set to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the password of the Registered Renter
     * @return returns a String corresponding to the password of the Registered Renter
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for the password of the Registered Renter
     * @param password String parameter that represents the password that will be set for the Registered Renter
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for the email address of the Registered Renter
     * @return returns a String corresponding to the email address of the Registered Renter
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter method for the email address of the Registered Renter
     * @param emailAddress String paramater that represents the email address that will be set for the Registered Renter
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Setter method for the state of the Registered Renter
     * @param state String parameter that represents the state that will be set for the Registered Renter
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter method for the state of the Registered Renter
     * @return returns a String corresponding to the state of the Registered Renter
     */
    public String getState() {
        return this.state;
    }

    /**
     * Getter method for the subject of the Registered Renter
     * @return returns a Subject object
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Setter method for the subject od the Registered Renter
     * @param subject Subject parameter that represents the subject that will be set for the Registered Renter
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

}
