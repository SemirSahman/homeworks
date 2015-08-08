package ba.bitcamp.homework27;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class that counts how many times first letter of first row repeats to the end
 * of text
 * 
 * @author Semir
 *
 */
public class Task1 {

	private char firstChar;
	private static Integer counter = 1;
	private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	private ArrayList<Producer> producers = new ArrayList<Producer>();
	private BufferedReader reader;

	/**
	 * Default constructor
	 * 
	 * @param filePath
	 *            A path that leads us to txt file
	 */
	public Task1(String filePath) {
		super();
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath)));
			firstChar = (char) reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Worker threads
	 * 
	 * @author Semir
	 *
	 */
	private class Worker implements Runnable {

		String line;

		public Worker(String line) {
			this.line = line;
		}

		@Override
		public void run() {
			char tmp = ' ';
			if (Character.isAlphabetic(firstChar)) {
				if (Character.isLowerCase(firstChar)) {
					tmp = Character.toUpperCase(firstChar);
				} else {
					tmp = Character.toLowerCase(firstChar);
				}
			} else {
				tmp = firstChar;
			}
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == firstChar || line.charAt(i) == tmp) {
					synchronized (counter) {
						counter++;
					}
				}
			}
		}
	}

	/**
	 * Task threads
	 * 
	 * @author Semir
	 *
	 */
	private class Producer extends Thread {

		@Override
		public void run() {
			while (!queue.isEmpty()) {
				try {
					queue.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Counts repetitions of first letter in file and prints results
	 */
	public void countRepetitions() {

		try {
			while (reader.ready()) {
				queue.add(new Worker(reader.readLine()));
			}

			for (int i = 0; i < 8; i++) {
				Producer p = new Producer();
				p.start();
				producers.add(p);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < producers.size(); i++) {
			try {
				producers.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Character -" + firstChar + "- repeats: " + counter
				+ " [times]");

	}

	public static void main(String[] args) {
		Task1 lif = new Task1("src/text.txt");
		lif.countRepetitions();
	}
}