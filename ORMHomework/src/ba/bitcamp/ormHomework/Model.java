package ba.bitcamp.ormHomework;

/**
 * This is public abstract class Model. It contains String type attribute
 * tableName which we use in methods findByPk and findByAttribute that we use to
 * do specific query.
 * 
 * @author Semir
 *
 */
public abstract class Model {

	private String tableName;

	/**
	 * default constructor
	 * 
	 * @param tableName
	 *            String value of tableName
	 */
	public Model(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * default getter for tableName
	 * 
	 * @return String value of tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * default setter for tableName
	 * 
	 * @param tableName
	 *            new String value we want to set for tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Query for finding one row with inputed primary key
	 * 
	 * @param pk
	 *            Integer type value of primary key
	 * @return String s that represents value of selected row
	 */
	public String findByPk(Integer pk) {

		String s = "select * from " + tableName + " where id = " + pk;
		return s;

	}

	/**
	 * Query for finding attribute inputed value
	 * 
	 * @param a1
	 *            attribute we want to find
	 * @param a2
	 *            value of attribute we want to find
	 * @return String s that represents value of selected attribute
	 */
	public String findByAttribute(String a1, String a2) {

		String s = "select * from " + tableName + " where " + a1 + " = " + a2;
		return s;

	}

	/**
	 * toString method, returns tableName
	 */
	@Override
	public String toString() {
		return "Model [tableName=" + tableName + "]";
	}

}