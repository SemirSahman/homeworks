package ba.bitcamp.homework28.tasks.task1;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * This class lists all complaints from database
 * 
 * @author Semir
 *
 */
public class ListComplaints extends JFrame {

	private static final long serialVersionUID = -1197821765306834296L;

	private Connection conn;

	private JTextArea txtComplaints = new JTextArea();

	private ArrayList<Complaint> list = new ArrayList<Complaint>();

	/**
	 * Default constructor.
	 */
	public ListComplaints() {

		setLayout(new BorderLayout());

		connToDB();

		getComplaints();

		setTextArea();

		txtComplaints.setEditable(false);
		add(txtComplaints);

		setTitle("List of complaints");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
	}

	private void getComplaints() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("SELECT * FROM complaint");

			while (result.next()) {

				int id = result.getInt(1);
				String msg = result.getString(2);
				String date = result.getString(3);
				String time = result.getString(4);

				int day = Integer.parseInt(date.split("-")[2]);
				int month = Integer.parseInt(date.split("-")[1]);
				int year = Integer.parseInt(date.split("-")[0]);
				int hour = Integer.parseInt(time.split("-")[0]);
				int min = Integer.parseInt(time.split("-")[1]);
				Calendar cal = new GregorianCalendar(year, month, day, hour,
						min);

				Complaint c = new Complaint(id, cal, msg);

				list.add(c);
			}
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
	}

	private void setTextArea() {
		for (Complaint c : list) {
			String line = c.getId() + " - " + c.getMessage() + " - "
					+ c.getTime() + " " + c.getDate() + "\n";
			txtComplaints.setText(txtComplaints.getText() + line);
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
		new ListComplaints();
	}

}
