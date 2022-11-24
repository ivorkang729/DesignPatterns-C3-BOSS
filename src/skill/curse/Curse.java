package skill.curse;

import java.util.List;

import core.Action;
import core.Unit;
import view.View;

public class Curse extends Action {
	
	public Curse() {
		super("詛咒", 100, 1);
	}
	
	
	@Override
	public List<Unit> getTargetCandidates() {
		return getOwner().getEnemyTroop().getAliveUnits();
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& targets.size() == getNumberOfTargetRequired()
				&& getOwner().getEnemyTroop().isMember(targets);  
	}
	
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSkillsOnTargets(this, targets);
		targets.forEach(target -> {
			target.registerEventObserver(Unit.EventType.ON_DEAD, new CursedUnitOnDeadEventObserver(actor));
		});
	}

}
