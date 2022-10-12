/**RegularRenterView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 *
 */

package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;

public class RegularRenterView extends JFrame{
    
    private JButton searchPropertyButton = new JButton("Search Properties");
    private JButton contactLandlordButton = new JButton("Email Landlord");

    /**
     * Constructor method for RegularRenterView which prompts the user with the Regular Renter Menu 
     */
    public RegularRenterView(){
        setSize(450, 450);
		getContentPane().setBackground(new Color(230, 230, 250));
		setTitle("Regular Renter Menu");
		getContentPane().setLayout(null);

        searchPropertyButton.setBounds(106, 16, 199, 29);
		getContentPane().add(searchPropertyButton);

        contactLandlordButton.setBounds(106, 61, 199, 29);
		getContentPane().add(contactLandlordButton);

    }

    //The following methods are responsible for handling all action events such as when the user clicks on a component such as a JButton

    public void addSearchPropertiesListener(ActionListener al){
        searchPropertyButton.addActionListener(al);
    }

    public void addSendEmail(ActionListener al){
        contactLandlordButton.addActionListener(al);
    }

}
