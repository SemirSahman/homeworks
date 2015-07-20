package ba.bitcamp.homeworkBasicComponents;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {

	private static final long serialVersionUID = 6241904553618392225L;

	private JCheckBox box1 = new JCheckBox("BOLD");
	private JCheckBox box2 = new JCheckBox("ITALIC");

	JLabel label = new JLabel("Task2");

	Font plain = new Font("Serif", Font.PLAIN, 20);
	Font bold = new Font("Serif", Font.BOLD, 20);
	Font italic = new Font("Serif", Font.ITALIC, 20);
	Font boldItalic = new Font("Serif", Font.BOLD | Font.ITALIC, 20);

	JButton submit = new JButton("Submit");

	public Task2() {
		setLayout(new GridLayout(4, 1));
		add(label);
		label.setFont(plain);
		label.setHorizontalAlignment(JLabel.CENTER);

		add(box1);
		add(box2);

		add(submit);

		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == submit) {
					if (box1.isSelected() == true && box2.isSelected() == true) {
						label.setFont(boldItalic);
					} else if (box1.isSelected() == true) {
						label.setFont(bold);
					} else if (box2.isSelected() == true) {
						label.setFont(italic);
					}else{
						label.setFont(plain);
					}
				}

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Task2");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task2();

	}

}