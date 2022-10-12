/**ManagerController.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 */

package Controller;
import GUI.*;
import Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ManagerController{
    private ManagerView view;
    private Manager model;

    /**
     * Constructor
     * @param view
     * @param email
     */
    public ManagerController(ManagerView view, String email){
    //    this.model = model;
        this.view = new ManagerView();
        this.view.setVisible(true);

        this.model = new Manager();

        this.view.addViewRentersListener(new ViewRentersListener());
        this.view.addViewLandlordsListener(new ViewLandlordsListener());
        this.view.addViewPropertiesListener(new ViewPropertiesListener());
        this.view.addRequestSummaryListener(new RequestSummaryListener());
        this.view.addSubmitStateChangeListener(new StateChangeListener());
        this.view.addChangeListingListener(new ChangeListingStateListener());
        this.view.addChangeFeesAndPeriodListener(new ChangeFeesAndPeriodListener());
        this.view.addSubmitChangeFeesAndPeriodListener(new SubmitChangeFeesAndPeriodListener());
        this.view.addExitListener(new exitListener());

    }

    /**
     * Listens for the user to click the "View Renters" button. 
     */
    class ViewRentersListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected View Renters");
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<RegisteredRenter> renterList = dbCon.getRenters();
            JTable table = model.renterTable(renterList);
            view.renterView(table);
        }

    }

    /**
     * Listens for the user to click the "View Landlords" button. 
     */
    class ViewLandlordsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected View Landlords");
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Landlord> landlordList = dbCon.getLandlords();
            JTable table = model.landlordTable(landlordList);
            view.landlordView(table);
        }

    }

    /**
     * Listens for the user to click the "View Properties" button. 
     */
    class ViewPropertiesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected View Properties");
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Property> propList = dbCon.getAllProperties();
            JTable table = model.propertyTable(propList);
            view.propertyView(table);
        }

    }

    /**
     * Listens for the user to click the "Request Periodic Summary" button. 
     */
    class RequestSummaryListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected Request Summary");
            Summary sModel = new Summary();
            SummaryView sView = new SummaryView();
            SummaryController sController = new SummaryController(sView, sModel);
            
        }

    }

    /**
     * Listens for the user to click the "Submit Change" button. 
     */
    class StateChangeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            dbCon.updateListingState(view.getAddress(), view.getStateChange());
            view.changeSuccess();
            
        }

    }

    /**
     * Listens for the user to click the "Change Listing State" button. 
     */
    class ChangeListingStateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.changeListingView();
            
        }

    }

    /**
     * Listens for the user to click the "Request Periodic Summary" button. 
     */
    class ChangeFeesAndPeriodListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.changedFeesAndPeriodView();
            
        }

    }

    /**
     * Listens for the user to click the "Submit Changes" button. 
     */
    class SubmitChangeFeesAndPeriodListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            dbCon.addFee(view.getFee(), view.getPeriod());
            JOptionPane.showMessageDialog(null, "Fees and Period updated.");
            
        }

    }
    
    /**
     * Listens for the user to click the "Exit" button. 
     */
    class exitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected Exit");
            view.setVisible(false);
            LoginView m = new LoginView();
            LoginController p = new LoginController(m);
        }
    }


}
