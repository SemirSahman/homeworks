package ba.bitcamp.homeworkweekend6;

public class Task5 {

	/**
	 * Method for getting power of two numbers
	 * 
	 * @param a
	 *            base
	 * @param b
	 *            exponent
	 * @return - result
	 */
	public static double getPower(double a, double b) {

		if (b % 1 == 0) {

			if (b == 0) {

				return 1;
			}

			if (b > 0) {
				return a * getPower(a, b - 1);
			} else {
				return 1 / (a * getPower(a, -b - 1));
			}

		} else {

			if (b == 0) {

				return 1;
			}

			return Math.pow(a, b);
		}
	}

	public static void main(String[] args) {

		System.out.println(getPower(5, 2));

		System.out.println(Math.pow(5, 2));

	}
}