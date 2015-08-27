package ba.bitcamp.ormHomework;

public class ModelExtended extends Model {

	public ModelExtended(String tableName) {
		super(tableName);
		// TODO Auto-generated constructor stub
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


}
