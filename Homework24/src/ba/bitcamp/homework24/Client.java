package ba.bitcamp.homework24;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class extends JFrame and have one Socket for connecting to server. GUI
 * app starts as soon as main method is called. When client connects to server,
 * client and server can have chat through GUI app. Client can ask server to do
 * certain action such as open web page, or file on computer, or to delete file
 * on computer and to list all the files in specific directory. If asked, client
 * will receive a list of files in certain folder location.
 * 
 * @author semir
 *
 */
public class Client extends JFrame {

	private static final long serialVersionUID = -3802247418983639172L;

	private static final String HOST = "127.0.0.8";

	private static Socket connect;

	private JPanel panel = new JPanel();
	private JTextArea conversation = new JTextArea();
	private JTextField message = new JTextField(25);
	private JScrollPane scroll = new JScrollPane(conversation);
	private JButton send = new JButton("Send");

	/**
	 * Default constructor of Client class. Starts GUI application, open's
	 * server connection and waits for incoming messages to read from input
	 * stream.
	 */
	public Client() {
		startGUI();
		connectToServer();
		recieveMessage();
	}

	/**
	 * Method that setups GUI app. Adds all components and action listener to
	 * "Send" button and adds keyboard listener to text field. User can send
	 * message by pressing enter button.
	 */
	private void startGUI() {
		setLayout(new BorderLayout());

		conversation.setEditable(false);
		add(scroll, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.add(message);
		panel.add(send);

		message.addKeyListener(new Action());
		send.addActionListener(new Action());

		setTitle("Client chat");
		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Connect to server using host address and server port.
	 */
	private void connectToServer() {
		try {
			connect = new Socket(HOST, Server.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Private method used to receive message
	 */
	private void recieveMessage() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connect.getInputStream()));

			while (true) {
				String msg = reader.readLine();
				conversation.append("Server: " + msg + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Private inner class extends Abstract class KeyAdapter and implements
	 * needed method. Also ActionListener interface is implemented to handle
	 * button action.
	 *
	 */
	private class Action extends KeyAdapter implements ActionListener {

		/**
		 * Implemented method that handles button action, message is sent when
		 * button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == send) {
				sendMessage();
			}
		}

		/**
		 * Implemented method that handles keyboard action, message is sent when
		 * enter key is pressed.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				sendMessage();
			}
		}

		/**
		 * Method that sends message to client. Message is read from text field
		 * and send to client through output stream. Message is also added to
		 * server text area.
		 */
		private void sendMessage() {
			String msg = message.getText();
			try {
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(connect.getOutputStream()));
				writer.write(msg);
				writer.newLine();
				writer.flush();
				conversation.append("Me: " + msg + "\n");

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			message.setText("");
		}

	}

	/**
	 * main method that starts the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new Client();

	}

}