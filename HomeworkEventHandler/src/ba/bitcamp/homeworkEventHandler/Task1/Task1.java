package ba.bitcamp.homeworkEventHandler.Task1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Task1 extends JPanel {

	private static final long serialVersionUID = 7119975895539072078L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;
	private static final int CIRCLE = 70;

	private static Task1 instance;

	private int x;
	private int y;
	long t;

	public Task1() {

		x = Task1.WIDTH / 2;
		y = Task1.HEIGHT / 2;
		addKeyListener(new KeyHandler());
		;
		setFocusable(true);
		t = System.currentTimeMillis();
		System.out.println(t);
	}

	public static Task1 getInstance() {
		if (instance == null) {
			instance = new Task1();
		}
		return instance;
	}

	public void moveUp() {
		if (y > 0 + Task1.CIRCLE / 2) {
			y -= 5;
			repaint();
		}
	}

	public void moveDown() {
		if (y < Task1.HEIGHT - Task1.CIRCLE / 2) {
			y += 5;
			repaint();
		}
	}

	public void moveRight() {
		if (x > 0 + Task1.CIRCLE / 2) {
			x += 5;
			repaint();
		}
	}

	public void moveLeft() {
		if (x > 0 + Task1.CIRCLE / 2) {
			x -= 5;
			repaint();
		}
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.CYAN);
		g.fillOval(x - Task1.CIRCLE / 2, y - Task1.CIRCLE / 2, Task1.CIRCLE,
				Task1.CIRCLE);
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
		window.setContentPane(Task1.getInstance());
		window.setTitle("Task 1");
		window.setSize(Task1.WIDTH + 15, Task1.HEIGHT + 40);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}