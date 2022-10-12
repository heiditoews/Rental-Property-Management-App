/**Summary.java
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

public class Summary {
    private String landlordName;
    private String propertyAddress;
    private int houseID;

    /**
     * Constructor method for the Summary class
     * @param landlordName String parameter representing the name of the landlord
     * @param propertyAddress String parameter representing the address of the property
     * @param houseID int parameter representing the id of the house
     */
    public Summary(String landlordName, String propertyAddress, int houseID){
        this.landlordName = landlordName;
        this.propertyAddress = propertyAddress;
        this.houseID = houseID;
    }

    public Summary(){
        
    }

    /**
     * Function that displays the private data members in the form of a JTable 
     * @param summaryList ArrayList parameter of type Summary
     * @return returns a table with all of the summary attributes as columns and filled out data
     */
    public JTable summaryTable(ArrayList<Summary> summaryList){
        String columnNames[] = {"Landlord Name", "House ID", "Address"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < summaryList.size(); i++){
            String lName = summaryList.get(i).getLandlordName();
            String addr = summaryList.get(i).getPropertyAddress();
            int id = summaryList.get(i).getHouseID();

            Object row[] = {lName, id, addr};
            tableModel.addRow(row);
        }

        tableModel.setColumnIdentifiers(columnNames);
        JTable table = new JTable(tableModel);
        return table;
    }

    /**
     * Getter method for the name of the landlord
     * @return returns a String corresponding to the name of the landlord
     */
    public String getLandlordName(){
        return this.landlordName;
    }

    /**
     * Getter method for the address of the property
     * @return returns a String corresponding to the address of the property
     */
    public String getPropertyAddress(){
        return this.propertyAddress;
    }

    /**
     * Getter method for the house id
     * @return returns an int corresponding to the house id
     */
    public int getHouseID(){
        return this.houseID;
    }
}
