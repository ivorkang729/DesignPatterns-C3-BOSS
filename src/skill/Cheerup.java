package skill;

import java.util.List;
import java.util.stream.Collectors;

import core.Action;
import core.Unit;
import state.CheerupState;
import view.View;

public class Cheerup extends Action {
	
	public Cheerup() {
		super("鼓舞", 100, 3);
	}
	
	
	@Override
	public List<Unit> getTargetCandidates() {
		return getOwner().getTroop().getAliveUnits().stream().filter(unit -> unit != getOwner()).collect(Collectors.toList());
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& targets.size() <= getNumberOfTargetRequired()  
//				&& getOwner().getTroop().isMember(targets)
//				&& !targets.contains(getOwner())
				; 
	}
	
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSkillsOnTargets(this, targets);
		targets.forEach(target -> {
			target.transState(new CheerupState(target, 3));
		});
	}

}
