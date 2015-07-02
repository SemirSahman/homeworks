package ba.bitcamp.homeworkweekend6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task1 extends JFrame {

	private String s = "";
	private int counter = 0;

	private static final long serialVersionUID = -3130445084638114976L;

	private JButton[] buttons = new JButton[10];

	public Task1() {

		setLayout(new GridLayout(10, 1));

		for (int i = 0; i < buttons.length; i++) {

			buttons[i] = new JButton(String.valueOf(i));

			add(buttons[i]);

			buttons[i].addActionListener(new Action());

		}

		pack();

		setTitle("Task1");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < buttons.length; i++) {

				if (e.getSource() == buttons[i]) {
					s += String.valueOf(i);
					counter++;
					if (counter == 3) {
						JOptionPane.showMessageDialog(null, "Number : " + s);
						counter = 0;
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		new Task1();

	}

}
