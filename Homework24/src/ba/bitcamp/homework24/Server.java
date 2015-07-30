package ba.bitcamp.homework24;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class extends JFrame and have one ServerSocket and one Socket needed for
 * client to connect. Class uses GUI to enter, send and receive messages(to
 * chat). Client can ask server to do certain action such as open web page, or
 * file on computer, or to delete file on computer and to list all the files in
 * specific directory.
 * 
 * @author semir
 *
 */
public class Server extends JFrame {

	private static final long serialVersionUID = -1079588191731290181L;

	protected static final int PORT = 1946;

	private static ServerSocket server;
	private static Socket client;

	private JPanel panel = new JPanel();
	private JTextArea conversation = new JTextArea();
	private JTextField message = new JTextField(25);
	private JButton button = new JButton("Send");
	private JScrollPane scroll = new JScrollPane(conversation);

	/**
	 * Default constructor of Server class.Starts GUI application, open's server
	 * connection and waits for incoming messages to read from input stream.
	 */
	public Server() {
		startGUI();
		connectToClient();
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
		panel.add(button);

		message.addKeyListener(new Action());
		button.addActionListener(new Action());

		setTitle("Server chat");
		setResizable(false);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Starts the server and waits for client to connect.
	 */
	private void connectToClient() {
		try {
			server = new ServerSocket(1946);
			client = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Depending on message client is sending, server responds with certain
	 * action.
	 * <p>
	 * Message is splited at first space only and if first word is /open file
	 * will be opened if exist on given location.
	 * <p>
	 * If first word is /web a web page will be opened.
	 * <p>
	 * If first word is /delete inputed file will be deleted.
	 * <p>
	 * If first word is /list client will receive a message with list of files
	 * at given folder path.
	 * 
	 * @param message
	 *            <code>String</code> type value of message client is sending.
	 * @exception FileNotFoundException
	 * @exception IOException
	 * @exception ArrayIndexOutOfBoundsException
	 * @exception URISyntaxException
	 */
	private void actionTypes(String message) {
		try {
			String[] s = message.split(" ", 2);
			File file = new File(s[1]);
			if (s[0].equals("/open")) {
				Desktop.getDesktop().open(file);
			} else if (s[0].equals("/web")) {
				Desktop.getDesktop().browse(new URL("http://" + s[1]).toURI());
			} else if (s[0].equals("/delete")) {
				file.delete();
			} else if (s[0].equals("/list")) {
				String[] list = file.list();
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));
				writer.write("Files: " + file);
				writer.newLine();
				for (String files : list) {
					writer.write(files);
					writer.newLine();
				}
				writer.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Private method used to receive message
	 */
	private void recieveMessage() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			while (true) {
				String msg = reader.readLine();
				conversation.append("Client: " + msg + "\n");
				actionTypes(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Private inner class extends Abstract class KeyAdapter and implements
	 * needed method. Also ActionListener interface is implemented to handle
	 * button action.
	 */
	private class Action extends KeyAdapter implements ActionListener {

		/**
		 * Implemented method that handles button action, message is send when
		 * button is pressed.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
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
		 * and sent to client through output stream. Message is also added to
		 * server text area.
		 */
		private void sendMessage() {
			String msg = message.getText();
			try {
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

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

		new Server();

	}

}