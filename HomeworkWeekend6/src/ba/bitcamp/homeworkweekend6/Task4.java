package ba.bitcamp.homeworkweekend6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {

	private static final long serialVersionUID = -5110512446232834814L;

	private int num;
	private String s = "";
	private String[] characters = { "A", "B", "C", "D", "E", "F", "G", "H",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	private JButton button1 = new JButton(" > ");
	private JButton button2 = new JButton(" < ");
	private JButton button3 = new JButton(" Insert ");
	private JButton button4 = new JButton(" Char: ");
	private JLabel text = new JLabel("_");

	public Task4() {

		setTitle(" Task 4 ");

		setLayout(new BorderLayout());
		add(button1, BorderLayout.EAST);
		add(button2, BorderLayout.WEST);
		add(button3, BorderLayout.SOUTH);
		add(button4, BorderLayout.NORTH);
		add(text, BorderLayout.CENTER);

		button1.addActionListener(new Action());
		button2.addActionListener(new Action());
		button3.addActionListener(new Action());
		button4.addActionListener(new Action());
		text.setHorizontalAlignment(NORMAL);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		setResizable(false);
		setLocation(350, 350);
		setSize(400, 200);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == button1) {
				num = text.getText().indexOf("_");
				s = text.getText().substring(0, num)
						+ text.getText().substring(num + 1, num + 2)
						+ "_"
						+ text.getText().substring(num + 2,
								text.getText().length());
				text.setText(s);

			}
			if (e.getSource() == button2) {

				num = text.getText().indexOf("_");
				s = text.getText().substring(0, num - 1)
						+ "_"
						+ text.getText().substring(num - 1, num)
						+ text.getText().substring(num + 1,
								text.getText().length());
				text.setText(s);
			}
			if (e.getSource() == button4) {
				button4.setText(characters[(int) (Math.random() * characters.length)]);
			}
			if (e.getSource() == button3) {

				num = text.getText().indexOf("_");
				s = text.getText().substring(0, num)
						+ button4.getText()
						+ "_"
						+ text.getText().substring(num + 1,
								text.getText().length());
				text.setText(s);

			}

		}

	}

	public static void main(String[] args) {
		new Task4();
	}

}