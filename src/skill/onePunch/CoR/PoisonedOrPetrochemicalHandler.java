package skill.onePunch.CoR;


import core.Unit;
import state.PetrochemicalState;
import state.PoisonedState;
import view.View;

public class PoisonedOrPetrochemicalHandler extends OnePunchExecuteHandler {

	public PoisonedOrPetrochemicalHandler(OnePunchExecuteHandler next) {
		super(next);
	}

	@Override
	protected boolean condition(Unit target) {
		return (target.getState() instanceof PoisonedState) || (target.getState() instanceof PetrochemicalState);
	}

	@Override
	protected void action(Unit actor, Unit target) {
		int damageAmount = 80 + actor.getAdditionalDamage();
		for (int i = 0; i < 3; i++) {
			if (target.isAlive()) {
				View.displayActorDamageOnTarget(actor, target, damageAmount);
				target.damage(damageAmount);
			}
		}
	}

}
