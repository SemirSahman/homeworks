package ba.bitcamp.homework24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

/**
 * Public class Server opens a server at port 8888 that listens for client
 * input. It is known that input will be represented in string name, followed by
 * string address.
 * <p>
 * Address must be valid (valid address is address from BITCamp network :)) and
 * address can't be repeated.
 * <p>
 * All the data is saved in <tt>HashMap</tt>, then when client terminates their
 * program data from map is written into a file "forhttp.txt".
 * <p>
 * That data is then used to create web page with links and names.
 * 
 * @author semir
 *
 */
public class Server {

	protected static final int PORT = 1946;

	public static void main(String[] args) {

		LinkedList<String> addresses = new LinkedList<>();
		BufferedWriter fileWriter = null;

		try {
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("Waiting for a client...");

			Socket client = server.accept();
			System.out.println("Client is connected");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));

			fileWriter = new BufferedWriter(new FileWriter("src/forhttp.txt"));

			String name = "";
			String link = "";

			while (client.isConnected()) {
				name = reader.readLine();
				link = reader.readLine();

				if (netIsAvailable(link) && !addresses.contains(link)) {
					addresses.add(link);
					fileWriter.write(link + " " + name);
					fileWriter.newLine();
					fileWriter.flush();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if given URL link is valid.
	 * 
	 * @param url
	 *            <code>String</code> type value of URL address
	 * @return <code>boolean</code> type value true if link is valid, false if
	 *         not
	 */
	private static boolean netIsAvailable(String link) {
		try {
			URL url = new URL(link);
			url.toURI();
			URLConnection conn = url.openConnection();
			conn.connect();
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		} catch (URISyntaxException e) {
			return false;
		}
		return true;
	}

}