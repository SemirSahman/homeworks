package ba.bitcamp.homeworkRekapitulacijaOOP;

public abstract class Network {

private String networkName;
private Computer[] compArr;

/**
 * Network constructor
 * 
 * @param networkName
 */
public Network(String networkName) {
    super();
    this.networkName = networkName;
    this.compArr = new Computer[0];
}

/**
 * This method adds computer
 * 
 * @param c
 *            computer you want to add
 */
public abstract void addComputer(Computer c);

/**
 * This method removes computer
 * 
 * @param c
 *            computer you want to remove
 */
public abstract void removeComputer(Computer c);

public String getNetworkName() {
    return networkName;
}

public void setNetworkName(String networkName) {
    this.networkName = networkName;
}

public Computer[] getCompArr() {
    return compArr;
}

public void setCompArr(Computer[] compArr) {
    this.compArr = compArr;
}
}