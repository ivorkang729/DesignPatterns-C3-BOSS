package skill;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

import core.Action;
import core.Unit;
import view.View;

public class SelfExplosion extends Action {
	
	public SelfExplosion() {
		super("自爆", 200, Integer.MAX_VALUE);
	}
	
	@Override
	public List<Unit> getTargetCandidates() {
		List<Unit> result = new ArrayList<>();
		result.addAll(getOwner().getTroop().getAliveUnits().stream().filter(unit -> unit != getOwner()).collect(toList()));
		result.addAll(getOwner().getEnemyTroop().getAliveUnits());
		return result;
	}
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets)
				&& !targets.contains(getOwner()); 
	}
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSkillsOnTargets(this, targets);
		targets.forEach(target -> {
			int damageAmount = 150 + actor.getAdditionalDamage();
			View.displayActorDamageOnTarget(this, target, damageAmount);
			target.damage(damageAmount);
		});
		actor.suicide();
	}

}
