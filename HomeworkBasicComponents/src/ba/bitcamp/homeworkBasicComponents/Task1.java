package ba.bitcamp.homeworkBasicComponents;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task1 extends JFrame {

	private static final long serialVersionUID = -5685463051158765104L;
	private int fontSize;
	private String s = "Task1";
	
private JSlider slider = new JSlider(0, 100, 10);
JLabel label = new JLabel();
	
	public Task1() {
		
		setLayout(new BorderLayout());
		
		add(label, BorderLayout.CENTER);
		label.setText(s);
		label.setFont(new Font("Serif", Font.BOLD, 10));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		add(slider, BorderLayout.SOUTH);
		slider.addChangeListener(new Change());
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Task1");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class Change implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			fontSize = slider.getValue();
			label.setFont(new Font("Serif", Font.BOLD, fontSize));
		}
		
	}

	public static void main(String[] args) {
		new Task1();

	}

}