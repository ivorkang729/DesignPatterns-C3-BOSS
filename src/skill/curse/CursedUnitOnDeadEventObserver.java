package skill.curse;

import core.EventObserver;
import core.Unit;

public class CursedUnitOnDeadEventObserver extends EventObserver {

	public CursedUnitOnDeadEventObserver(Unit actor) {
		super(actor);
	}

	@Override
	public void notified(Unit eventSource) {
		if (!eventSource.isAlive() && actor.isAlive()) {
			actor.heal(eventSource.getMp());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getClass().getName().hashCode());
		result = prime * result + ((actor == null) ? 0 : actor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventObserver other = (EventObserver) obj;
		if (actor == null) {
			if (other.getActor() != null)
				return false;
		} else if (!actor.equals(other.getActor()))
			return false;
		return true;
	}

}
