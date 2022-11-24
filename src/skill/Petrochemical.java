package skill;

import java.util.List;

import core.Action;
import core.Unit;
import state.PetrochemicalState;
import view.View;

public class Petrochemical extends Action {
	
	public Petrochemical() {
		super("石化", 100, 1);
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		View.displayActorPerformsSkillsOnTargets(this, targets);
		return super.isLegalAction(targets)
				&& (targets.size() == getNumberOfTargetRequired())
				&& (getOwner().getEnemyTroop().isMember(targets));  
	}
	
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		targets.forEach(target -> {
			target.transState(new PetrochemicalState(target, 3));
		});
	}

}
