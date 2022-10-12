/**LoginController.java
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

public class LoginController {
    private LoginView view;
    private DbConnector db;
    // private Property registeredProperty;

    /**
     * Constructor that takes a LoginView object. 
     * @param view A LoginView object to be used by the LoginController.
     */
    public LoginController(LoginView view){
        this.view = view;
        this.view.addLoginListener(new LoginController.loginListener());
        this.view.addSignupListener(new LoginController.signupListener());
        this.view.addRegularRenterListener(new RegularRenterListener());
        db = new DbConnector();
        db.initializeConnection();
    }

    /**
     * Method that logs in a manager.
     */
    public void managerLogin(){
        if(db.validateManager(view.getLoginUsername(), view.getLoginPassword())){
            ManagerView mView = new ManagerView();
            ManagerController mController = new ManagerController(mView, view.getLoginUsername());
            view.close_Login();

        } else {
            JOptionPane.showMessageDialog(null, "Invalid user/pass!");
        }
    }

    /**
     * Method that log in a registered renter.
     */
    public void renterLogin(){
        if(db.validateRRenter(view.getLoginUsername(), view.getLoginPassword())){
            RegisteredRenterController rController = new RegisteredRenterController(view.getLoginUsername());
            view.close_Login();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid user/pass!");
        }
    }

    /**
     * Method that log in a landlord.
     */
    public void landlordLogin(){
        if(db.validateLandlord(view.getLoginUsername(), view.getLoginPassword())){
            LandlordView lView = new LandlordView();
            LandlordController lController = new LandlordController(lView, view.getLoginUsername());
            view.close_Login();
        } else {
            JOptionPane.showMessageDialog(null, "Invalid user/pass!");
        }
    }

    /**
     * Method that opens a SearchView for a regular renter. 
     */
    public void regular_renter(){
        SearchView sView = new SearchView();
        view.close_Login();
    }

    /**
     * Method that signs up a new manager. 
     */
    public void managerSignUp(){
        if(db.signupManager(view.getSignUpEmail(), view.getSignUpUsername(), view.getSignUpPassword())){
            JOptionPane.showMessageDialog(null, "SignUp Complete!");
            view.close_Signup();
        } else {
            JOptionPane.showMessageDialog(null, "Email Exists!");
        }
    }

    /**
     * Method that signs up a new registered renter. 
     */
    public void renterSignUp(){
        if(db.signupRRenter(view.getSignUpEmail(), view.getSignUpUsername(), view.getSignUpPassword())){
            JOptionPane.showMessageDialog(null, "SignUp Complete!");
            view.close_Signup();
        } else {
            JOptionPane.showMessageDialog(null, "Email Exists!");
        }
    }

    /**
     * Method that signs up a new renter. 
     */
    public void landlordSignUp(){
        if(db.signupLandlord(view.getSignUpEmail(), view.getSignUpUsername(), view.getSignUpPassword())){
            JOptionPane.showMessageDialog(null, "SignUp Complete!");
            view.close_Signup();
        } else {
            JOptionPane.showMessageDialog(null, "Email Exists!");
        }
    }

    /**
     * Listens for the user to click a login button.
     */
    class loginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (view.getType()) {
                case 1:
                    renterLogin();
                    break;
                case 2:
                    managerLogin();
                    break;
                case 3:
                    landlordLogin();
                    break;
                default:
                    break;
            }

        }

    }

    /**
     * Listens for a user to click a sign up button.
     */
    class signupListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (view.getType()) {
                case 1:
                    renterSignUp();
                    break;
                case 2:
                    managerSignUp();
                    break;
                case 3:
                    landlordSignUp();
                    break;
                default:
                    break;
            }

        }

    }

    /**
     * Listens for the user to click the "Continue as Regular Renter" button.
     */
    class RegularRenterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            RegularRenterView rrView = new RegularRenterView();
            RegularRenterController rController = new RegularRenterController(rrView);
            
        }

    }

}
