package ba.bitcamp.weekendHomework23;

import javax.swing.JFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = -146154245014238410L;

	public Main() {

		FileFinder panel = new FileFinder();

		add(panel);

		setSize(1080, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("File Finder");
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Main();
	}

}
