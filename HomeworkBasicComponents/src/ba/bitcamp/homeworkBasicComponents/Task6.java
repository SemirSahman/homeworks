package ba.bitcamp.homeworkBasicComponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Task6 extends JFrame {

	private static final long serialVersionUID = -9082573555907673880L;

	JTextField field = new JTextField();
	JButton button = new JButton("Start");
	JLabel label = new JLabel();
	int a;
	Timer t = new Timer(1000, new Action());

	public Task6() {
		setLayout(new BorderLayout());
		add(field, BorderLayout.CENTER);
		add(label, BorderLayout.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("" + a);
		add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			     a = Integer.parseInt(field.getText());
				t.start();
			}
		});
		button.addActionListener(t.getActionListeners()[0]);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Timer");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		       if ( a >= 0)
				label.setText(String.valueOf(a));
				a--;
				
			}

		

	}

	public static void main(String[] args) {
		new Task6();

	}

}