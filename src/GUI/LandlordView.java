/**LandlordView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;

import javax.management.AttributeChangeNotificationFilter;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LandlordView {

    int fieldSize = 30;

    JFrame regFrame = new JFrame("Register Your Property");
    JFrame mainFrame = new JFrame("Landlord view");


    JButton regButton = new JButton("Register Property");
    JButton postButton = new JButton("Post Poperty");
    JButton payFeeButton = new JButton("Pay Fee");
    JButton viewMessages = new JButton("View Messages");
    JButton changeListingButton = new JButton("Change Listing State");
    JButton exit  = new JButton("Exit");

    JButton regPropButton = new JButton("Register");
    JLabel addrLabel = new JLabel("Address");
    JTextField addrField = new JTextField(fieldSize);
    JLabel typeLabel = new JLabel("Please enter the house type.");
    JTextField typeField = new JTextField(fieldSize);
    JLabel bedLabel = new JLabel("Please enter the number of beds.");
    JTextField bedField = new JTextField(fieldSize);
    JLabel bathLabel = new JLabel("Please enter the number of bathrooms.");
    JTextField bathField = new JTextField(fieldSize);
    JLabel furnishedLabel = new JLabel("Please indicate if the house is furnished.");
    JCheckBox furnishedBox = new JCheckBox();
    JLabel quadrantLabel = new JLabel("Please enter the quadrant the house is in.");
    JTextField quadrantField = new JTextField(fieldSize);

    JButton submitPaymentButton = new JButton("Submit Payment");
    JLabel addrPaymentLabel = new JLabel("Please input an address.");
    JTextField addrPaymentField = new JTextField(fieldSize);

    JButton submitPostButton = new JButton("Post Property");
    JLabel addrPostLabel = new JLabel("Please input an address.");
    JTextField addrPostField = new JTextField(fieldSize);

    private JButton submitListingChangeButton = new JButton("Submit Change");
    private JButton sendMessage = new JButton("Send Message");
	private JLabel addressLabel = new JLabel("Please enter the address of the property listing you want to change.");
	private JTextField addressField = new JTextField(30);
	private JLabel stateLabel = new JLabel("Please enter the state you want to update your property listing to.");
	private JTextField stateField = new JTextField(30);

    /**
     * Function that opens the mainFrame window when a Landlord logs in to the application
     */
    public void mainView(){
        // JFrame mainFrame = new JFrame("Landlord Test");
        JPanel mainPanel = new JPanel();
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainPanel.add(regButton);
        mainPanel.add(postButton);
        mainPanel.add(payFeeButton);
        mainPanel.add(changeListingButton);
        mainPanel.add(sendMessage);
        mainPanel.add(viewMessages);
        mainPanel.add(exit);
        mainFrame.setContentPane(mainPanel);

        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);
        

    }

    private String[] types = {"Apartment", "Attached House", "Detached House", "Townhouse"};
	private String[] nums = {"1", "2", "3", "4", "5", "6"};
	private String[] quadrant = {"SW", "NW", "SE", "NE"};

	private JComboBox typeBox = new JComboBox(types);
	private JComboBox bedBox = new JComboBox(nums);
	private JComboBox bathBox = new JComboBox(nums);
	private JComboBox cityBox = new JComboBox(quadrant);

	private JRadioButton yesBtn = new JRadioButton("Yes");
	private JRadioButton noBtn = new JRadioButton("No");
    private ButtonGroup group = new ButtonGroup();

    /**
     * Function that opens the regFrame window when a landlord chooses to register their property
     */
    public void registerView(){
        JFrame regFrame = new JFrame("Register A Property");
        JPanel regPanel = new JPanel();
        regFrame.setContentPane(regPanel);

        regFrame.pack();
        regFrame.setLocationRelativeTo(null);
        regFrame.setSize(410, 350);
        regFrame.getContentPane().setBackground(new Color(230, 230, 250));
        regFrame.getContentPane().setLayout(null);

        JLabel typeLbl = new JLabel("Type");
		typeLbl.setBounds(41, 19, 69, 20);
		regFrame.getContentPane().add(typeLbl);

        JLabel bedLbl = new JLabel("# of Bedrooms");
		bedLbl.setBounds(41, 55, 107, 20);
		regFrame.getContentPane().add(bedLbl);

        JLabel bathLbl = new JLabel("# of bathrooms");
		bathLbl.setBounds(41, 91, 123, 20);
		regFrame.getContentPane().add(bathLbl);

        JLabel FurLbl = new JLabel("Furnished");
		FurLbl.setBounds(41, 127, 69, 20);
		regFrame.getContentPane().add(FurLbl);

        JLabel cityLbl = new JLabel("City quadrant");
		cityLbl.setBounds(41, 163, 107, 20);
		regFrame.getContentPane().add(cityLbl);

        typeBox.setBounds(157, 16, 196, 26);
		regFrame.getContentPane().add(typeBox);
		
		bedBox.setBounds(157, 52, 36, 26);
		regFrame.getContentPane().add(bedBox);
		
		bathBox.setBounds(157, 88, 36, 26);
		regFrame.getContentPane().add(bathBox);
		
		cityBox.setBounds(157, 160, 56, 26);
		regFrame.getContentPane().add(cityBox);
		
		yesBtn.setBounds(152, 123, 61, 29);
		regFrame.getContentPane().add(yesBtn);
		
		noBtn.setBounds(217, 123, 61, 29);
		regFrame.getContentPane().add(noBtn);
		
		group.add(yesBtn);
		group.add(noBtn);
		
        yesBtn.setSelected(true);

        addrLabel.setBounds(41, 199, 145, 20);
		regFrame.getContentPane().add(addrLabel);
        addrField.setBounds(157, 199, 196, 26);
        regFrame.getContentPane().add(addrField);

		regPropButton.setBounds(142, 270, 115, 29);
		regFrame.getContentPane().add(regPropButton);

        regFrame.setVisible(true);

    }

      /**
     * Function that opens the pFrame window when a landlord chooses to pay the fee for a property
     */
    public void payFeeView(double fee, int period){
        JFrame pFrame = new JFrame("Pay Fee");
        JPanel pPanel = new JPanel();
        pFrame.pack();
        pFrame.setLocationRelativeTo(null);

        String currFee = "The current fee is : $" + fee;
        JLabel currFeeLabel = new JLabel(currFee);

        String currPer = "The current period is " + period + " days";
        JLabel currPerLabel = new JLabel(currPer);

        pPanel.add(currFeeLabel);
        pPanel.add(currPerLabel);
        pPanel.add(addrPaymentLabel);
        pPanel.add(addrPaymentField);

        pPanel.add(submitPaymentButton);

        pFrame.setContentPane(pPanel);
        pFrame.setSize(400, 400);
        pFrame.setVisible(true);

    }

    /**
     * Function that opens the poFrame window when a landlord chooses to post their property
     */
    public void postView(){
        JFrame poFrame = new JFrame("Post Property");
        JPanel poPanel = new JPanel();
        poFrame.pack();
        poFrame.setLocationRelativeTo(null);

        poPanel.add(addrPostLabel);
        poPanel.add(addrPostField);

        poPanel.add(submitPostButton);

        poFrame.setContentPane(poPanel);
        poFrame.setSize(400, 400);
        poFrame.setVisible(true);

    }

    /**
     * Function taht opens the clFrame window when a landlord chooses to update the listing for a property
     */
    public void changeListingView(){
		JFrame clFrame = new JFrame("Update Listing");
		JPanel clPanel = new JPanel();
        clFrame.pack();
        clFrame.setLocationRelativeTo(null);
		clPanel.add(addressLabel);
		clPanel.add(addressField);
		clPanel.add(stateLabel);
		clPanel.add(stateField);

		clPanel.add(submitListingChangeButton);

		clFrame.setContentPane(clPanel);
		clFrame.setSize(400, 400);
		clFrame.setVisible(true);

	}

    /**
     * Displays an error message if the landlord has not paid the fee
     */
    public void failPost(){
        JOptionPane.showMessageDialog(null, "Fee has not been paid!");
    }


    /**
     * Function that closes the register property window
     */
     public void closeRegView(){
        regFrame.setVisible(false);
    }

    /**
     * Function that closes the main landlord window
     */
    public void closeMainFrame(){
        mainFrame.setVisible(false);
    }

    /**
     * Getter method for the address typed into the addressField
     * @return returns a String corresponding to the address the user typed in
     */
    public String getAddress(){
		return addressField.getText();
	}

    /**
     * Getter method for the state typed into the stateField
     * @return returns a String corresponding to the state the user typed in
     */
	public String getStateChange(){
		return stateField.getText();
	}

    /**
     * Getter method for the address typed into the addrField
     * @return returns a String corresponding to the address the user typed in
     */
    public String getAddr(){
        return addrField.getText();
    }


    // public String getType(){
    //     return typeField.getText();
    // }

    // public int getBed(){
    //     return Integer.parseInt(bedField.getText());
    // }

    // public int getBath(){
    //     return Integer.parseInt(bathField.getText());
    // }

    // public boolean getFurnished(){
    //     return furnishedBox.isSelected();
    // }

    // public String getQuadrant(){
    //     return quadrantField.getText();
    // }
    
    /**
     * Getter method for the address of the property the user wants to pay a fee for 
     * @return returns a String corresponding to the address the user typed in
     */
    public String getAddressPayment(){
        return addrPaymentField.getText();
    }

    /**
     * Getter method for the address of the property the user wants to post 
     * @return returns a String corresponding to the address the user typed in
     */
    public String getAddressPost(){
        return addrPostField.getText();
    }

    /**
     * Getter method for the house type selected in the typeBox
     * @return returns a String corresponding to the house type selected
     */
    public String getTypes() {
		return (String) typeBox.getSelectedItem();
	}
	
    /**
     * Getter method for the number of bedrooms selected in the bedBox
     * @return returns an int corresponding to the number of bedrooms selected
     */
	public int getBed() {
		return Integer.parseInt((String) bedBox.getSelectedItem());
	}
	
    /**
     * Getter method for the number of bathrooms selected in the bathField
     * @return returns an int corresponding to the number of bathrooms selected
     */
	public int getBath() {
		return Integer.parseInt((String) bathBox.getSelectedItem());
	}
	
    /**
     * Getter method for the quadrant selected in the cityBox
     * @return returns a String corresponding to the city quadrant selected
     */
	public String getQuadrant() {
		return (String) cityBox.getSelectedItem();
	}
	
    /**
     * Getter method for the furnished state of the property
     * @return returns a boolean corresponding on the button the user selected
     */
	public boolean getFurnished() {
        
		if(yesBtn.isSelected()){
			return true;
		} else if (noBtn.isSelected()) {
            return false;
        } else {
            return false;
        }
    }




    //The following methods are responsible for handling all action events such as when the user clicks on a component such as a JButton

    public void addRegisterListener(ActionListener regListener){
        regButton.addActionListener(regListener);
    }

    public void addPostListener(ActionListener postListener){
        postButton.addActionListener(postListener);
    }

    public void addFeeListener(ActionListener payFeeListener){
        payFeeButton.addActionListener(payFeeListener);
    }

    public void addListingListener(ActionListener changeListingListener){
        changeListingButton.addActionListener(changeListingListener);
    }

    public void addRegPropListener(ActionListener regPropListener){
        regPropButton.addActionListener(regPropListener);
    }


    public void addSubmitPaymentListener(ActionListener al){
        submitPaymentButton.addActionListener(al);
    }

    public void addSendMessage(ActionListener al){
        sendMessage.addActionListener(al);
    }

    public void addPostPropListenter(ActionListener al){
        submitPostButton.addActionListener(al);

    }

    public void addMessageListener(ActionListener al){
        viewMessages.addActionListener(al);

    }

    public void addChangeListingListener(ActionListener al){
        changeListingButton.addActionListener(al);
    }

    public void addSubmitListingChangeListener(ActionListener al){
        submitListingChangeButton.addActionListener(al);
    }

    public void addExitListener(ActionListener al)  {
    	exit.addActionListener(al);
	}

}
