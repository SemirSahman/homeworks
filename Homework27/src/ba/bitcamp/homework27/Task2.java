package ba.bitcamp.homework27;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class loads picture from computer and then renders it into negativ. This
 * class uses threads to improve efficiency and speed of program
 * 
 * @author Semir
 *
 */
public class Task2 extends JFrame {

	private static final long serialVersionUID = 4809338752402490908L;

	JPanel panel;
	static BufferedImage image = null;
/**
 * Default constructor
 */
	public Task2() {
		try {
			image = ImageIO.read(new File("src/Sarajevo-sampion2015.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel = new MyPanel();
		add(panel);

		setTitle("Task2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1920, 1277);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		Thread t = new Thread(new MyThread());
		t.start();
	}
/**
 * Inner class, extends JPanel, loads image with implemented paintComponent method
 * @author Semir
 *
 */
	public class MyPanel extends JPanel {

		private static final long serialVersionUID = -4935293059853791132L;

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
		}

	}
/**
 * Worker thread that renders image to negative
 * @author Semir
 *
 */
	class MyThread implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < image.getWidth(); i++) {
				for (int j = 0; j < image.getHeight(); j++) {
					int pixel = image.getRGB(i, j);
					image.setRGB(i, j, 255 - pixel);
					repaint();

				}
			}
		}

	}
/**
 * Main method that starts the program
 * @param args
 */
	public static void main(String[] args) {

		new Task2();
	}

}