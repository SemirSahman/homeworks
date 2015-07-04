package ba.bitcamp.homeworkBasicComponents;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Task7 extends JFrame {

	int x;
	int y;
	int r;
	
	private static final long serialVersionUID = 1494148052431766163L;

	private JPanel panel = new MyPanel();
	private JSlider slider = new JSlider(0, 250, 0);

	public Task7() {
		setLayout(new BorderLayout());
		add(panel);

		panel.addMouseListener(new MouseMotion());
		panel.add(slider);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				r = slider.getValue();
				repaint();
			}
		});

		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("Task7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class MyPanel extends JPanel {
		private static final long serialVersionUID = -6302911398550823044L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(x - r/2, y - r/2, r,r);
			repaint();

		}

	}

	private class MouseMotion implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		new Task7();

	}

}