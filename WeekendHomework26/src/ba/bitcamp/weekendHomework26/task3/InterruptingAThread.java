package ba.bitcamp.weekendHomework26.task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class InterruptingAThread extends JFrame and have label that shows character
 * from alphabet A-Z every second. If stop button is pressed, alphabet count is
 * stoped.
 * 
 * @author semir
 *
 */
public class InterruptingAThread extends JFrame {

	private static final long serialVersionUID = 4548797620454822953L;

	private static final int STOP = 91;

	private JLabel label = new JLabel();
	private JButton button = new JButton("Stop");
	private Thread t1 = new Thread(new MyThread());

	/**
	 * Default constructor of InterruptingAThread class, shows GUI parts and
	 * starts a thread at the end,
	 */
	public InterruptingAThread() {
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		label.setHorizontalAlignment(NORMAL);
		button.addActionListener(new ButtonAction());

		setTitle("Interrupting a Thread");
		setSize(450, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		t1.start();
	}

	/**
	 * Private inner class MyThread implements Runnable interface. In it's run
	 * method label receives letter from alphabet every second. If thread is
	 * interrupted label stops receiving letters but program continues to run.
	 */
	private class MyThread implements Runnable {

		@Override
		public void run() {
			for (int i = 65; i <= 90; i++) {
				label.setText(label.getText() + (char) i + " ");
				try {
					t1.sleep(1000);
				} catch (InterruptedException e) {
					i = STOP;
				}
			}
		}
	}

	/**
	 * Private inner class ButtonAction handles action when button pressed. If
	 * button is pressed thread that writes letters on label is killed.
	 */
	private class ButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				t1.interrupt();
			}
		}

	}

	/**
	 * main method that starts the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new InterruptingAThread();
	}
}