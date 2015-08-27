package ba.bitcamp.homework28.tasks.task1;

import java.util.Calendar;

/**
 * Class that represents complaint and all its attributes
 * 
 * @author Semir
 *
 */
public class Complaint {

	private Integer id;
	private Calendar time;
	private String message;

	/**
	 * @param id
	 * @param time
	 * @param message
	 */
	public Complaint(Integer id, Calendar time, String message) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
	}

	/**
	 * @param time
	 * @param message
	 */
	public Complaint(Calendar time, String message) {
		super();
		this.message = message;
		this.time = time;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the time of the complaint
	 */
	public String getTime() {
		return time.get(Calendar.HOUR_OF_DAY) + " : "
				+ time.get(Calendar.MINUTE);
	}

	/**
	 * @return the date of the complaint
	 */
	public String getDate() {
		return time.get(Calendar.DAY_OF_MONTH) + " : "
				+ time.get(Calendar.MONTH) + "-" + time.get(Calendar.YEAR);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}