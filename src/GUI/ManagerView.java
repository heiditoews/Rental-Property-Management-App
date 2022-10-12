/**ManagerView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumn;
//import java.awt.event.ActionEvent;

public class ManagerView extends JFrame{

	private JButton viewRenters = new JButton("View Registered Renters");
	private JButton viewLandlords = new JButton("View Landlords");
	private JButton viewProperties = new JButton("View Properties");
	private JButton changeFees = new JButton("Change Fees and Period");
	private JButton requestPeriodicSummary = new JButton("Request Periodic Summary");
	private JButton changeListingState = new JButton("Change Listing State");
	private JButton exit = new JButton("Exit");

	private JLabel propertyTableLabel = new JLabel("All Properties");
	private JLabel landlordTableLabel = new JLabel("All Landlords");
	private JLabel renterTableLabel = new JLabel("All Renters");

	private JButton submitListingChangeButton = new JButton("Submit Change");
	private JLabel addressLabel = new JLabel("Please enter the address of the property listing you want to change.");
	private JTextField addressField = new JTextField(30);
	private JLabel stateLabel = new JLabel("Please enter the state you want to update the property listing to.");
	private JTextField stateField = new JTextField(30);

	private JButton submitChangeFeesButton = new JButton("Submit Changes");
	private JLabel changeFeeLabel = new JLabel("Input the new fee.");
	private JTextField changeFeeField = new JTextField(30);
	private JLabel changePeriodLabel = new JLabel("Input the new period.");
	private JTextField changePeriodField = new JTextField(30);

	/**
	 * Constructor method for the Main Page of the ManagerView window
	 */
	public ManagerView() {
		this.pack();
		this.setLocationRelativeTo(null);
		setSize(450, 450);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Manager Menu");
		getContentPane().setLayout(null);
		
		viewRenters.setBounds(106, 16, 199, 29);
		getContentPane().add(viewRenters);
		
		viewLandlords.setBounds(106, 61, 199, 29);
		getContentPane().add(viewLandlords);
		
		viewProperties.setBounds(106, 106, 199, 29);
		getContentPane().add(viewProperties);
		
		changeFees.setBounds(106, 151, 199, 29);
		getContentPane().add(changeFees);
		
		requestPeriodicSummary.setBounds(106, 199, 199, 29);
		getContentPane().add(requestPeriodicSummary);

		changeListingState.setBounds(106, 247, 199, 29);
		getContentPane().add(changeListingState);

		exit.setBounds(106, 295, 199, 29);
		getContentPane().add(exit);
	}

	/**
	 * Function that opens the propFrame window when a Manager chooses to view all the properties
	 * @param table JTable object which lists all of the properties in a table format
	 */
	public void propertyView(JTable table){
		JFrame propFrame = new JFrame("All Properties");
		JPanel propPanel = new JPanel();

		TableColumn column = null;
		for(int i = 0; i < 8; i++){
			column = table.getColumnModel().getColumn(i);
			if(i == 2){
				column.setPreferredWidth(50);
			}
			else if(i == 3){
				column.setPreferredWidth(75);
			}
			else if(i >= 4){
				column.setPreferredWidth(50);
			}
			else{
				column.setPreferredWidth(150);
			}
			
		}

		propPanel.add(propertyTableLabel);
		JScrollPane pspane = new JScrollPane(table);
		pspane.setPreferredSize(new Dimension(900, 500));

		propPanel.add(pspane);

		propFrame.setContentPane(propPanel);
		propFrame.setSize(1000, 800);
		propFrame.setVisible(true);

	}

	/**
	 * Function that opens the lFrame window when a Manager chooses to view all the landlords
	 * @param table JTable object which lists all of the properties in a table format
	 */
	public void landlordView(JTable table){
		JFrame lFrame = new JFrame("All Landlords");
		JPanel lPanel = new JPanel();

		TableColumn column = null;
		for(int i = 0; i < 2; i++){
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(200);
		}

		lPanel.add(landlordTableLabel);
		JScrollPane lspane = new JScrollPane(table);
		lspane.setPreferredSize(new Dimension(900, 500));

		lPanel.add(lspane);

		lFrame.setContentPane(lPanel);
		lFrame.setSize(1000, 800);
		lFrame.setVisible(true);
	}

	/**
	 * Function that opens the rFrame window when a Manager chooses to view all the Renters
	 * @param table JTable object which lists all of the renters in a table format
	 */
	public void renterView(JTable table){
		JFrame rFrame = new JFrame("All Renters");
		JPanel rPanel = new JPanel();

		TableColumn column = null;
		for(int i = 0; i < 3; i++){
			column = table.getColumnModel().getColumn(i);
			if(i == 1){
				column.setPreferredWidth(200);
			}
			else if(i == 2){
				column.setPreferredWidth(50);
			}
		}

		rPanel.add(renterTableLabel);
		JScrollPane rspane = new JScrollPane(table);
		rspane.setPreferredSize(new Dimension(900, 500));

		rPanel.add(rspane);

		rFrame.setContentPane(rPanel);
		rFrame.setSize(1000, 1000);
		rFrame.setVisible(true);
	}

	/**
	 * Function that opens the clFrame window when a Manager chooses to update the listing of a property
	 */
	public void changeListingView(){
		JFrame clFrame = new JFrame("Update Listing");
		JPanel clPanel = new JPanel();

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
	 * Function that opens the feeFrame when a Manager chooses to update te Fees and Period of a property
	 */
	public void changedFeesAndPeriodView(){
		JFrame feeFrame = new JFrame("Change Fees and Period");
		JPanel feePanel = new JPanel();

		feePanel.add(changeFeeLabel);
		feePanel.add(changeFeeField);
		feePanel.add(changePeriodLabel);
		feePanel.add(changePeriodField);

		feePanel.add(submitChangeFeesButton);

		feeFrame.setContentPane(feePanel);
		feeFrame.setSize(400, 400);
		feeFrame.setVisible(true);
	}

	/**
	 * Getter method for the updated fee
	 * @return returns a double corresponding to the updated fee value
	 */
	public double getFee(){
		return Double.parseDouble(changeFeeField.getText());
	}

	/**
	 * Getter method for the updated period
	 * @return returns an integer corresponding to the updated period value
	 */
	public int getPeriod(){
		return Integer.parseInt(changePeriodField.getText());
	}

	/**
	 * Getter method for the address of the property listing the Manager changed
	 * @return returns a String corresponding to the address
	 */
	public String getAddress(){
		return addressField.getText();
	}

	/**
	 * Getter method for the state of the property the Manager changed
	 * @return returns a String corresponding to the state
	 */
	public String getStateChange(){
		return stateField.getText();
	}

	/**
	 * Function that opens up newFrame when the listing state changed successfully
	 */
	public void changeSuccess(){
		JFrame newFrame = new JFrame();
		JOptionPane joPane = new JOptionPane("Listing state changed successfully.");
	}
	
    //The following methods are responsible for handling all action events such as when the user clicks on a component such as a JButton

	public void addChangeListingListener(ActionListener al){
		changeListingState.addActionListener(al);
	}

	public void addSubmitStateChangeListener(ActionListener al){
		submitListingChangeButton.addActionListener(al);
	}
	
	public void addViewRentersListener(ActionListener al)  {
    	viewRenters.addActionListener(al);
    	viewRenters.setActionCommand("view renters");
	}
    
    public void addViewLandlordsListener(ActionListener al)  {
    	viewLandlords.addActionListener(al);
    	viewLandlords.setActionCommand("view landlords");
	}
    
    public void addViewPropertiesListener(ActionListener al)  {
    	viewProperties.addActionListener(al);
    	viewProperties.setActionCommand("view properties");
	}
    
    public void addRequestSummaryListener(ActionListener al) {
    	requestPeriodicSummary.addActionListener(al);
    	requestPeriodicSummary.setActionCommand("summary");
    }

	public void addExitListener(ActionListener al)  {
    	exit.addActionListener(al);
    	exit.setActionCommand("exit");
	}

	public void addChangeFeesAndPeriodListener(ActionListener al){
		changeFees.addActionListener(al);
	}

	public void addSubmitChangeFeesAndPeriodListener(ActionListener al){
		submitChangeFeesButton.addActionListener(al);
	}
}
