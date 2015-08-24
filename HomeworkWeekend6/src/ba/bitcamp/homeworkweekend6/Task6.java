package ba.bitcamp.homeworkweekend6;

public class Task6 {

	public static void fillArray(int[][] matrix, int num1, int num2, int num3) {

		if (num1 == matrix.length) {

			return;
		}
		if (num2 == matrix[num1].length - 1) {
			matrix[num1][num2] = num3;
			fillArray(matrix, num1 + 1, 0, num3 + 1);

		} else {
			matrix[num1][num2] = num3;
			fillArray(matrix, num1, num2 + 1, num3 + 1);
		}

	}

	public static void fillArray(int[][] matrix) {

		fillArray(matrix, 0, 0, 0);
	}

	public static void main(String[] args) {

		int[][] matrix = new int[5][5];
		fillArray(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();

		}
	}

}