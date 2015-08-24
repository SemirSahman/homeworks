package ba.bitcamp.weekendHomework26.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class HTTPServer starts Server class that receives image from client, when
 * image is received HTTPServer is opened and picture is shown.
 * 
 * @author semir
 *
 */
public class HTTPServer {

	private static final int PORT = 8000;

	public static void main(String[] args) {

		Server s = new Server();
		s.runServer();

		try {
			ServerSocket httpServer = new ServerSocket(PORT);
			while (true) {
				Socket client = httpServer.accept();

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

				String pageForClient = "";
				String address = "src/index.html";
				BufferedReader readHTMLFile = new BufferedReader(
						new FileReader(address));

				while (readHTMLFile.ready()) {
					pageForClient += readHTMLFile.readLine();
				}

				pageForClient += "<img src=" + "\"" + s.getFilename()
						+ ".jpg\" /> </body> </html>";

				writer.write(pageForClient);
				writer.close();
				client.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}