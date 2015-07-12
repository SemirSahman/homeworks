package ba.bitcamp.homeworkEventHandler.Task6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Task6 extends JPanel {

	private static final long serialVersionUID = 487846291094190881L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private static final int CIRCLE = 70;

	private static KeyListener keyHandler;

	private int x;
	private int y;

	public Task6() {

		x = Task6.WIDTH / 2;
		y = Task6.HEIGHT / 2;
		keyHandler = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x < Task6.WIDTH - Task6.CIRCLE / 2) {
						x += 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x > 0 + Task6.CIRCLE / 2) {
						x -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y > 0 + Task6.CIRCLE / 2) {
						y -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y < Task6.HEIGHT - Task6.CIRCLE / 2) {
						y += 5;
						repaint();
					}
				}

			}
		};

		addKeyListener(keyHandler);
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillOval(x - Task6.CIRCLE / 2, y - Task6.CIRCLE / 2, Task6.CIRCLE,
				Task6.CIRCLE);
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		JFrame window = new JFrame();
		window.setContentPane(new Task6());
		window.setTitle("Task 6");
		window.setSize(Task6.WIDTH + 15, Task6.HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}