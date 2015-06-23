package ba.bitcamp.homework.weekeend5;
public class Event {

	public static final int DEFEAT = 0;
	public static final int FRIENDSHIP = 1;
	public static final int LOVE = 2;
	public static final int REVENGE = 3;
	public static final int MANIPULATION = 4;

	private int events;

	public int getEvents() {
		return events;
	}

	public void setEvents(int events) {
		this.events = events;
	}

	public Event(int events) {
		super();
		this.events = events;
	}

	@Override
	public String toString() {

		String l = "";
		if (events == DEFEAT) {
			l += "Event is defeat";
		} else if (events == FRIENDSHIP) {
			l += "Events is friendship";
		} else if (events == LOVE) {
			l += "Events is love";
		} else if (events == REVENGE) {
			l += "Events is revenge";
		} else if (events == MANIPULATION) {
			l += "Events is manipulaton";
		}

		return l;

	}

}
