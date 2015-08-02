package ba.bitcamp.weekendHomework26.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Class Client send a file to the server and disconnects.
 * 
 * @author semir
 *
 */
public class Client {

	private static final String HOST = "25.0.0.1";

	public static void main(String[] args) {

		try {
			Socket connectTo = new Socket(HOST, Server.PORT);
			OutputStream sendFile = connectTo.getOutputStream();
			FileInputStream readFile = new FileInputStream(
					"src\485372_10200993875035022_1042838393_n.jpg");

			byte[] buffer = new byte[1024];
			int readSoFar;
			while ((readSoFar = readFile.read(buffer, 0, buffer.length)) > 0) {
				sendFile.write(buffer, 0, readSoFar);
			}

			readFile.close();
			sendFile.close();
			connectTo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}