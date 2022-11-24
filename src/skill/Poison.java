package skill;

import java.util.List;

import core.Action;
import core.Unit;
import state.PoisonedState;
import view.View;

public class Poison extends Action {
	
	public Poison() {
		super("下毒", 80, 1);
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& (targets.size() == getNumberOfTargetRequired())
				&& (getOwner().getEnemyTroop().isMember(targets));  
	}
	
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSkillsOnTargets(this, targets);
		targets.forEach(target -> {
			target.transState(new PoisonedState(target, 3));
		});
	}

}
