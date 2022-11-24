package skill.onePunch.CoR;


import core.Unit;
import state.CheerupState;
import state.NormalState;
import view.View;

public class CheerupHandler extends OnePunchExecuteHandler {

	public CheerupHandler(OnePunchExecuteHandler next) {
		super(next);
	}

	@Override
	protected boolean condition(Unit target) {
		return (target.getState() instanceof CheerupState);
	}

	@Override
	protected void action(Unit actor, Unit target) {
		int damageAmount = 100 + actor.getAdditionalDamage();
		View.displayActorDamageOnTarget(actor, target, damageAmount);
		target.damage(damageAmount);
		target.transState(new NormalState(target));
	}

}
