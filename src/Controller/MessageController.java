/**MessageController.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 */

package Controller;
import GUI.LandlordView;
import GUI.MessageView;
import GUI.RegisteredRenterView;
import Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MessageController {
    private MessageView view;
    private String senderEmail = "";
    JTable messageList;
    DbConnector db;

    /**
     * Default constructor
     */
    public MessageController(){
        view = new MessageView();
        view.addViewMessageListener(new viewMessage());
    }

    /**
     * Sends a message from a renter to a landlord.
     * @param email The sender's email address.
     */
    public void sendMessageRenter(String email){
        view.addSendMessageListener(new sendMessageRRenter());
        this.senderEmail = email;
        view.openSendMessageRRenter(email);
    }

    public void sendMessageRegularRenter(){
        view.addSendMessageListener(new sendMessageRRenter());
        view.openSendMessageRenter();
    }

    /**
     * Sends a message from a landlord to a renter. 
     * @param email The sender's email address.
     */
    public void sendMessageLandlord(String email){
        view.addSendMessageListener(new sendMessageLandlord());
        this.senderEmail = email;
        view.openSendMessageLandLord();
    }

    /**
     * Displays all of a person's messages. 
     * @param table
     */
    public void viewMessageList(JTable table){
        this.messageList = table;
        view.messageList(table);
    }

    /**
     * Updates the database when a renter submits a message.
     */
    class sendMessageRRenter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            db = new DbConnector();
            db.initializeConnection();
            ArrayList<Property> properties = db.getAllProperties();
            int i = 0;
            for(i = 0; i < properties.size(); i++){
                if(properties.get(i).getAddress().equals(view.getAddress())){
                    Message message = new Message(view.getRenterEmail(), properties.get(i).getLandlordEmail(), view.getMessage(), 0);
                    db.sendMessage(message);
                    JOptionPane.showMessageDialog(null, "Message Sent!");
                    return;
                }
            }
            if(i == properties.size()){
                JOptionPane.showMessageDialog(null, "Send Error!");
            }
        }

    }



    /**
     * Updates the databse when a landlord submits a message. 
     */
    class sendMessageLandlord implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            db = new DbConnector();
            db.initializeConnection();
            Message message = new Message(senderEmail, view.getRenterEmail(), view.getMessage(), 0);
            db.sendMessage(message);
            JOptionPane.showMessageDialog(null, "Message Sent!");
            return;

        }

    }

    /**
     * Displays a message in a pop up box. 
     */
    class viewMessage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = (String)messageList.getValueAt(messageList.getSelectedRow(), 1);
            String email = (String)messageList.getValueAt(messageList.getSelectedRow(), 0);
            JOptionPane.showMessageDialog(null, message,email, JOptionPane.INFORMATION_MESSAGE);
        }

    }
}