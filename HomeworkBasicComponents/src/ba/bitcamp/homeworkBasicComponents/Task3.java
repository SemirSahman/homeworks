package ba.bitcamp.homeworkBasicComponents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task3 extends JFrame {

	private static final long serialVersionUID = -4651181058295219408L;

	private JTextField field = new JTextField();
	private JPasswordField pass = new JPasswordField();

	private String correctName = "Mujo";
	private String correctPassword = "1234";
	
	JLabel name = new JLabel("Name:");
	JLabel password = new JLabel("Password:");

	public Task3() {
		setLayout(new GridLayout(2, 2));
		add(name);
		name.setHorizontalAlignment(JLabel.CENTER);
		add(field);
		add(password);
		password.setHorizontalAlignment(JLabel.CENTER);
		add(pass);

		pass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String givenPassword = String.valueOf(pass.getPassword());
				String givenName = String.valueOf(field.getText());
				if (e.getSource() == pass) {
					if (correctPassword.equals(givenPassword)
							&& correctName.equals(givenName)) {
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(null,
								"Incorrect user name or password");
					}
				}
			}

		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task3();

	}

}