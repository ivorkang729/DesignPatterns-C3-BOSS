package skill;

import java.util.List;

import core.Action;
import core.Unit;
import view.View;

public class Fireball extends Action {
	
	public Fireball() {
		super("火球", 50, Integer.MAX_VALUE);
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& (targets.size() <= getNumberOfTargetRequired())
				&& (getOwner().getEnemyTroop().isMember(targets)); 
	}
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSkillsOnTargets(this, targets);
		targets.forEach(target -> {
			int damageAmount = 50 + actor.getAdditionalDamage();
			View.displayActorDamageOnTarget(this, target, damageAmount);
			target.damage(damageAmount);
		});
	}

}
