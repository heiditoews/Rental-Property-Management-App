/**RegisteredRenterController.java
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegisteredRenterController{

    private RegisteredRenterView rView;
    private SearchView sView;
    private String email;
    JTable messages;

    /**
     * Constructor 
     * @param email The logged in renter's email address.
     */
    public RegisteredRenterController(String email){
        this.email = email;
        this.rView = new RegisteredRenterView();
        this.rView.setVisible(true);
        this.rView.addUnsubscribeListener(new unsubscribeListener());
        this.rView.addSearchPropertiesListener(new searchPropertiesListener());
        this.rView.addNewNotificationListener(new newNotificationListener());
        this.rView.addNewNotifitationSubmitListener(new newNotificationSubmitListener());
        this.rView.addExitListener(new exitListener());
        this.rView.addSendMessageListener(new sendMessageListener());
        this.rView.addViewFullMessageListener(new viewMessage());
        this.rView.addViewMessageListener(new viewMessageListener());
        this.rView.addViewNotifcatedBuildings(new notificationList());
    }


    private JButton unsub = new JButton();
    
    /**
     * Displays the renter's notification subscriptions and deletes the selected notifications from the database.
     */
    class unsubscribeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected Unsubscribe");

            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Property> notificationList = dbCon.getNotifications(email);
            String columnNames[] = {"Type", "NoBedrooms", "NoBathrooms", "Furnished", "Quadrant", " "};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            for(int i = 0; i < notificationList.size(); i++){
                String type = notificationList.get(i).getHouseType();
                String numBed = String.valueOf(notificationList.get(i).getNumBed());
                String numBath = String.valueOf(notificationList.get(i).getNumBath());
                String isFurnished;
                if(notificationList.get(i).getFurnished()){
                    isFurnished = "Yes";
                }
                else{
                    isFurnished = "No";
                }
                String quadrant = notificationList.get(i).getQuadrant();
                
                Object row[] = {type, numBed, numBath, isFurnished, quadrant};
                tableModel.addRow(row);
            }

            tableModel.setColumnIdentifiers(columnNames);

            JTable table = new JTable(tableModel);
            table.getColumn(" ").setCellRenderer(new ButtonRenderer());
            table.getColumn(" ").setCellEditor(new ButtonEditor(new JCheckBox()));
            
            unsub.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        //JOptionPane.showMessageDialog(null,"Do you want to remove this notification?");
                        int result = JOptionPane.showConfirmDialog(null, "Do you want to remove this notification?");
                        switch (result) {
                            case JOptionPane.YES_OPTION:
                            System.out.println("Yes");
                            int row = table.getSelectedRow();
                            String[] rowValues = new String[table.getColumnCount()];
                            for (int i = 0; i < table.getColumnCount()-1; i++) {
                                rowValues[i] = String.valueOf(table.getModel().getValueAt(row, i));
                                System.out.print(rowValues[i] + " ");
                            }
                            dbCon.dropNotification(email, rowValues);
                            break;
                            case JOptionPane.NO_OPTION:
                            break;
                            case JOptionPane.CLOSED_OPTION:
                            break;
                        }
                        
                    }
                }
            );

            rView.setUnsubscribeView(table);
        }
    }

    /**
     * Method that puts a list of properties into a JTable. 
     * @param propertyList An ArrayList of properties
     * @return A JTable to be displayed 
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

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }
        public JButton getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "Unsubscribe" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;
        
        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public JButton getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "Unsubscribe" : value.toString();
            unsub.setText(label);
            return unsub;
        }

        public Object getCellEditorValue() {
            return new String(label);
        }
    }

    /**
     * Displays the add notifaction page when the renter clicks the corresponding button. 
     */
    class newNotificationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            rView.setNotificationView();
        }

    }

    /**
     * Updates the database when a renter submits a new notification. 
     */
    class newNotificationSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            dbCon.addNotification(email, rView.getTypes(), rView.getBed(), rView.getBath(), rView.getFurnished(), rView.getCity());
            JOptionPane.showMessageDialog(null, "Notification added!");
        }
    }

    /**
     * Opens a new SearchController for a registered renter when the user clicks the corresponding button. 
     */
    class searchPropertiesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected Search Properties");
            SearchController sController = new SearchController(email);

        }

    }

    /**
     * Allows a renter to enter a message for a landlord when the user clicks the corresponding button. 
     */
    class sendMessageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MessageController messageController = new MessageController();
            messageController.sendMessageRenter(email);
        }

    }

    /**
     * Displays a renter's messages when the user clicks the corresponding button. 
     */
    class viewMessageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Message> messageList = dbCon.getMessages(email);
            
            String ColumnNames[] = {"Body"};
            DefaultTableModel tableModel = new DefaultTableModel(ColumnNames, 0);

            for(int i = 0; i < messageList.size(); i++){
                String body = messageList.get(i).getContent();

                Object row[] = {body};
                tableModel.addRow(row);
            }

            tableModel.setColumnIdentifiers(ColumnNames);

            JTable table = new JTable(tableModel);
            messages = table;
            rView.messageView(table);
            
        }

    }

    /**
     * Displays all the properties that match a registered renter's notifications when the user clicks the corresponding button. 
     */
    class notificationList implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DbConnector dbCon = new DbConnector();
            dbCon.initializeConnection();
            ArrayList<Property> propList = dbCon.getPropertyNotifications(email);
            JTable table = searchTable(propList);
            rView.propertyView(table);
        }

    }

    /**
     * Exits the registered renter menu when the user clicks the corresponding button. 
     */
    class exitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected Exit");
            rView.setVisible(false);
            LoginView m = new LoginView();
            LoginController p = new LoginController(m);
            
        }

    }

    /**
     * Displays a pop out with the content of a message when the user clicks the corresponding button. 
     */
    class viewMessage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = (String)messages.getValueAt(messages.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(null, message,"Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
