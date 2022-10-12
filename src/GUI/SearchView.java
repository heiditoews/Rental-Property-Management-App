/**SearchView.java
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

public class SearchView extends JFrame{
	
	private String[] types = {"All", "Apartment", "Attached House", "Detached House", "Townhouse"};
	private String[] nums = {"All", "1", "2", "3", "4", "5", "6"};
	private String[] quadrant = {"All", "SW", "NW", "SE", "NE"};

	private JComboBox typeBox = new JComboBox(types);
	private JComboBox bedBox = new JComboBox(nums);
	private JComboBox bathBox = new JComboBox(nums);
	private JComboBox cityBox = new JComboBox(quadrant);

	private JRadioButton yesBtn = new JRadioButton("Yes");
	private JRadioButton noBtn = new JRadioButton("No");
    private JRadioButton allBtn = new JRadioButton("All");
	
	// yesBtn.setActionCommand("Yes");
	// noBtn.setActionCommand("No");



	private ButtonGroup group = new ButtonGroup();

	private JButton submit = new JButton("Submit");

	private JLabel propertyTableLabel = new JLabel("Property Results");

	/**
	 * Constructor method for SearchView class which prompts the user with a search view window with fields for all attributes desired
	 */
	public SearchView() {
		this.pack();
		this.setLocationRelativeTo(null);
		setSize(410, 350);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Search Properties");
		getContentPane().setLayout(null);
		
		JLabel typeLbl = new JLabel("Type");
		typeLbl.setBounds(41, 19, 69, 20);
		getContentPane().add(typeLbl);
		
		JLabel bedLbl = new JLabel("# of Bedrooms");
		bedLbl.setBounds(41, 55, 107, 20);
		getContentPane().add(bedLbl);
		
		JLabel bathLbl = new JLabel("# of bathrooms");
		bathLbl.setBounds(41, 91, 123, 20);
		getContentPane().add(bathLbl);
		
		JLabel FurLbl = new JLabel("Furnished");
		FurLbl.setBounds(41, 127, 69, 20);
		getContentPane().add(FurLbl);
		
		JLabel cityLbl = new JLabel("City quadrant");
		cityLbl.setBounds(41, 163, 107, 20);
		getContentPane().add(cityLbl);
		
		typeBox.setBounds(157, 16, 196, 26);
		getContentPane().add(typeBox);
		
		bedBox.setBounds(157, 52, 36, 26);
		getContentPane().add(bedBox);
		
		bathBox.setBounds(157, 88, 36, 26);
		getContentPane().add(bathBox);
		
		cityBox.setBounds(157, 160, 56, 26);
		getContentPane().add(cityBox);
		
		yesBtn.setBounds(152, 123, 61, 29);
		getContentPane().add(yesBtn);
		
		noBtn.setBounds(217, 123, 61, 29);
		getContentPane().add(noBtn);

        allBtn.setBounds(282, 123, 61, 29);
		getContentPane().add(allBtn);
		
		group.add(yesBtn);
		group.add(noBtn);
        group.add(allBtn);
		
		submit.setBounds(142, 199, 115, 29);
		getContentPane().add(submit);
		
	}

	/**
	 * Function that opens propFrame window to view all properties
	 * @param table JTable object which lists all of the properties in a table format
	 */
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

		propPanel.add(propertyTableLabel);
		JScrollPane pspane = new JScrollPane(table);
		pspane.setPreferredSize(new Dimension(900, 500));

		propPanel.add(pspane);

		propFrame.setContentPane(propPanel);
		propFrame.setSize(1000, 800);
		propFrame.setVisible(true);
	}

	//ActionListener method for the submit button
	public void addSubmitListener(ActionListener al)  {
    	submit.addActionListener(al);
    	submit.setActionCommand("submit");
	}
	
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
	
	/**
	 * Getter method for the furnished status of the property
	 * @return returns a String corresponding to the button the user selected
	 */
	public String getFurnished() {
        
		if(yesBtn.isSelected()){
			return "1";
		} else if (noBtn.isSelected()) {
            return "0";
        } else {
            return "All";
        }
    }
	
}
