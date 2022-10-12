/**RegisteredRenterView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 *
 */

package GUI;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class RegisteredRenterView extends JFrame{

	private int fieldSize = 30;

	private JButton unsubscribeNotifications = new JButton("Unsubscribe from Notifications");
	private JButton searchProperties = new JButton("Search Properties");
	private JButton addNewNotification = new JButton("Add New Notification");
	private JButton sendMessage = new JButton("Send Message");
	private JButton viewMessage = new JButton("View Messages");
	private JButton viewNotifiedBuildings = new JButton("View Notifications");
	JButton viewFullMessage = new JButton("View Message");
	private JButton exit = new JButton("Exit");

	private JLabel unsubscribeTableLabel = new JLabel("Current Notifications");
	
	/**
	 * Constructor method for the Main Page of the RegisteredRenterView
	 */
	public RegisteredRenterView() {
		this.pack();
		this.setLocationRelativeTo(null);
		setSize(450, 400);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Renter Menu");
        getContentPane().setLayout(null);

		unsubscribeNotifications.setBounds(90, 16, 231, 29);
		getContentPane().add(unsubscribeNotifications);
		
		searchProperties.setBounds(106, 61, 199, 29);
		getContentPane().add(searchProperties);
		
		addNewNotification.setBounds(106, 106, 199, 29);
		getContentPane().add(addNewNotification);

		sendMessage.setBounds(106, 151, 199, 29);
		getContentPane().add(sendMessage);

		viewMessage.setBounds(106, 196, 199, 29);
		getContentPane().add(viewMessage);

		viewNotifiedBuildings.setBounds(106, 241, 199, 29);
		getContentPane().add(viewNotifiedBuildings);

		exit.setBounds(106, 290, 199, 29);
		getContentPane().add(exit);
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

	private JButton submit = new JButton("Get Notified");

	/**
	 * Function that opens the notificationFrame window which allows the user to select criteria for which they would like notifications for 
	 */
	public void setNotificationView(){
		JFrame notificationFrame = new JFrame("Set Property Criteria");
		notificationFrame.pack();
		notificationFrame.setLocationRelativeTo(null);
		JPanel notificationPanel = new JPanel();
		notificationPanel.setBackground(new Color(230, 230, 250));
		notificationPanel.setLayout(null);

		JLabel typeLbl = new JLabel("Type");
		typeLbl.setBounds(41, 19, 69, 20);
		notificationPanel.add(typeLbl);
		
		JLabel bedLbl = new JLabel("# of Bedrooms");
		bedLbl.setBounds(41, 55, 107, 20);
		notificationPanel.add(bedLbl);
		
		JLabel bathLbl = new JLabel("# of bathrooms");
		bathLbl.setBounds(41, 91, 123, 20);
		notificationPanel.add(bathLbl);
		
		JLabel FurLbl = new JLabel("Furnished");
		FurLbl.setBounds(41, 127, 69, 20);
		notificationPanel.add(FurLbl);
		
		JLabel cityLbl = new JLabel("City quadrant");
		cityLbl.setBounds(41, 163, 107, 20);
		notificationPanel.add(cityLbl);
		
		typeBox.setBounds(157, 16, 196, 26);
		notificationPanel.add(typeBox);
		
		bedBox.setBounds(157, 52, 36, 26);
		notificationPanel.add(bedBox);
		
		bathBox.setBounds(157, 88, 36, 26);
		notificationPanel.add(bathBox);
		
		cityBox.setBounds(157, 160, 56, 26);
		notificationPanel.add(cityBox);
		
		yesBtn.setBounds(152, 123, 61, 29);
		notificationPanel.add(yesBtn);
		
		noBtn.setBounds(217, 123, 61, 29);
		notificationPanel.add(noBtn);
		
		yesBtn.setBackground(new Color(230, 230, 250));
		noBtn.setBackground(new Color(230, 230, 250));
		group.add(yesBtn);
		group.add(noBtn);
		
		submit.setBounds(142, 210, 115, 29);
		notificationPanel.add(submit);

		notificationFrame.setContentPane(notificationPanel);
		notificationFrame.setSize(420, 300);
		notificationFrame.setVisible(true);
	}

	private JLabel messagesLabel = new JLabel("Your Messages");

	/**
	 * Function that opens up the mvFrame window which allows the renter to view their messages
	 * @param table JTable object which lists all of the messages in a table format
	 */
	public void messageView(JTable table){
		JFrame mvFrame = new JFrame("Messages");
		JPanel mvPanel = new JPanel();

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
	 * Function that opens up the propFrame for current notification subscriptions
	 * @param table JTable object which lists all of the notifcations in a table format
	 */
    public void setUnsubscribeView(JTable table) {
        JFrame propFrame = new JFrame("Current Notification Subscriptions");
		JPanel propPanel = new JPanel();

		TableColumn column = null;
		for(int i = 0; i < 5; i++){
			column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(50);
		}

		propPanel.add(unsubscribeTableLabel);
		JScrollPane pspane = new JScrollPane(table);
		pspane.setPreferredSize(new Dimension(900, 500));

		propPanel.add(pspane);

		propFrame.setContentPane(propPanel);
		propFrame.setSize(1000, 800);
		propFrame.setVisible(true);
    }
	
    //The following methods are responsible for handling all action events such as when the user clicks on a component such as a JButton

    public void addUnsubscribeListener(ActionListener al)  {
    	unsubscribeNotifications.addActionListener(al);
    	unsubscribeNotifications.setActionCommand("unsubscribe");
	}
    
    public void addSearchPropertiesListener(ActionListener al)  {
    	searchProperties.addActionListener(al);
    	searchProperties.setActionCommand("search properties");
	}

    public void addNewNotificationListener(ActionListener al)  {
    	addNewNotification.addActionListener(al);
    	addNewNotification.setActionCommand("add notification");
	}

    public void addNewNotifitationSubmitListener(ActionListener al) {
        submit.addActionListener(al);
    }

	public void addSendMessageListener(ActionListener al)  {
		sendMessage.addActionListener(al);
	}

	public void addViewMessageListener(ActionListener al)  {
		viewMessage.addActionListener(al);
	}

    public void addExitListener(ActionListener al)  {
    	exit.addActionListener(al);
    	exit.setActionCommand("exit");
	}

	public void addViewNotifcatedBuildings(ActionListener al){viewNotifiedBuildings.addActionListener(al);}

	//End of ActionListener functions


	/**
	 * Getter method for the house type the user selected in the dropdown bar
	 * @return returns a String corresponding to the house type selected
	 */
    public String getTypes() {
		return (String) typeBox.getSelectedItem();
	}
	
	/**
	 * Getter method for the number of bedrooms selected in the dropdown bar
	 * @return returns a String corresponding to the number of bedrooms selected
	 */
	public String getBed() {
		return (String) bedBox.getSelectedItem();
	}
	
	/**
	 * Getter method for the number of bathrooms selected in the dropdown bar
	 * @return returns a String corresponding to the number of bathrooms selected
	 */
	public String getBath() {
		return (String) bathBox.getSelectedItem();
	}
	
	/**
	 * Getter method for the city qudrant selected in the dropdown bar
	 * @return returns a String corresponding to the city quadrant selected
	 */
	public String getCity() {
		return (String) cityBox.getSelectedItem();
	}

	//ActionLister method
	public void addViewFullMessageListener(ActionListener al){
		viewFullMessage.addActionListener(al);
	}

	public void propertyView(JTable table){
		JFrame propFrame = new JFrame("Search Results");
		propFrame.pack();
		propFrame.setLocationRelativeTo(null);
		JPanel propPanel = new JPanel();

		TableColumn column = null;
		for(int i = 0; i < 7; i++){
			column = table.getColumnModel().getColumn(i);
			if(i == 0){
				column.setPreferredWidth(150);
			}
			else if(i == 1){
				column.setPreferredWidth(50);
			}
			else if(i == 2){
				column.setPreferredWidth(75);
			}
			else{
				column.setPreferredWidth(50);
			}

		}

		JScrollPane pspane = new JScrollPane(table);
		pspane.setPreferredSize(new Dimension(900, 500));

		propPanel.add(pspane);

		propFrame.setContentPane(propPanel);
		propFrame.setSize(1000, 800);
		propFrame.setVisible(true);
	}
	
	/**
	 * Getter method for the furnished status of the property
	 * @return returns a String corresponding to the button the user selected
	 */
	public String getFurnished() {
        
		if(yesBtn.isSelected()){
			return "1";
		} else {
            return "0";
        }
    }
    
}
