/**RegularRenterController.java
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

import GUI.RegularRenterView;

public class RegularRenterController {
    
    private RegularRenterView view;

    /**
     * Constructor
     * @param view A RegularRenterView object 
     */
    public RegularRenterController(RegularRenterView view){
        this.view = view;
        this.view.setVisible(true);

        view.addSearchPropertiesListener(new SearchPropertiesListener());
        view.addSendEmail(new sendMessageListener());
    }

    /**
     * Allows a renter to search for properties when they click the corresponding button. 
     */
    class SearchPropertiesListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Got here.");
            SearchController sController = new SearchController();
        }

    }

    /**
     * Allows a renter to send a message to a landlord when they click the button. 
     */
    class sendMessageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MessageController messageController = new MessageController();
            messageController.sendMessageRegularRenter();
        }

    }
}