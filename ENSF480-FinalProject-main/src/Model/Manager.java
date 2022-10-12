/**Manager.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Manager {
    private String name;
    private String email;
    private String password;


    /**
     * Constructor method for the Manager class with single parameter
     * @param name String parameter that represents the name of the Manager
     */
    public Manager(String name){
        this.name = name;
    }

    public Manager(){

    }

    /**
     * Constructor method for the Manager class with three parameters
     * @param username String parameter for the name of the Manager
     * @param email String parameter for the email of the Manager
     * @param password String parameter for the password of the Manager
     */
    public Manager(String username, String email, String password) {
        this.name = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Getter method for the name of the Manager
     * @return returns a String that represents the name of the Manager
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name of the Manager
     * @param name String parameter that represents the name that the Manager name will be set to 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the password of the Manager
     * @return returns a String that represents the password of the Manager
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for the password of the Manager
     * @param password String parameter that represents the the new password that will be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for the email address of the manager
     * @return returns a String that represents the email address of the Manager
     */
    public String getEmailAddress() {
        return email;
    }

    /**
     * Function that displays the properties in the form of a JTable 
     * @param propertyList ArrayList parameter of type Property 
     * @return returns a table with all of the property attributes as columns and filled out data
     */
    public JTable propertyTable(ArrayList<Property> propertyList){
        String columnNames[] = {"Address", "Landlord", "State", "Type", "NoBedrooms", "NoBathrooms", "Furnished", "Quadrant"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < propertyList.size(); i++){
            String addr = propertyList.get(i).getAddress();
            String landlord = propertyList.get(i).getLandlordEmail();
            String state = propertyList.get(i).getState();
            String type = propertyList.get(i).getHouseType();
            String numBed = String.valueOf(propertyList.get(i).getNumBed());
            String numBath = String.valueOf(propertyList.get(i).getNumBath());
            String isFurnished;
            if(propertyList.get(i).getFurnished()){
                isFurnished = "Yes";
            }
            else{
                isFurnished = "No";
            }
            String quadrant = propertyList.get(i).getQuadrant();
            
            Object row[] = {addr, landlord, state, type, numBed, numBath, isFurnished, quadrant};
            tableModel.addRow(row);
        }

        tableModel.setColumnIdentifiers(columnNames);

        JTable table = new JTable(tableModel);

        return table;
        
    }

    /**
     * Function that displays the Landlord information in the form of a JTable
     * @param landlords Arraylist parameter of type Landlord
     * @return returns a table with all of the landlord attributes as columns and filled out data
     */
    public JTable landlordTable(ArrayList<Landlord> landlords){
        String columnNames[] = {"Name", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        for(int i = 0; i < landlords.size(); i++){
            String name = landlords.get(i).getName();
            String email = landlords.get(i).getEmailAddress();

            Object row[] = {name, email};
            tableModel.addRow(row);
        }

        tableModel.setColumnIdentifiers(columnNames);

        JTable table = new JTable(tableModel);

        return table;
    }

    /**
     * Function that displays the Registered Renter information in the form of a JTable
     * @param renters Arraylist parameter of type RegisteredRenter
     * @return returns a table with all of the Registered Renter attributes as columns and filled out data
     */
    public JTable renterTable(ArrayList<RegisteredRenter> renters){
        String columnNames[] = {"Name", "Email", "State"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < renters.size(); i++){
            String name = renters.get(i).getName();
            String email = renters.get(i).getEmailAddress();
            String state = renters.get(i).getState();

            Object row[] = {name, email, state};
            tableModel.addRow(row);
        }

        tableModel.setColumnIdentifiers(columnNames);

        JTable table = new JTable(tableModel);

        return table;

    }


}
