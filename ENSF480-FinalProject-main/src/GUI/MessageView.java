/**MessageView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 *
 */

package GUI;

import Controller.DbConnector;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Model.Message;

public class MessageView {
    JTextArea messageContent = new JTextArea();
    JTextField address = new JTextField();
    JTextField renterEmail = new JTextField();
    JButton sendMessage = new JButton("Send Message");
    JButton viewFullMessage = new JButton("View Message");
    String email = "";

    DbConnector db;

    /**
     * Function that opens the send message view for registered renter
     */
    public void openSendMessageRRenter(String email){
        renterEmail.setText(email);
        JDialog popUp = new JDialog();
        popUp.pack();
        popUp.setLocationRelativeTo(null);
        popUp.setSize(500, 500);
        popUp.setTitle("Send Message");
        JPanel panel_1 = new JPanel();
        popUp.getContentPane().add(panel_1, BorderLayout.SOUTH);
        JPanel panel_2 = new JPanel();
        address.setBounds(100,20, 300, 30);
        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setBounds(20, 20, 100, 30);
        panel_2.add(addressLabel);
        panel_2.add(address);
        JLabel contentLabel = new JLabel("Message: ");
        contentLabel.setBounds(20, 60, 100, 30);
        messageContent.setBounds(100, 60, 300, 300);
        panel_2.add(contentLabel);
        panel_2.add(messageContent);
        popUp.getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(null);
        panel_1.add(sendMessage);
        sendMessage.setActionCommand("OK");
        popUp.setVisible(true);
    }

    /**
     * Function that opens the send message view for regular renter
     */
    public void openSendMessageRenter(){
        JDialog popUp = new JDialog();
        popUp.pack();
        popUp.setLocationRelativeTo(null);
        popUp.setSize(500, 500);
        popUp.setTitle("Send Message");
        JPanel panel_1 = new JPanel();
        popUp.getContentPane().add(panel_1, BorderLayout.SOUTH);
        JPanel panel_2 = new JPanel();
        address.setBounds(100,20, 300, 30);
        JLabel addressLabel = new JLabel("Address: ");
        addressLabel.setBounds(20, 20, 100, 30);
        panel_2.add(addressLabel);
        panel_2.add(address);
        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(20, 60, 100, 30);
        renterEmail.setBounds(100, 60, 300, 30);
        panel_2.add(renterEmail);
        JLabel contentLabel = new JLabel("Content: ");
        contentLabel.setBounds(20, 100, 100, 30);
        messageContent.setBounds(100, 100, 300, 300);
        panel_2.add(contentLabel);
        panel_2.add(emailLabel);
        panel_2.add(messageContent);
        popUp.getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(null);
        panel_1.add(sendMessage);
        sendMessage.setActionCommand("OK");
        popUp.setVisible(true);
    }

    /**
     * Function that opens the send message view for landlord
     */
    public void openSendMessageLandLord(){
        JDialog popUp = new JDialog();
        popUp.pack();
        popUp.setLocationRelativeTo(null);
        popUp.setSize(500, 500);
        popUp.setTitle("Send Message");
        JPanel panel_1 = new JPanel();
        popUp.getContentPane().add(panel_1, BorderLayout.SOUTH);
        JPanel panel_2 = new JPanel();
        renterEmail.setBounds(100,20, 300, 30);
        JLabel addressLabel = new JLabel("Renter Email: ");
        addressLabel.setBounds(20, 20, 100, 30);
        panel_2.add(addressLabel);
        panel_2.add(renterEmail);
        JLabel contentLabel = new JLabel("Message: ");
        contentLabel.setBounds(20, 60, 100, 30);
        messageContent.setBounds(100, 60, 300, 300);
        panel_2.add(contentLabel);
        panel_2.add(messageContent);
        popUp.getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(null);
        panel_1.add(sendMessage);
        sendMessage.setActionCommand("OK");
        popUp.setVisible(true);
    }

    /**
     * Function that opens the mvFrame window to display a list of messages in a table format
     * @param table JTable object which lists all of the message information in a table format
     */
    public void messageList(JTable table){
        JFrame mvFrame = new JFrame("Messages");
        JPanel mvPanel = new JPanel();
        JLabel messagesLabel = new JLabel("Your Messages");
        mvPanel.add(messagesLabel);
        JScrollPane mvScroll = new JScrollPane(table);
        mvScroll.setPreferredSize(new Dimension(500, 500));

        mvPanel.add(mvScroll);

        mvFrame.setContentPane(mvPanel);
        mvFrame.setSize(800, 800);
        mvFrame.add(viewFullMessage);
        viewFullMessage.setBounds(375, 700, 50, 20);
        mvFrame.setVisible(true);
    }

    /**
     * Getter method that returns the message that the user typed into the text area
     * @return returns a String corresponding to the message 
     */
    public String getMessage(){
        return messageContent.getText();
    }

    /**
     * Getter method that returns the address of the property
     * @return returns a String corresponding to the address of the property the user typed in
     */
    public String getAddress(){
        return address.getText();
    }

    /**
     * Getter method that returns the email address of the renter
     * @return returns a String corresponding to the email address of the renter
     */
    public String getRenterEmail() { return renterEmail.getText(); }



    //The following methods are responsible for handling all action events such as when the user clicks on a component such as a JButton

    public void addSendMessageListener(ActionListener al){
        sendMessage.addActionListener(al);
    }
    public void addViewMessageListener(ActionListener al){
        viewFullMessage.addActionListener(al);
    }


}
