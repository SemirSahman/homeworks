package ba.bitcamp.weekendHomework26.task2;

import java.util.Random;

/**
 * Class ThreeThreads have three threads that do specific task for specific
 * amount of time. Each threads starts when previous finishes their task.
 * 
 * One inner static class is used for all three threads.
 * 
 * @author semir
 *
 */
public class ThreeThreads {

	private static final int PRINT_NUMBERS = 0;
	private static final int PRINT_BITCAMP = 1;
	private static final int PRINT_RANDOM_NUM = 2;

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread(PRINT_NUMBERS));
		Thread t2 = new Thread(new MyThread(PRINT_BITCAMP));
		Thread t3 = new Thread(new MyThread(PRINT_RANDOM_NUM));

		try {
			System.out.println("Thread one starts!");
			t1.start();
			t1.join();
			System.out.println();
			System.out.println("Thread two starts!");
			t2.start();
			t2.join();
			System.out.println();
			System.out.println("Thread three starts!");
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Inner static class MyThread receives option for mission in it's
	 * constructor.
	 *
	 */
	private static class MyThread implements Runnable {

		private int option;

		public MyThread(int option) {
			this.option = option;
		}

		@Override
		public void run() {
			try {
				if (option == PRINT_NUMBERS) {
					for (int i = 1; i <= 10; i++) {
						System.out.print(i + " ");
						Thread.sleep(200);
					}
				} else if (option == PRINT_BITCAMP) {
					for (int i = 0; i < 4; i++) {
						System.out.print("BitCamp ");
						Thread.sleep(1000);
					}
				} else if (option == PRINT_RANDOM_NUM) {
					Random rand = new Random();
					for (int i = 0; i < 5; i++) {
						System.out.print((rand.nextInt(5) + 1) + " ");
						Thread.sleep(700);
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}