package ba.bitcamp.homeworkBasicComponents;

import javax.swing.JOptionPane;

public class Task4 {

	private static final long serialVersionUID = -8784485429337308942L;

	public static void main(String[] args) {
		int sum = 0;
		int a;
		boolean isTrue = true;
		try {
			a = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));
			sum += a;
			try {
				do {
					int choice = JOptionPane.showConfirmDialog(null,
							"Do you want to enter another number ?");

					if (choice == JOptionPane.YES_OPTION) {
						a = Integer.parseInt(JOptionPane
								.showInputDialog("Enter a number"));
						sum += a;
						isTrue = true;
					} else if (choice == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Result: " + sum);
						isTrue = false;
					} else if (choice == JOptionPane.CANCEL_OPTION) {
						System.exit(0);
					}
				} while (isTrue == true);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Result: " + sum);

			}
		} catch (NumberFormatException e) {
			System.exit(0);
		}
	}
}