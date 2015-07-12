package ba.bitcamp.homeworkEventHandler.Task4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Task4 extends JFrame {

	private static final long serialVersionUID = -6021839215884339785L;

	private JPanel panel = new MyPanel();

	private int x = 20;
	private int y = 20;

	private static final int RIGHT = 5;
	private static final int LEFT = -5;
	private static final int UP = -5;
	private static final int DOWN = 5;

	public Task4() {

		add(panel);

		addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x < getWidth() - 75) {
						x += RIGHT;
					}

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x > 5) {
						x += LEFT;
					}

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y > 15) {
						y += UP;
					}

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y < getHeight() - 95) {
						y += DOWN;
					}
				}
				panel.repaint();
			}
		});

		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 4");
		setVisible(true);
	}

	public static void main(String[] args) {

		new Task4();
	}

	private class MyPanel extends JPanel {

		private static final long serialVersionUID = -1214772869247474779L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.CYAN);
			g.fillOval(x, y, 50, 50);
		}
	}

}