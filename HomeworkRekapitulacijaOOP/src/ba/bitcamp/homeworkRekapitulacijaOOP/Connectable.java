package ba.bitcamp.homeworkRekapitulacijaOOP;

public interface Connectable { /** * this method connects client to computer * * @param c * computer to which you want to connect */ void connect(Computer c);

/**
 * this method connects client to network
 * 
 * @param n
 *            network to which you want to connect
 */
void connect(Network n);

/**
 * this method disconnects client from computer and network
 */
void disconnect();
}