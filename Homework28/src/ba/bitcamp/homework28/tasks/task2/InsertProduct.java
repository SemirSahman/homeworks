package ba.bitcamp.homework28.tasks.task2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Application that inserts products into database.
 * 
 * @author Semir
 *
 */
public class InsertProduct extends JFrame {

	private static final long serialVersionUID = 7473438210758999548L;

	private JLabel lblName = new JLabel("Name:");
	private JTextField txtName = new JTextField();
	private JLabel lblPrice = new JLabel("Price:");
	private JTextField txtPrice = new JTextField();
	private JLabel lblId = new JLabel("Code:");
	private JTextField txtId = new JTextField();
	private JPanel pnlCenter = new JPanel();
	private JButton submit = new JButton("Submit");

	private Connection conn;

	/**
	 * Default constructor.
	 */
	public InsertProduct() {

		setLayout(new BorderLayout());
		pnlCenter.setLayout(new GridLayout(3, 2));

		connToDB();

		submit.addActionListener(new Action());

		pnlCenter.add(lblId);
		pnlCenter.add(txtId);
		pnlCenter.add(lblName);
		pnlCenter.add(txtName);
		pnlCenter.add(lblPrice);
		pnlCenter.add(txtPrice);

		add(pnlCenter);
		add(submit, BorderLayout.SOUTH);

		setTitle("Insert product");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			insertValue();

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				insertValue();
			}
		}
	}

	private void insertValue() {
		try {
			String id = txtId.getText();
			if (id.length() != 10) {
				JOptionPane.showMessageDialog(null,
						"Incorrect code: There must be 10 digits in id");
				return;
			}
			for (char c : id.toCharArray()) {
				if (!Character.isDigit(c)) {
					JOptionPane.showMessageDialog(null,
							"Incorrect code: All characters must be digits");
					return;
				}
			}
			if (codeExists(id)) {
				JOptionPane.showMessageDialog(null,
						"Incorrect code: Code already exists");
				return;
			}
			String name = txtName.getText();
			if (nameExists(name)) {
				int option = JOptionPane
						.showConfirmDialog(null,
								"Name already exists. Do you want do set another name?");
				if (option == JOptionPane.YES_OPTION)
					return;
			}
			BigDecimal price = null;
			try {
				price = new BigDecimal(txtPrice.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Incorrect price");
				return;
			}
			Product p = new Product(id, name, price);
			txtId.setText("");
			txtName.setText("");
			txtPrice.setText("");

			Statement statement = conn.createStatement();

			String c = "INSERT INTO product VALUES(" + p.getId() + ", '"
					+ p.getName() + "', '" + p.getPrice() + "')";

			statement.executeUpdate(c);
		} catch (SQLException e) {
			System.out.println("Bad SQL Command.");
			System.out.println("Continuing on.");
		}
	}

	private boolean nameExists(String name) {
		try {
			Statement statement = conn.createStatement();
			String c = "SELECT * FROM product WHERE name = '" + name + "'";
			ResultSet result = statement.executeQuery(c);
			if (result.next())
				return true;

		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		return false;
	}

	private boolean codeExists(String id) {
		try {
			Statement statement = conn.createStatement();
			String c = "SELECT * FROM product WHERE id = " + id;
			ResultSet result = statement.executeQuery(c);
			if (result.next())
				return true;

		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		return false;
	}

	private void connToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");

			conn = DriverManager.getConnection("jdbc:sqlite:SQLite/product.db");
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
		new InsertProduct();
	}

}