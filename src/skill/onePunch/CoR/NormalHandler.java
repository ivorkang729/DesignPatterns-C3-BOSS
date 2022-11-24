package skill.onePunch.CoR;


import core.Unit;
import state.NormalState;
import view.View;

public class NormalHandler extends OnePunchExecuteHandler {

	public NormalHandler(OnePunchExecuteHandler next) {
		super(next);
	}

	@Override
	protected boolean condition(Unit target) {
		return (target.getState() instanceof NormalState);
	}

	@Override
	protected void action(Unit actor, Unit target) {
		int damageAmount = 100 + actor.getAdditionalDamage();
		View.displayActorDamageOnTarget(actor, target, damageAmount);
		target.damage(damageAmount);
	}

}
