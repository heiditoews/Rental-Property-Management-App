/**PRMSApp.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 */

package Controller;
import GUI.LandlordView;
import GUI.LoginView;
import Model.*;
import GUI.*;

import java.io.IOException;



public class PRMSApp {
    /**
     * Runs the program. 
     * @param args Command line argument, not used.
     */
    public static void main(String[]args){
        // LoginView view = new LoginView();
        // LoginController controller = new LoginController(view);
        LoginView lView = new LoginView();
        LoginController lController = new LoginController(lView);
    }
}


