package ba.bitcamp.homeworkEventHandler.Task3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Task3 extends JPanel {

	private static final long serialVersionUID = -6345199158290382484L;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private static final int CIRCLE = 70;

	private int x;
	private int y;

	public Task3() {

		x = Task3.WIDTH / 2;
		y = Task3.HEIGHT / 2;
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x < Task3.WIDTH - Task3.CIRCLE / 2) {
						x += 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x > 0 + Task3.CIRCLE / 2) {
						x -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y > 0 + Task3.CIRCLE / 2) {
						y -= 5;
						repaint();
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y < Task3.HEIGHT - Task3.CIRCLE / 2) {
						y += 5;
						repaint();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		setFocusable(true);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillOval(x - Task3.CIRCLE / 2, y - Task3.CIRCLE / 2, Task3.CIRCLE,
				Task3.CIRCLE);
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
		window.setContentPane(new Task3());
		window.setTitle("Task 3");
		window.setSize(Task3.WIDTH + 15, Task3.HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}