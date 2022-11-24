package skill;

import java.util.Arrays;
import java.util.List;

import core.Action;
import core.Unit;
import view.View;

public class SelfHealing extends Action {
	
	public SelfHealing() {
		super("自我治療", 50, 1);
	}
	
	
	@Override
	public List<Unit> getTargetCandidates() {
		return Arrays.asList(getOwner());
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& (targets.size() == getNumberOfTargetRequired()) 
				&& (targets.get(0) == getOwner());
	}
	
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSelfHealing(this);
		targets.forEach(target -> {
			target.heal(150);
		});
	}

}
