/**SearchController.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 */

package Controller;
import GUI.*;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;

public class SearchController{
    private SearchView view;
    private String email;

    /**
     * Constructor creates a view model and sets it to visible
     * @param email saves as a variable to later use when sending and recieving emails
     *              Used for registered renter to use
     */
    public SearchController(String email){
        this.view = new SearchView();
        this.view.setVisible(true);
        this.email = email;
        this.view.addSubmitListener(new SearchSubmitListener());

    }

    /**
     * Constructor creates a view model and sets it visible
     * Used for the regular renter to search
     */
    public SearchController(){
        this.view = new SearchView();
        this.view.setVisible(true);
        this.view.addSubmitListener(new RegularRenterSearchSubmitListener());
    }

    /**
     * Method that puts a list of properties into a JTable for display 
     * @param propertyList A list of properties to display
     * @return A JTable corresponding to propertyList 
     */
    public JTable searchTable(ArrayList<Property> propertyList){
        String columnNames[] = {"Address", "State", "Type", "NoBedrooms", "NoBathrooms", "Furnished", "Quadrant"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for(int i = 0; i < propertyList.size(); i++){
            String addr = propertyList.get(i).getAddress();
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

            Object row[] = {addr, state, type, numBed, numBath, isFurnished, quadrant};
            tableModel.addRow(row);
        }

        tableModel.setColumnIdentifiers(columnNames);

        JTable table = new JTable(tableModel);

        return table;
    }

    /**
     * Submits a search when the user clicks the corresponding button. 
     */
    class SearchSubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Property> propList = dbCon.findProperties(view.getTypes(), 
                view.getBed(), view.getBath(), view.getFurnished(), view.getCity());
            JTable table = searchTable(propList);
            view.propertyView(table);
            
        }

    }

    /**
     * Displays properties that match a renter's search criteria. 
     */
    class RegularRenterSearchSubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            /*
                See above "SearchSubmitListener" class methods. Implement the JTable
                feature directly in the controller (you do not have a model);
            */
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Property> propertyList = dbCon.findProperties(view.getTypes(), 
                view.getBed(), view.getBath(), view.getFurnished(), view.getCity());
            String columnNames[] = {"Address", "State", "Type", "NoBedrooms", "NoBathrooms", "Furnished", "Quadrant"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            for(int i = 0; i < propertyList.size(); i++){
                String addr = propertyList.get(i).getAddress();
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
                
                Object row[] = {addr, state, type, numBed, numBath, isFurnished, quadrant};
                tableModel.addRow(row);
            }

            tableModel.setColumnIdentifiers(columnNames);

            JTable table = new JTable(tableModel);
            view.propertyView(table);
        }

    }

}