package ba.bitcamp.homeworkweekend6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {

	private static final long serialVersionUID = -7295033567067544261L;

	private String name = "First name";
	private String lname = "Last name";
	private JButton button1 = new JButton("First name");
	private JButton button2 = new JButton("Last name");
	private JLabel text = new JLabel(name + " " + lname);

	/**
	 * Default constructor
	 */
	public Task2() {

		setTitle(" Task 2 ");

		setLayout(new BorderLayout());
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);
		add(text, BorderLayout.CENTER);

		text.setHorizontalAlignment(NORMAL);
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		setLocationRelativeTo(null);
		setSize(400, 400);
		setVisible(true);
	}

	/**
	 * This is inner class that contains array of names
	 * 
	 * @author Semir
	 *
	 */
	static class Names {

		protected String names[] = { "Leon", "Samir", "Haris", "Dzemal" };

		/**
		 * Method that generates one random name from names array
		 * 
		 * @return - one name
		 */
		public String generateName() {

			return names[(int) (Math.random() * names.length)];
		}

		@Override
		public String toString() {
			return generateName();
		}

	}

	/**
	 * This is inner class that contains array of last names
	 * 
	 * @author Semir
	 *
	 */
	static class lastNames {

		public String lastNames[] = { "Benko", "Radovac", "Duljevic",
				"Berberovic" };

		/**
		 * Method that generates one random last name from lastNames array
		 * 
		 * @return one last name
		 */
		String generateSurnName() {

			return lastNames[(int) (Math.random() * lastNames.length)];
		}

		@Override
		public String toString() {
			return generateSurnName();
		}
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button1) {

				name = new Names().toString();
				text.setText(name + " " + lname);

			} else if (e.getSource() == button2) {

				lname = new lastNames().toString();
				text.setText(name + " " + lname);
			}

		}

	}

	public static void main(String[] args) {
		new Task2();
	}

}