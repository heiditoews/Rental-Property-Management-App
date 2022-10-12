/**LoginView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView
{
	private JTextField login_username = new JTextField();
	private JTextField login_password = new JTextField();
	private JTextField signup_username = new JTextField();
	private JTextField signup_password = new JTextField();
	private JTextField signup_email = new JTextField();
	JButton re_Login = new JButton("Registered Renter Login");
	JButton m_Login = new JButton("Manager Login");
	JButton l_Login = new JButton("LandLord Login");
	JButton rr_login = new JButton("Continue as Regular Renter");
	JButton login = new JButton("Login");
	JButton signup = new JButton("Signup");
	JButton complete_signup = new JButton("Signup Now");
	LoginBox loginBox;
	SignUp signUp;
	JFrame mainFrame;



	private int type = 0;

	/**
	 * Constructor method for the login page of the application
	 */
	public LoginView() {
		mainFrame = new JFrame("Property DBM");
		JPanel mainPanel = new JPanel();
		loginBox = new LoginBox();
		loginBox.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		loginBox.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		re_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = 1;
				loginBox.setVisible(true);
			}
		});

		m_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = 2;
				loginBox.setVisible(true);
			}
		});

		l_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = 3;
				loginBox.setVisible(true);
			}
		});

		signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginBox.setVisible(false);
				signUp = new SignUp();
				signUp.setVisible(true);
			}
		});


		mainPanel.add(re_Login);
		mainPanel.add(m_Login);
		mainPanel.add(l_Login);
		mainPanel.add(rr_login);
		mainFrame.setContentPane(mainPanel);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setSize(450,450);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Method to close the login page of the application
	 */
	public void close_Login(){
		loginBox.setVisible(false);
		signup.setVisible(false);
		mainFrame.setVisible(false);
	}

	/**
	 * Method to close the sign up page
	 */
	public void close_Signup(){
		signup.setVisible(false);
		loginBox.setVisible(false);
	}

	/**
	 * Method that implements the Login details and fields for entering email and password
	 */
	public class LoginBox extends JDialog{
		public LoginBox(){
			this.pack();
			this.setLocationRelativeTo(null);
			this.setSize(400, 200);
			this.setTitle("Log In");
			JPanel panel_1 = new JPanel();
			this.getContentPane().add(panel_1, BorderLayout.SOUTH);
			panel_1.add(login);
			login.setActionCommand("OK");
			panel_1.add(signup);
			JPanel panel_2 = new JPanel();
			getContentPane().add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);
			login_username.setBounds(150, 20, 130, 26);
			panel_2.add(login_username);
			login_username.setColumns(10);
			login_password.setBounds(150, 55, 130, 26);
			panel_2.add(login_password);
			login_password.setColumns(10);
			JLabel lblEnterUsername = new JLabel("Enter email:");
			lblEnterUsername.setBounds(6, 22, 190, 16);
			panel_2.add(lblEnterUsername);
			JLabel lblEnterPassword = new JLabel("Enter password:");
			lblEnterPassword.setBounds(6, 60, 190, 16);
			panel_2.add(lblEnterPassword);
		}

	}

	/**
	 * Method that implements the sign up details and fields for entering email, name, and password
	 */
	public class SignUp extends JDialog{
		public SignUp(){

			this.pack();
			this.setLocationRelativeTo(null);
			this.setSize(400, 300);
			this.setTitle("Sign Up");
			JPanel panel_1 = new JPanel();
			this.getContentPane().add(panel_1, BorderLayout.SOUTH);
			complete_signup.setActionCommand("OK");
			panel_1.add(complete_signup);


			JPanel panel_2 = new JPanel();
			getContentPane().add(panel_2, BorderLayout.CENTER);
			panel_2.setLayout(null);

			signup_email.setBounds(150, 33, 130, 26);
			panel_2.add(signup_email);
			signup_email.setColumns(10);

			signup_username.setBounds(150, 66, 130, 26);
			panel_2.add(signup_username);
			signup_username.setColumns(10);


			signup_password.setBounds(150, 99, 130, 26);
			panel_2.add(signup_password);
			signup_password.setColumns(10);

			JLabel lblEnterEmail = new JLabel("Enter Email:");
			lblEnterEmail.setBounds(6, 33, 190, 16);
			panel_2.add(lblEnterEmail);

			JLabel lblEnterUsername = new JLabel("Enter Name:");
			lblEnterUsername.setBounds(6, 66, 190, 16);
			panel_2.add(lblEnterUsername);

			JLabel lblEnterPassword = new JLabel("Enter password:");
			lblEnterPassword.setBounds(6, 99, 190, 16);
			panel_2.add(lblEnterPassword);

		}
	}


	/**
	 * Getter method for the type of user using the application
	 * @return returns an integer representing the user using the application
	 */
	public int getType() {
		return type;
	}

	/**
	 * Getter method for the email used in the sign up page
	 * @return returns a String corresponding to the email of the user who signed up
	 */
	public String getSignUpEmail()
	{
		return signup_email.getText();
	}

	/**
	 * Getter method for the name used in the sign up page
	 * @return returns a String corresponding to the name of the user who signed up
	 */
	public String getSignUpUsername()
	{
		return signup_username.getText();
	}

	/**
	 * Getter method for the password used in the sign up page
	 * @return returns a String corresponding to the password of the user who signed up
	 */
	public String getSignUpPassword()
	{
		return signup_password.getText();
	}

	/**
	 * Getter method for the name typed into the username field in the login page
	 * @return returns a String corresponding to the username of the user 
	 */
	public String getLoginUsername()
	{
		return login_username.getText();
	}

	/**
	 * Getter method for the passsword typed into the password field in the login page
	 * @return returns a String corresponding to the password of the user
	 */
	public String getLoginPassword()
	{
		return login_password.getText();
	}

    //The following methods are responsible for handling all actions events such as when the user clicks on a component such as a JButton
	
	public void addLoginListener(ActionListener loginListener){
		login.addActionListener(loginListener);
	}

	public void addSignupListener(ActionListener signupListener){
		complete_signup.addActionListener(signupListener);
	}

	public void addRegularRenterListener(ActionListener al){
		rr_login.addActionListener(al);
	}

}
