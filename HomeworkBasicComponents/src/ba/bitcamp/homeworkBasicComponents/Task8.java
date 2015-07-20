package ba.bitcamp.homeworkBasicComponents;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task8 extends JFrame{
	

	private static final long serialVersionUID = 8266355810572177747L;
	
	private JLabel labelUsername = new JLabel("Username:");
	private JLabel labelPassword = new JLabel("Password:");
	private JLabel labelConfirm = new JLabel("Confirm:");
	private JTextField txtUsername = new JTextField();
	private JPasswordField passPassword = new JPasswordField();
	private JPasswordField passConfirm = new JPasswordField();	
	private JButton buttonClear = new JButton("Clear");
	private JButton buttonSubmit = new JButton("Submit");
	

	public Task8() {
		setLayout(new FlowLayout());
		txtUsername.setPreferredSize(new Dimension(200, 20));
		passPassword.setPreferredSize(new Dimension(200, 20));
		passConfirm.setPreferredSize(new Dimension(200, 20));
		
		buttonClear.addActionListener(new Action());
		buttonSubmit.addActionListener(new Action());
		
		add(labelUsername);
		add(txtUsername);
		add(labelPassword);
		add(passPassword);
		add(labelConfirm);
		add(passConfirm);
		add(buttonClear);
		add(buttonSubmit);
		
		
		setTitle("Task 8");
		setSize(400, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonClear){
				txtUsername.setText("");
				passPassword.setText("");
				passConfirm.setText("");
			} else if (e.getSource() == buttonSubmit){
				System.out.println(String.valueOf(passPassword.getPassword()));
				System.out.println(String.valueOf(passConfirm.getPassword()));
				if(txtUsername.getText().length() < 6){
					JOptionPane.showMessageDialog(null, "Username must have at least 6 characters");
				} else if (!String.valueOf(passPassword.getPassword()).equals(String.valueOf(passConfirm.getPassword()))){
					JOptionPane.showMessageDialog(null, "Passwords does not match");
				} else if (passPassword.getPassword().length < 6){
					JOptionPane.showMessageDialog(null, "Password must have at least 6 characters");
				} else if (!isTrueDigitAndCharacter(passPassword.getPassword())){
					JOptionPane.showMessageDialog(null, "Password must contain at least one digit and one special character\n(@ # ^ %)");
					
				} else {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Form is succesfully filled");
					System.exit(0);;
				}
				
				
			}
		}

		private boolean isTrueDigitAndCharacter(char[] password) {
			for (int i = 0; i < password.length; i++) {
				if(password[i] >= 48 && password[i] <= 57){
					for (int j = 0; j < password.length; j++) {
						if((password[j] >= 33 && password[j] <= 46) || (password[j] >= 58 && password[j] <= 64)){
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		new Task8();
	}
}