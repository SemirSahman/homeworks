package ba.bitcamp.homeworkRekapitulacijaOOP;

public class Client extends Computer implements Connectable {

private Computer compConnected;
private Network netConnected;

/**
 * this method connects client to computer
 */
@Override
public void connect(Computer c) {
    if (compConnected == null && netConnected == null) {
        compConnected = c;

    } else {
        throw new NullPointerException("Can't connect");
    }

}

/**
 * this method connects client to network
 */
@Override
public void connect(Network n) {
    if (compConnected == null && netConnected == null) {
        netConnected = n;

    } else {
        throw new NullPointerException("Can't connect");
    }

}

/**
 * this method disconnects client from computer and network
 */
@Override
public void disconnect() {
    compConnected = null;
    netConnected = null;

}

/**
 * Client constructor
 * 
 * @param name
 * @param macAddress
 */
public Client(String name, char[] macAddress) {
    super(name, macAddress);

}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (!super.equals(obj))
        return false;
    if (getClass() != obj.getClass())
        return false;
    Client other = (Client) obj;
    if (compConnected == null) {
        if (other.compConnected != null)
            return false;
    } else if (!compConnected.equals(other.compConnected))
        return false;
    if (netConnected == null) {
        if (other.netConnected != null)
            return false;
    } else if (!netConnected.equals(other.netConnected))
        return false;
    return true;
}

@Override
public String toString() {
    return "Client [compConnected=" + compConnected + ", netConnected="
            + netConnected + "]";
}

/**
 * getter
 * 
 * @return compConnected link
 */
public Computer getCompConnected() {
    return compConnected;
}

/**
 * setter
 * 
 * @param compConnected
 *            link
 */
public void setCompConnected(Computer compConnected) {
    this.compConnected = compConnected;
}

/**
 * getter
 * 
 * @return netConnected link
 */
public Network getNetConnected() {
    return netConnected;
}

/**
 * setter
 * 
 * @param netConnected
 *            link
 */
public void setNetConnected(Network netConnected) {
    this.netConnected = netConnected;
}
}
