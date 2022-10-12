package Controller;
import GUI.*;
import Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.util.ArrayList;

public class LandlordController {
    private LandlordView view;
    private Landlord model;
    // private Property registeredProperty;

    public LandlordController(LandlordView view, String email){
        this.view = view;
        this.model = new Landlord(email);

        this.view.addRegisterListener(new regListener());
        this.view.addPostListener(new postListener());
        this.view.addFeeListener(new payFeeListener());
        this.view.addListingListener(new ChangeListingListener());
        this.view.addMessageListener(new messListener());
        this.view.addSubmitListingChangeListener(new SubmitListingChangeListener());
        this.view.addSendMessage(new sendMessageListener());
        this.view.addExitListener(new exitListener());
        this.view.mainView();

    }

    /**
     * Displays all the messages that a specific landlord is the receiver for
     * shows the sender's email (renter) and the body
     */
    class messListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Message> messageList = dbCon.getMessages(model.getEmailAddress());
            
            String ColumnNames[] = {"Renter Email", "Body"};
            DefaultTableModel tableModel = new DefaultTableModel(ColumnNames, 0);

            for(int i = 0; i < messageList.size(); i++){
                String renterEmail = messageList.get(i).getSenderEmail();
                String body = messageList.get(i).getContent();

                Object row[] = {renterEmail, body};
                tableModel.addRow(row);
            }

            tableModel.setColumnIdentifiers(ColumnNames);
            JTable table = new JTable(tableModel);
            MessageController messageController = new MessageController();
            messageController.viewMessageList(table);
        }
    }

    /**
     * Onclick of this button it will open a view to register a new prop
     */
    class regListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.registerView();
            view.addRegPropListener(new regPropListener());
        }
        
    }


    /**
     * On click open the view to post a property as a listing
     */
    class postListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Pressed Post.");
            view.postView();
            view.addPostPropListenter(new postPropListener());

        }
        
    }


    /**
     * On click the entered property's fee will be marked as paid
     */
    class payFeeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println("Pressed Pay Fee.");
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            double fee = dbCon.getCurrentFee();
            int period = dbCon.getCurrentPeriod();
            view.payFeeView(fee, period);
            view.addSubmitPaymentListener(new submitPaymentListener());

        }
        
    }


    /**
     * On click the enetered message will be added to db
     */
    class sendMessageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                MessageController messageController = new MessageController();
                messageController.sendMessageLandlord(model.getEmailAddress());
        }

    }


    /**
     * On click, registers a property with the database
     */
    class regPropListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            int period = dbCon.getCurrentPeriod();
            System.out.println(period);
            int id = dbCon.getLargestHouseID() + 1;
            System.out.println(id);
            model.registerProperty(view.getTypes(), view.getBed(),
                    view.getBath(), view.getFurnished(), 
                    view.getQuadrant(), view.getAddr(), id);
            dbCon.addProperty(model.getRegisteredProperty());
            view.closeRegView();
            JOptionPane.showMessageDialog(null, "Property registered.");

        }
        
    }

    /**
     * On click, sets the fee and period for a registered property in the database
     */
    class submitPaymentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            dbCon.payFee(view.getAddressPayment(), model.getEmailAddress());
            dbCon.setPropertyPeriod(view.getAddressPayment());
            JOptionPane.showMessageDialog(null, "Fee paid.");
            
        }

    }

    /**
     * On click, posts the registered property to the database
     */
    class postPropListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Post property pressed in the new window with address textfield.");
            String address = view.getAddressPost();
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            if(dbCon.feePaid(address)){
                dbCon.updateListingState(view.getAddressPost(), "Active");
                dbCon.setListingPeriod(view.getAddressPayment());
                JOptionPane.showMessageDialog(null, "Property now visible to renters.");
            }
            else{
                view.failPost();
            }
            
            
        }

    }

    /**
     * On click, updates the database with the listing change
     */
    class SubmitListingChangeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            dbCon.updateListingLandlord(view.getAddress(), view.getStateChange(), model.getEmailAddress());


            
        }

    }

    /**
     * On click, opens a view, prompts landlord to change a property listing state
     */
    class ChangeListingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.changeListingView();
            
        }

    }

    /**
     * On click, returns to login screen
     */
    class exitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected Exit");
            LoginView m = new LoginView();
            new LoginController(m);
            view.closeMainFrame();
        }
    }



}
