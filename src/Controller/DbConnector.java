/**DbConnector.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 */

package Controller;
import Model.*;

import java.lang.invoke.TypeDescriptor;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import javax.swing.*;
import javax.swing.plaf.LabelUI;


public class DbConnector {

    //database URL
    public final String DBURL;

    //database USERNAME
    public final String USERNAME;

    //database PASSWORD
    public final String PASSWORD;

    //DbConnector class's Connection object
    private Connection myConnect;

    //DbConnector's ResultSet object
    private ResultSet results;

    /**
     * default constructor method for DbConnector class
     */
    public DbConnector(){
        this.DBURL = "jdbc:mysql://localhost:3306/480project";
        this.USERNAME = "root";
        this.PASSWORD = "ensf480";
    }

    /**
     * Non default constructor
     * @param DBURL The location at which the database exits.
     * @param USERNAME The user's username.
     * @param PASSWORD The user's password.
     */
    public DbConnector(String DBURL, String USERNAME, String PASSWORD){
        this.DBURL = DBURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    /**
     * Getter method for the DBURL
     * @return returns a string corresponding to the DBURL
     */
    public String getDburl() {
        return DBURL;
    }

    /**
     * Getter method for the USERNAME
     * @return returns a string corresponding to the USERNAME
     */
    public String getUsername() {
        return USERNAME;
    }

    /**
     * Getter method for the PASSWORD
     * @return returns a string corresponding to the PASSWORD
     */
    public String getPassword() {
        return PASSWORD;
    }

    /**
     * Method that uses the DBURL, USERNAME, and PASSWORD member fields to create a connection with the database in SQL.
     */
    public void  initializeConnection(){
        try {
            myConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Method that checks if a Manager is valid and exists in the database
     * @param username Manager's email
     * @param password Manager's password
     * @return returns true or false depending on if the manager exists in the database
     */
    public boolean validateManager(String username, String password){
        Map<String, String> user_pass = new HashMap<String, String>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM manager";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                user_pass.put(results.getString("Email"), results.getString("Password"));
            }
        } catch (SQLException e) {
            close();
            System.out.println(e);
            System.err.println("SQLException in validateManager.");
            System.exit(1);
        }
        for(String emails: user_pass.keySet()){
            if(emails.equals(username) && user_pass.get(emails).equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if a Registered Renter is valid and exists in the database
     * @param username Registered Renter's email
     * @param password Registered Renter's password
     * @return returns true or false depending on if the registered renter exists in the database
     */
    public boolean validateRRenter(String username, String password){
        Map<String, String> user_pass = new HashMap<String, String>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM RegisteredRenter";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                user_pass.put(results.getString("Email"), results.getString("Password"));
            }
        } catch (SQLException e) {
            close();
            System.out.println(e);
            System.err.println("SQLException in validateRRenter.");
            System.exit(1);
        }
        for(String emails: user_pass.keySet()){
            if(emails.equals(username) && user_pass.get(username).equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method that checks if a Landlord is valid and exists in the database
     * @param username Landlord's email
     * @param password Landlord's password
     * @return returns true or false depending on if the landlord exists in the database
     */
    public boolean validateLandlord(String username, String password){
        Map<String, String> user_pass = new HashMap<String, String>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM landlord";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                user_pass.put(results.getString("Email"), results.getString("Password"));
            }
        } catch (SQLException e) {
            close();
            System.out.println(e);
            System.err.println("SQLException in validateLandlord.");
            System.exit(1);
        }
        for(String emails: user_pass.keySet()){
            if(emails.equals(username) && user_pass.get(emails).equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method used to sign up a user as a Manager and add them to the database
     * @param email email address the Manager 
     * @param username name of the Manager
     * @param password password of the Manager
     * @return returns a boolean depending on if the Manager sign up was successful
     */
    public boolean signupManager(String email, String username, String password){
        ArrayList<String> manager_emails = new ArrayList<String>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM manager";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                manager_emails.add(results.getString("Email"));
            }
        } catch (SQLException e) {
            close();
            System.out.println(e);
            System.err.println("SQLException in signupManager.");
            System.exit(1);
        }
        for(String emails: manager_emails){
            if(emails.equals(email)){
                return false;
            }
        }
        Manager manager = new Manager(username,email,password);
        addManager(manager);
        return true;
    }

    /**
     * Method used to sign up a user as a Registered Renter and add them to the database
     * @param email email address the Registered Renter 
     * @param username name of the Registered Renter
     * @param password password of the Registered Renter
     * @return returns a boolean depending on if the Registered Renter sign up was successful
     */
    public boolean signupRRenter(String email, String username, String password){
        ArrayList<String> rrenter_emails = new ArrayList<String>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM registeredrenter";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                rrenter_emails.add(results.getString("Email"));
            }
        } catch (SQLException e) {
            close();
            System.out.println(e);
            System.err.println("SQLException in signupRRenter.");
            System.exit(1);
        }
        for(String emails: rrenter_emails){
            if(emails.equals(email)){
                return false;
            }
        }
        RegisteredRenter renter = new RegisteredRenter(username,email,password);
        addRegisteredRenter(renter);
        return true;
    }

    /**
     * Method used to sign up a user as a Landlord and add them to the database
     * @param email email address the Landlord 
     * @param username name of the Landlord
     * @param password password of the Landlord
     * @return returns a boolean depending on if the Landlord sign up was successful
     */
    public boolean signupLandlord(String email, String username, String password){
        ArrayList<String> landlord_emails = new ArrayList<String>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM landlord";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                landlord_emails.add(results.getString("Email"));
            }
        } catch (SQLException e) {
            close();
            System.out.println(e);
            System.err.println("SQLException in signupLandlord.");
            System.exit(1);
        }
        for(String emails: landlord_emails){
            if(emails.equals(email)){
                return false;
            }
        }
        Landlord landlord = new Landlord(username,email,password);
        addLandlord(landlord);
        return true;
    }

    /**
     * Method that adds a property to the database
     * @param property an object of class Property is passed in to add its information to the database
     */
    public void addProperty(Property property) {
        PreparedStatement stmt = null;
        int furn = 0;
        if(property.getFurnished()){
            furn = 1;
        }
        try {
            String query = "INSERT INTO Property(Address, Landlord, State, Type, NoBedrooms, NoBathrooms, Furnished, CityQuad, Period, ID, FeePaid) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, property.getAddress());
            stmt.setString(2, property.getLandlordEmail());
            stmt.setString(3, property.getState());
            stmt.setString(4, property.getHouseType());
            stmt.setInt(5, property.getNumBed());
            stmt.setInt(6, property.getNumBath());
            stmt.setInt(7, furn);
            stmt.setString(8, property.getQuadrant());
            stmt.setInt(9, property.getPeriod());
            stmt.setInt(10, property.getID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            close();
            e.printStackTrace();
            System.err.println("SQLException in addProperty.");
            System.exit(1);
        }
    }
    
    /**
     * Method that removes a property from the database
     * @param address a String is passed to indicate the address that the user wishes to remove from the database
     */
    public void removeProperty(String address){
        PreparedStatement stmt = null;
        try{
            String query = "DELETE FROM Property WHERE ADDRESS = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, address);
            stmt.executeUpdate();
        } catch(SQLException e){
            close();
            System.err.println("SQLException in removeProperty.");
            System.exit(1);
        }
    }

    /**
     * Method that adds a Landlord to the database
     * @param landlord Landlord object is passed to use the objects information to add them to the database
     */
    public void addLandlord(Landlord landlord){
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO Landlord(Name, Email, Password) VALUES(?, ?, ?)";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, landlord.getName());
            stmt.setString(2, landlord.getEmailAddress());
            stmt.setString(3, landlord.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            close();
            System.err.println("SQLException in addLandlord.");
            System.exit(1);
        }
    }

    /**
     * Method that adds a Manager to the database
     * @param manager Manager object is passed to use the objects information to add them to the database
     */
    public void addManager(Manager manager){
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO Manager(Name, Email, Password) VALUES(?, ?, ?)";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, manager.getName());
            stmt.setString(2, manager.getEmailAddress());
            stmt.setString(3, manager.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            close();
            System.err.println("SQLException in addManager.");
            System.exit(1);
        }
    }

    // public void addMessage(Message message){

    // }

    /**
     * Method that adds a Registered Renter to the database
     * @param renter Registered Renter object is passed to use the objects information to add them to the database
     */
    public void addRegisteredRenter(RegisteredRenter renter){
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO RegisteredRenter(Name, Email, State, Password) VALUES(?, ?, ?, ?)";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, renter.getName());
            stmt.setString(2, renter.getEmailAddress());
            stmt.setString(3, renter.getState());
            stmt.setString(4, renter.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            close();
            System.err.println("SQLException in addRegisteredRenter.");
            System.exit(1);
        }
    }

    /**
     * Method that finds properties in the Property table that corresponds to the data members being passed in to the function
     * @param houseType type of house being requested (e.g. Apartment, Townhouse, Attached House, Detached House)
     * @param numBed number of bedrooms being requested (0-5)
     * @param numBath number of bathrooms being request (0-5)
     * @param furnished status of house being furnished (Yes or No)
     * @param cityQuadrant quadrant of the city in which the house is located (e.g. NW, SW, NE, SE)
     * @return returns an ArrayList of properties that match the criteria that the user specified
     */
    public ArrayList<Property> findProperties(String houseType, String numBed, String numBath, String furnished, String cityQuadrant) {
        ArrayList<Property> properties = new ArrayList<Property>();
        results = null;
        PreparedStatement stmt = null;

        try {
            String query = "SELECT * FROM Property WHERE State = 'Active'";

            if (!houseType.equals("All")) {
                query = query + " AND Type = '" + houseType + "'";
            }
            if (!numBed.equals("All")) {
                query = query + " AND NoBedrooms = " + numBed;
            }
            if (!numBath.equals("All")) {
                query = query + " AND NoBathrooms = " + numBath;
            }
            if (!furnished.equals("All")) {
                query = query + " AND Furnished = " + furnished;
            }
            if (!cityQuadrant.equals("All")) {
                query = query + " AND CityQuad = '" + cityQuadrant + "'";
            }
            query = query + ";";

            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                properties.add(new Property(results.getString("Type"), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), results.getBoolean("Furnished"), results.getString("CityQuad"), results.getString("Address"), results.getString("Landlord"), results.getString("State"), results.getInt("Period"), results.getInt("ID")));
            }

        } catch (SQLException e) {
            close();
            e.printStackTrace();
            System.err.println("SQLException in findProperties.");
            System.exit(1);
        }

        return properties;
    }

    /**
     * Method that gets all the Properties stored in the database at the time
     * @return returns an ArrayList of type Property with all of the properties currently registered in the database
     */
    public ArrayList<Property> getAllProperties() {
        ArrayList<Property> properties = new ArrayList<Property>();
        results = null;
        PreparedStatement stmt = null;
        
        try {
            String query = "SELECT * FROM Property";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                properties.add(new Property(results.getString("Type"), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), results.getBoolean("Furnished"), results.getString("CityQuad"), results.getString("Address"), results.getString("Landlord"), results.getString("State"), results.getInt("Period"), results.getInt("ID")));
            }
        } catch (SQLException e) {
            close();
            System.err.println("SQLException in addRegisteredRenter.");
            System.exit(1);
        }

        return properties;
    }

    /**
     * Method that gets all of a registered renter's notifications and returns them as Property objects.
     * @param renter A registered renter's email address. 
     * @return An ArrayList of Property objects with null landlord emails and addresses. 
     */
    public ArrayList<Property> getNotifications(String renter) {
        ArrayList<Property> notifications = new ArrayList<Property>();
        Statement stmt = null;

        try{
            String query = "SELECT * FROM RenterSubscription WHERE Renter = '" + renter + "'";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                String type = results.getString("Type");
                int bed = results.getInt("NoBedrooms");
                int bath = results.getInt("NoBathrooms");
                int f = results.getInt("Furnished");
                boolean furn;
                if (f == 1) {
                    furn = true;
                } else {
                    furn = false;
                }
                String quad = results.getString("CityQuad");
                notifications.add(new Property(type, bed, bath, furn, quad, " ", " ", " ", 0, -1));
            }
                
        } catch(SQLException e){
            close();
            System.err.println("SQLException in getLandlords.");
            System.exit(1);
        }

        return notifications;
    }

    /**
     * Method that removes a registered renter's notification from the database.
     * @param renter A registered renter's email address. 
     * @param notification The notification to be removed as a String array: {houseType, numBed, numBath, furnished, cityQuad}
     */
    public void dropNotification (String renter, String[] notification) {
        PreparedStatement stmt = null;
        try{
            String query = "DELETE FROM RenterSubscription WHERE Renter = ? AND Type = ? AND NoBedrooms = ? AND NoBathrooms = ? AND Furnished = ? AND CityQuad = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, renter);
            stmt.setString(2, notification[0]);
            stmt.setInt(3, Integer.parseInt(notification[1]));
            stmt.setInt(4, Integer.parseInt(notification[2]));
            int f = 0;
            if (notification[3].equals("Yes")) {
                f = 1;
            }
            stmt.setInt(5, f);
            stmt.setString(6, notification[4]);
            stmt.executeUpdate();
        } catch(SQLException e){
            close();
            System.err.println("SQLException in dropNotification.");
            System.exit(1);
        }
    }

    /**Finds all the properties that match a registered renter's notifications.
     * 
     * @param renter The registered renter's email address. 
     * @return An ArrayList of all properties matching the registered renter's notifications.
     */
    public ArrayList<Property> getPropertyNotifications(String renter) {
        ArrayList<Property> notifications = getNotifications(renter);
        ArrayList<Property> matchingProperties = new ArrayList<Property>();

        for (Property p : notifications) {
            String f = "0";
            if (p.getFurnished()) {
                f = "1";
            }
            ArrayList<Property> get = findProperties(p.getHouseType(), String.valueOf(p.getNumBed()), String.valueOf(p.getNumBath()), f, p.getQuadrant());
            matchingProperties.addAll(get);
        }

        return matchingProperties;
    }

    /**
     * Method that gets all the Landlords stored in the database at the time
     * @return returns an ArrayList of type Landlord with all of the properties currently registered in the database
     */
    public ArrayList<Landlord> getLandlords(){
        ArrayList<Landlord> landlordList = new ArrayList<Landlord>();
        Statement stmt = null;
        String name;
        String email;
        String password;
        try{
            String query = "SELECT * FROM Landlord";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                name = results.getString("Name");
                email = results.getString("Email");
                password = results.getString("Password");
                Landlord landlord = new Landlord(name, email, password);
                landlordList.add(landlord);
            }
        } catch(SQLException e){
            close();
            System.err.println("SQLException in getLandlords.");
            System.exit(1);
        }
        return landlordList;
    }

    /**
     * Method that gets all the Registered Renters stored in the database at the time
     * @return returns an ArrayList of type RegisteredRenter with all of the properties currently registered in the database
     */
    public ArrayList<RegisteredRenter> getRenters(){
        ArrayList<RegisteredRenter> renterList = new ArrayList<RegisteredRenter>();
        Statement stmt = null;
        String name;
        String email;
        String state;
        String password;
        try{
            String query = "SELECT * FROM RegisteredRenter";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                name = results.getString("Name");
                email = results.getString("Email");
                state = results.getString("State");
                password = results.getString("Password");
                RegisteredRenter renter = new RegisteredRenter(name, email, state, password);
                renterList.add(renter);
            }
        } catch(SQLException e){
            close();
            System.err.println("SQLException in getRegisteredRenters.");
            System.exit(1);
        }

        return renterList;
    }

    /**
     * Method that gets all of the houses registered in the database with a certain Period
     * @period Indicates the range of days, starting from current day, in the period
     * @return returns an ArrayList of type Summary
     */
    public ArrayList<Summary> getRentedHousesInPeriod(int period){
        ArrayList<Summary> summary = new ArrayList<Summary>();
        PreparedStatement stmt = null;
        String landlordName;
        String houseAddress;
        int houseID;
        String startDate;
        try{
            String query = "SELECT p.Address, p.ID, p.StartDate, l.Name FROM Property as P, Landlord as l WHERE p.Landlord = l.Email AND p.State = 'Rented'";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();
            while(results.next()){
                LocalDate currentDate = LocalDate.now();
                LocalDate cutoffDate = currentDate.minusDays(period);
                landlordName = results.getString("Name");
                houseAddress = results.getString("Address");
                houseID = results.getInt("ID");
                startDate = results.getString("StartDate");
                LocalDate tupleDate = LocalDate.parse(startDate);
                if(tupleDate.isAfter(cutoffDate)){
                    Summary newSummary = new Summary(landlordName, houseAddress, houseID);
                    summary.add(newSummary);
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getRentedHouses.");
            System.exit(1);
        }

        return summary;
    }

    /**
     * Method that gets the number of houses rented within a certain period
     * @period Indicates the range of days, starting from current day, in the period
     * @return an integer value that represents the houses rented in that period
     */
    public int getNumRentedInPeriod(int period){
        int numRented = 0;
        PreparedStatement stmt = null;
        String startDate;
        try{
            String query = "SELECT * FROM Property WHERE State = 'Rented'";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();
            while(results.next()){
                LocalDate currentDate = LocalDate.now();
                LocalDate cutoffDate = currentDate.minusDays(period);
                startDate = results.getString("StartDate");
                LocalDate tupleDate = LocalDate.parse(startDate);
                if(tupleDate.isAfter(cutoffDate)){
                    numRented++;
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getNumRented.");
            System.exit(1);
        }
        return numRented;
    }

    /**
     * Method that gets the number of houses in the database which have an "Active" state
     * @return an integer value that represents the number of houses that are "Active"
     */
    public int getNumActive(){
        int numActive = 0;
        Statement stmt = null;
        try{
            String query = "SELECT * FROM Property WHERE State = 'Active'";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                numActive++;
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getNumListed.");
            System.exit(1);
        }
        return numActive;
    }

    /**
     * Method that gets the Period from the Fee database table
     * @return returns an integer corresponding to the currentPeriod value found
     */
    public int getCurrentPeriod(){
        int currentPeriod = 0;
        Statement stmt = null;
        try{
            String query = "SELECT * FROM Fees";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                currentPeriod = results.getInt("Period");
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getCurrentPeriod.");
            System.exit(1);
        }
        return currentPeriod;
    }

    /**
     * Method that finds the current fee a landlord has to pay to list their property.
     * @return Returns a double that is the fee for the current period 
     */
    public double getCurrentFee(){
        double currentFee = 0;
        Statement stmt = null;
        try{
            String query = "SELECT * FROM Fees";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);
            while(results.next()){
                currentFee = results.getInt("Fee");
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getCurrentFee.");
            System.exit(1);
        }
        return currentFee;
    }

    /**
     * Method that gets the number of houses listed in the current period
     * @period Indicates the range of days, starting from current day, in the period
     * @return returns an integer value that represenets the number of house listed in the specified period
     */
    public int getNumberListedInPeriod(int period){
        int numListed = 0;
        PreparedStatement stmt = null;
        String startDate;
        try{
            String query = "SELECT * FROM Property";
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while(results.next()){
                LocalDate currentDate = LocalDate.now();
                LocalDate cutoffDate = currentDate.minusDays(period);
                startDate = results.getString("StartDate");
                LocalDate tupleDate = LocalDate.parse(startDate);
                if(tupleDate.isAfter(cutoffDate)){
                    numListed++;
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getNumberListedInPeriod.");
            System.exit(1);
        }
        return numListed;
    }

    /**
     * Method that gets the largest house ID number which corresponds to the latest property entered into the database
     * @return returns an integer value representing the ID of the house 
     */
    public int getLargestHouseID(){
        int id = 0;
        Statement stmt = null;
        try{
            String query = "SELECT * FROM Property";
            stmt = myConnect.createStatement();
            results = stmt.executeQuery(query);

            while(results.next()){
                if(results.getInt("ID") > id){
                    id = results.getInt("ID");
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getNumberListedInPeriod.");
            System.exit(1);
        }
        return id;
    }

    /**
     * Method that updates the state of a House listed in the database
     * @param address String parameter that represents the address of the house
     * @param state String parameter that represents the state the house will be updated to 
     */
    public void updateListingState(String address, String state){
        PreparedStatement stmt = null;
        try{
            String query = "UPDATE Property SET State = ? WHERE Address = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, state);
            stmt.setString(2, address);
            int out = stmt.executeUpdate();
            if(out > 0){
                JOptionPane.showMessageDialog(null, "Listing updated.");
            } else {
                JOptionPane.showMessageDialog(null, "Listing update failed!");
            }

        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in updateListingState.");
            System.exit(1);
        }
    }

    /**
     * Method that sends a Message
     * @param message object of class Message passed in that will be stored in the messages database
     */
    public void sendMessage(Message message) {
        PreparedStatement stmt = null;
        try{
            String query = "INSERT INTO Messages (Sender, Receiver, Content, Viewed) VALUES(?, ?, ?, ?)";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, message.getSenderEmail());
            stmt.setString(2, message.getRecieverEmail());
            stmt.setString(3, message.getContent());
            stmt.setInt(4, 0);
            stmt.executeUpdate();
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in updateListingState.");
            System.exit(1);
        }
    }

    /**
     * Method that checks all the messages for a certain receiver in the database
     * @param renter object of class RegisteredRenter passed in that will check the messages for that renter based on his email address
     * @return returns an ArrayList of type Message corresponding to the all the messages the renter has received
     */
    public ArrayList<Message> checkMessages(RegisteredRenter renter) {
        PreparedStatement stmt = null;
        results = null;
        ArrayList<Message> messages = new ArrayList<Message>();
        try{
            String query = "SELECT * FROM Messages WHERE Receiver='?'";
            stmt.setString(1, renter.getEmailAddress());
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                String s = results.getString("Sender");
                String r = results.getString("Receiver");
                String c = results.getString("Content");
                int v = results.getInt("Viewed");

                messages.add(new Message(s, r, c, v));
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in updateListingState.");
            System.exit(1);
        }

        return messages;
    }

    /**
     * Method that checks all the messages for a certain landlord in the database
     * @param renter object of class Landlord passed in that will check the messages for that landlord based on his email address
     * @return returns an ArrayList of type Message corresponding to the all the messages the landlord has received
     */
    public ArrayList<Message> checkMessages(Landlord landlord) {
        PreparedStatement stmt = null;
        results = null;
        ArrayList<Message> messages = new ArrayList<Message>();
        try{
            String query = "SELECT * FROM Messages WHERE Receiver=?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, landlord.getEmailAddress());
            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();

            while (results.next()) {
                String s = results.getString("Sender");
                String r = results.getString("Receiver");
                String c = results.getString("Content");
                int v = results.getInt("Viewed");

                messages.add(new Message(s, r, c, v));
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in updateListingState.");
            System.exit(1);
        }

        return messages;
    }

    /**
     * Method that returns all the messages from the database
     * @return returns an ArrayList of type Message with all of the messages
     */
    public ArrayList<Message> getMessages(){
        PreparedStatement stmt = null;
        results = null;
        ArrayList<Message> messages = new ArrayList<Message>();
        try{

            String query = "SELECT * FROM Messages";

            stmt = myConnect.prepareStatement(query);
            results = stmt.executeQuery();
            while (results.next()) {
                String s = results.getString("Sender");
                String r = results.getString("Receiver");
                String c = results.getString("Content");
                int v = results.getInt("Viewed");

                messages.add(new Message(s, r, c, v));
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in updateListingState.");
            System.exit(1);
        }

        return messages;
    }

    /**
     * Method that checks if a fee has been paid for a certain property listed
     * @param address String parameter to identify the house and check wether a fee has been paid
     * @return returns a boolean value corresponding to wether a fee has been paid or not
     */
    public boolean feePaid(String address){
        PreparedStatement stmt = null;
        try{
            String query = "SELECT FeePaid FROM Property WHERE Address = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, address);
            results = stmt.executeQuery();
            while ((results.next())){
                if(results.getInt("FeePaid") == 1){
                    return true;
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in payFee.");
            System.exit(1);
        }
        return false;
    }

    /**
     * Method that pays the fee for a certain house in the database
     * @param address String parameter to identify the house for which the fee is being payed for
     * @param landlordEmail String parameter to identify the landlord
     */
    public void payFee (String address, String landlordEmail){
        PreparedStatement stmt = null;
        try{
            String query = "UPDATE Property SET FeePaid = 1 WHERE Address = ? AND Landlord = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, address);
            stmt.setString(2, landlordEmail);
            stmt.executeUpdate();
        } catch(Exception e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in payFee.");
            System.exit(1);
        }
    }

    /**
     * Method that will update the listing state as a landlord
     * @param address String parameter to identify the house for which the state is being updated   
     * @param state String parameter that represents the new state of the house
     * @param email String paremeter that represents the landlord's email
     */
    public void updateListingLandlord(String address, String state, String email){
        PreparedStatement stmt = null;
        try{
            String query = "UPDATE Property SET State = ? WHERE Address = ? AND Landlord = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, state);
            stmt.setString(2, address);
            stmt.setString(3, email);
            int out = stmt.executeUpdate();
            if(out > 0){
                JOptionPane.showMessageDialog(null, "Listing updated.");
            } else {
                JOptionPane.showMessageDialog(null, "Listing update failed!");
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in updateListingLandlord.");
            System.exit(1);
        }
    }

    /**
     * Method that will add a fee to the fee table in the database
     * @param fee Double parameter that specifies the numerical 
     * @param period Integer parameter that specifies the period
     */
    public void addFee(Double fee, int period){
        PreparedStatement stmt = null;
        try{
            String query = "INSERT INTO Fees(Fee, Period) values(?, ?)";
            stmt = myConnect.prepareStatement(query);
            stmt.setDouble(1, fee);
            stmt.setInt(2, period);
            stmt.executeUpdate();
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in addFee.");
            System.exit(1);
        }
    }

    /**
     * Method that adds a notification into the RenterSubscription table
     * @param email String parameter that represents the email of the RegisteredRenter
     * @param houseType type of house being requested (e.g. Apartment, Townhouse, Attached House, Detached House)
     * @param numBed number of bedrooms being requested (0-5)
     * @param numBath number of bathrooms being request (0-5)
     * @param furnished status of house being furnished (Yes or No)
     * @param cityQuadrant quadrant of the city in which the house is located (e.g. NW, SW, NE, SE)
     */
    public void addNotification(String email, String houseType, String numBed, String numBath, String furnished, String cityQuadrant) {
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO RenterSubscription(Renter, Type, NoBedrooms, NoBathrooms, Furnished, CityQuad) VALUES(";
            query = query + "'" + email + "', '" + houseType + "', " + numBed + ", ";
            query = query + numBath + ", " + furnished + ", '" + cityQuadrant + "');";
            System.out.println(query);
            stmt = myConnect.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            close();
            e.printStackTrace();
            System.err.println("SQLException in addNotification.");
            System.exit(1);
        }
    }

    /**
     * Method that removes a certain notification from the RenterSubscription table
     * @param email String parameter that represents the email of the RegisteredRenter
     * @param houseType type of house being requested (e.g. Apartment, Townhouse, Attached House, Detached House)
     * @param numBed number of bedrooms being requested (0-5)
     * @param numBath number of bathrooms being request (0-5)
     * @param furnished status of house being furnished (Yes or No)
     * @param cityQuadrant quadrant of the city in which the house is located (e.g. NW, SW, NE, SE)
     */
    public void removeNotification(String email, String houseType, String numBed, String numBath, String furnished, String cityQuadrant) {
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM RenterSubscription WHERE Renter = '" + email + "' AND Type = '" + houseType;
            query = query + "' AND NoBedrooms = " + numBed + " AND NoBathrooms = " + numBath;
            query = query + " AND Furnished = " + furnished + " AND CityQuad = " + cityQuadrant + ";";
            System.out.println(query);
            stmt = myConnect.prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            close();
            e.printStackTrace();
            System.err.println("SQLException in addNotification.");
            System.exit(1);
        }
    }

    /**
     * Method that finds all of a person's messages. 
     * @param receiverEmail The email address of the person whose messages you want to see. 
     * @return Returns an ArrayList of Messages.
     */
    public ArrayList<Message> getMessages(String receiverEmail){
        PreparedStatement stmt = null;
        ArrayList<Message> messages = new ArrayList<Message>();
        try{
            String query = "SELECT * FROM Messages WHERE Receiver = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, receiverEmail);
            results = stmt.executeQuery();
            if(results != null){
                while(results.next()){
                    String s = results.getString("Sender");
                    String r = results.getString("Receiver");
                    String c = results.getString("Content");
                    int v = results.getInt("Viewed");

                    System.out.println(c);

                    messages.add(new Message(s, r, c, v));
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getMessages.");
            System.exit(1);
        }
        return messages;
    }


    /**
     * Returns the period of a registered property
     * @param address The address of a registered property
     * @return
     */
    public int getPropertyPeriod(String address){
        PreparedStatement stmt = null;
        int period = 0;
        try{
            System.out.println("A");
            String query = "SELECT Period FROM Property WHERE Address = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, address);
            System.out.println("B");
            results = stmt.executeQuery();
            System.out.println("C");
            if(results != null){
                while(results.next()){
                    System.out.println("D");
                    period = results.getInt("Period");
                    System.out.println("E");
                }
            }
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in getPropertyPeriod.");
            System.exit(1);
        }
        return period;
    }

    /**
     * Sets the period for a registered property
     * @param address Address of a registered property
     */
    public void setPropertyPeriod(String address){
        PreparedStatement stmt = null;
        int period = getCurrentPeriod();
        try{
            String query = "UPDATE Property SET Period = ? WHERE Address = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setInt(1, period);
            stmt.setString(2, address);
            stmt.executeUpdate();
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in setPropertyPeriod.");
            System.exit(1);
        }
    }

    /**
     * Sets the start and end date for the period of a listing
     * @param address The address of a registered property that is about to be posted
     */
    public void setListingPeriod(String address){
        PreparedStatement stmt = null;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(getPropertyPeriod(address));
        // Date sDate = Date.valueOf(startDate);
        // Date eDate = Date.valueOf(endDate);
        String sDate = startDate.toString();
        String eDate = endDate.toString();

        try{
            String query = "UPDATE Property SET StartDate = ?, EndDate = ? WHERE Address = ?";
            stmt = myConnect.prepareStatement(query);
            stmt.setString(1, sDate);
            stmt.setString(2, eDate);
            stmt.setString(3, address);
            stmt.executeUpdate();
        } catch(SQLException e){
            close();
            e.printStackTrace();
            System.err.println("SQLException in setListingPeriod.");
            System.exit(1);
        }


    }


    /**
     * Closes the connection to the database.
     */
    public void close(){
        try {
            myConnect.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
