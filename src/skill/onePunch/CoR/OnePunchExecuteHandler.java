package skill.onePunch.CoR;

import core.Unit;

public abstract class OnePunchExecuteHandler {
	
	private OnePunchExecuteHandler next;
	
	public OnePunchExecuteHandler(OnePunchExecuteHandler next) {
		this.next = next;
	}

	public void handle(Unit actor, Unit target) {
		if (condition(target)) {
			action(actor, target);
		}
		else {
			if (next != null) {
				next.handle(actor, target);
			}
		}
	}
	
	protected abstract boolean condition(Unit target);
	protected abstract void action(Unit actor, Unit target);
	
}
