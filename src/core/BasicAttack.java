package core;

import java.util.List;

import view.View;

public class BasicAttack extends Action {
	
	public BasicAttack() {
		super("普通攻擊", 0, 1);
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& (targets.size() == getNumberOfTargetRequired())
				&& (getOwner().getEnemyTroop().isMember(targets)); 
	}
	

	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		targets.forEach(target -> {
			int damageAmount = actor.getStr() + actor.getAdditionalDamage();
			View.displayBasicAttackPerformOnTarget(this, target);
			View.displayActorDamageOnTarget(this, target, damageAmount);
			target.damage(damageAmount);
		});
	}
	
}
