package skill.onePunch.CoR;


import core.Unit;
import view.View;

public class HpHandler extends OnePunchExecuteHandler {

	public HpHandler(OnePunchExecuteHandler next) {
		super(next);
	}

	@Override
	protected boolean condition(Unit target) {
		return target.getHp() >= 500;
	}

	@Override
	protected void action(Unit actor, Unit target) {
		int damageAmount = 300 + actor.getAdditionalDamage();
		View.displayActorDamageOnTarget(actor, target, damageAmount);
		target.damage(damageAmount);
	}

}
