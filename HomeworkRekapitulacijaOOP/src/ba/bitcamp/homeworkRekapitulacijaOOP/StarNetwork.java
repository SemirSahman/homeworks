package ba.bitcamp.homeworkRekapitulacijaOOP;

public class StarNetwork extends BusNetwork implements Functionable {

	private Server server;

	/**
	 * @param name Network`s name
	 * @param server A server
	 */
	public StarNetwork(String name, Server server) {
		super(name);
		this.server = server;
	}
	
	@Override
	public boolean isFunctioning() throws IllegalArgumentException {
		int counter = 0;
		for (int i = 0; i < getCompArr().length; i++) {
			if(getCompArr()[i] instanceof Client){
				Client c = (Client) getCompArr()[i];
				if(c.getNetConnected() != null){
					counter++;
				}
			}
		}
		if(counter > server.getMax())
			return false;
		else
			return true;
	}

	@Override
	public boolean isFunctionable() {
		// TODO Auto-generated method stub
		return false;
	}
}