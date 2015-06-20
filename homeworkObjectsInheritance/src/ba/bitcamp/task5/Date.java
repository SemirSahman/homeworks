package ba.bitcamp.task5;

/**
 * Class representing dates.
 * @author Semir
 *
 */
public class Date {

	private int day;
	private int month;
	private int year;
	
	/**
	 * @param day A day
	 */
	public Date(int day) {
		this(day, 1, 1);
	}

	/**
	 * @param day A day
	 * @param month A month
	 */
	public Date(int day, int month) {
		this(day, month, 1);
	}

	/**
	 * @param day A day 
	 * @param month A month
	 * @param year A year
	 * @throws IllegalArgumentException When illegal date is given
	 */
	public Date(int day, int month, int year) throws IllegalArgumentException{
		super();
		if (year < 1 || month < 1 || month > 12 || day < 1){
			throw new IllegalArgumentException();
		}
		if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
			throw new IllegalArgumentException();						
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
			throw new IllegalArgumentException();						
		} else if (((year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) && day > 29){
			throw new IllegalArgumentException();									
		} else if(month == 2 && day > 28){
			throw new IllegalArgumentException();												
		}
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * @param day The day to set
	 * @throws IllegalArgumentException When illegal date is given
	 */
	public void setDay(int day) throws IllegalArgumentException {
		if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
			throw new IllegalArgumentException();						
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
			throw new IllegalArgumentException();						
		} else if (((year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) && day > 29){
			throw new IllegalArgumentException();									
		} else if(month == 2 && day > 28){
			throw new IllegalArgumentException();												
		}
		this.day = day;
	}

	/**
	 * @param month The month to set
	 * @throws IllegalArgumentException When illegal date is given
	 */
	public void setMonth(int month) throws IllegalArgumentException {
		if(month < 1 || month > 12){
			throw new IllegalArgumentException();
		}
		this.month = month;
	}

	/**
	 * @param year The year to set
	 * @throws IllegalArgumentException When illegal date is given
	 */
	public void setYear(int year) throws IllegalArgumentException {
		if(year < 1){
			throw new IllegalArgumentException();
		}
		this.year = year;
	}
	
	/**
	 * Changes the date to one day later.
	 */
	public void dayPassed(){
		try {
			setDay(day + 1);
		} catch (IllegalArgumentException e) {
			setDay(1);
			monthPassed();
		}
	}
	
	/**
	 * Changes the date to one month later.
	 */
	public void monthPassed(){
		try {
			setMonth(month + 1);
		} catch (IllegalArgumentException e) {
			setMonth(1);
			setYear(year + 1);
		}
	}
	
	/**
	 * Returns String representation of the date in format DD.MM.YYYY.
	 */
	@Override
	public String toString() {
		return String.format("%02d.%02d.%04d.", day, month, year);
	}
}