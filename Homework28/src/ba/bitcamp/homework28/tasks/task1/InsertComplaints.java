package ba.bitcamp.homework28.tasks.task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Application that records customers complaints
 * 
 * @author Semir
 *
 */
public class InsertComplaints extends JFrame {

	private static final long serialVersionUID = -6887761452967088188L;

	private JTextField txtComplaint = new JTextField();
	private JButton submit = new JButton("Submit");

	private Connection conn;

	/**
	 * Default constructor.
	 */
	public InsertComplaints() {

		setLayout(new BorderLayout());

		connToDB();

		txtComplaint.addKeyListener(new Action());
		submit.addActionListener(new Action());

		add(txtComplaint);
		add(submit, BorderLayout.SOUTH);

		setTitle("Insert complaint");
		setSize(500, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			insert();

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				insert();
			}
		}
	}

	private void insert() {
		try {
			Complaint complaint = new Complaint(Calendar.getInstance(),
					txtComplaint.getText());
			txtComplaint.setText("");

			Statement statement = conn.createStatement();

			String c = "INSERT INTO complaint VALUES(" + complaint.getId()
					+ ", '" + complaint.getMessage() + "', '"
					+ complaint.getDate() + "', '" + complaint.getTime() + "')";

			statement.executeUpdate(c);
		} catch (SQLException e) {
			System.out.println("Bad SQL Command.");
			System.out.println("Continuing on.");
		}
	}

	private void connToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");

			conn = DriverManager
					.getConnection("jdbc:sqlite:SQLite/complaint.db");
			System.out.println("Connection established.");
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Could not connect to the database.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

	}

	public static void main(String[] args) {
		new InsertComplaints();
	}

}