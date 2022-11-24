package skill.summon;

import core.EventObserver;
import core.Unit;

public class SummonedUnitOnDeadEventObserver extends EventObserver {

	public SummonedUnitOnDeadEventObserver(Unit actor) {
		super(actor);
	}

	@Override
	public void notified(Unit eventSource) {
		if (!eventSource.isAlive() && actor.isAlive()) {
			actor.heal(30);
		}
	}

}
