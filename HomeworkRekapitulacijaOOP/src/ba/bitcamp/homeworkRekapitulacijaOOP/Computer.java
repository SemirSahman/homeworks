package ba.bitcamp.homeworkRekapitulacijaOOP;

public abstract class Computer {

private String name;
private MACAddress macAddress;

/**
 * Computer class constructor
 * 
 * @param name
 *            Computer name
 * @param macAddress
 *            Mac address
 */
public Computer(String name, char[] macAddress) {
    super();
    this.name = name;
    this.macAddress = new MACAddress(macAddress);
}

/**
 * Constructor
 */
public Computer() {
    super();
    this.name = "Computer";

    char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b' };
    this.macAddress = new MACAddress(arr);
}

@Override
public String toString() {
    return "Computer [name=" + name + ", macAddress=" + macAddress + "]";
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Computer other = (Computer) obj;
    if (macAddress == null) {
        if (other.macAddress != null)
            return false;
    } else if (!macAddress.equals(other.macAddress))
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    return true;
}

/**
 * getter
 * 
 * @return name
 */
public String getName() {
    return name;
}

/**
 * setter
 * 
 * @param name
 *            you want to set
 */
public void setName(String name) {
    this.name = name;
}

/**
 * getter
 * 
 * @return Mac address
 */
public MACAddress getMacAddress() {
    return macAddress;
}

/**
 * setter
 * 
 * @param macAddress
 *            you want to set
 */
public void setMacAddress(MACAddress macAddress) {
    this.macAddress = macAddress;
}

// inner class
public class MACAddress {

    char[] address; // 0123456789ab

    public MACAddress(char[] address) {
        this.address = address;
    }

    @Override
    // 01:23:45:67:89:ab
    public String toString() {
        String s = "";
        for (int i = 0; i < address.length; i++) {
            if (i % 2 == 0 && i != 0) {
                s += ":";
            }
            s += address[i];
        }

        return s;

    }

}
}