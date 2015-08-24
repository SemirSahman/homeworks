package ba.bitcamp.homeworkRekapitulacijaOOP;

public class BusNetwork extends Network {
	/**
	 * BusNetwork constructor
	 * 
	 * @param networkName
	 */
	public BusNetwork(String networkName) {
		super(networkName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * this method extends array and then adds computer to it and connects it
	 */
	@Override
	public void addComputer(Computer c) {

		ArrayManipulation.extendArray(getCompArr());
		getCompArr()[getCompArr().length - 1 ] = c;

		if (c instanceof Server) {
			throw new UnsupportedOperationException(
					"Cannot connect servers on this network");
		} else if (c instanceof Client) {
			Client c1 = (Client) c;

			c1.connect(this);
		}

	}

	/**
	 * this method founds computer, removes it and shrink array
	 */
	@Override
	public void removeComputer(Computer c) throws IllegalArgumentException {
		for (int i = 0; i < getCompArr().length; i++) {
			if (c.equals(getCompArr()[i])) {
				setCompArr(ArrayManipulation.shrinkArray(getCompArr(), i));
				if (c instanceof Client) {
					Client cl = (Client) c;
					cl.disconnect();
				} else
					throw new IllegalArgumentException();
				return;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * this method returns true if there are atleast two computers connected to
	 * network else it returns false
	 * 
	 * @return true/false
	 * @throws IllegalArgumentException
	 */
	public boolean isFunctioning() throws IllegalArgumentException {
		int counter = 0;
		for (int i = 0; i < getCompArr().length; i++) {
			if (getCompArr()[i] instanceof Client) {
				Client c = (Client) getCompArr()[i];
				if (c.getNetConnected() != null) {
					counter++;
					if (counter == 2)
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Number of computers: " + getCompArr().length
				+ "\nIs functioning: " + isFunctioning();
	}

}