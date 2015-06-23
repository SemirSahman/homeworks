package ba.bitcamp.homeworkRekapitulacijaOOP;

public class Server extends Computer {

private int max;

/**
 * getter
 * 
 * @return max
 */
public int getMax() {
    return max;
}

/**
 * setter
 * 
 * @param max
 *            you want to set
 */
public void setMax(int max) {
    this.max = max;
}

/**
 * Server constructor
 * 
 * @param name
 * @param macAddress
 * @param max
 */
public Server(String name, char[] macAddress, int max) {
    super(name, macAddress);
    this.max = max;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (!super.equals(obj))
        return false;
    if (getClass() != obj.getClass())
        return false;
    Server other = (Server) obj;
    if (max != other.max)
        return false;
    return true;
}

@Override
public String toString() {
    return "Server [max=" + max + "]";
}
}