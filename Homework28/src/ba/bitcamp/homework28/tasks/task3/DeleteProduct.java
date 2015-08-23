package ba.bitcamp.homework28.tasks.task3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import ba.bitcamp.homework28.tasks.task2.Product;

/**
 * Application that deletes products from database.
 * 
 * @author Semir
 *
 */
public class DeleteProduct extends JFrame {

	private static final long serialVersionUID = -3433958654016736291L;

	private JList<String> lstProducts;
	private JButton delete = new JButton("Delete");
	private ArrayList<Product> listOfProducts = new ArrayList<Product>();

	private Connection conn;

	/**
	 * Default constructor.
	 */
	public DeleteProduct() {

		setLayout(new BorderLayout());

		connToDB();

		delete.addActionListener(new Action());

		getProducts();

		setList();

		add(lstProducts);
		add(delete, BorderLayout.SOUTH);

		setTitle("Insert product");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setList() {

		String[] tmp = new String[listOfProducts.size()];
		for (int i = 0; i < listOfProducts.size(); i++) {
			tmp[i] = listOfProducts.get(i).toString();
		}

		if (lstProducts != null)
			remove(lstProducts);

		lstProducts = new JList<String>(tmp);
		add(lstProducts);
		setVisible(true);

	}

	private void getProducts() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM product");

			while (result.next()) {

				String id = result.getString(1);
				String name = result.getString(2);
				String price = result.getString(3);

				Product p = new Product(id, name, new BigDecimal(price));

				listOfProducts.add(p);
			}
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (lstProducts.getSelectedIndex() == -1)
				return;
			deleteFromDB(listOfProducts.get(lstProducts.getSelectedIndex())
					.getId());
			listOfProducts.remove(lstProducts.getSelectedIndex());
			setList();
		}

	}

	private void deleteFromDB(String id) {
		try {

			Statement statement = conn.createStatement();

			String c = "DELETE FROM product WHERE id = " + id;

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
		new DeleteProduct();
	}

}
