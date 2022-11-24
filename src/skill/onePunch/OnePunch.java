package skill.onePunch;

import java.util.List;

import core.Action;
import core.Unit;
import skill.onePunch.CoR.OnePunchExecuteHandler;
import view.View;

public class OnePunch extends Action {
	
	private OnePunchExecuteHandler corHandler;
	
	public OnePunch(OnePunchExecuteHandler corHandler) {
		super("一拳攻擊", 180, 1);
		this.corHandler = corHandler;
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
			corHandler.handle(getOwner(), target);
		});
	}

}
