package core;

public abstract class EventObserver {
	
	protected Unit actor;
	
	public EventObserver(Unit actor) {
		this.actor = actor;
	}
	
	public abstract void notified(Unit eventSource);
	
	public Unit getActor() {
		return actor;
	}
	
	
}
