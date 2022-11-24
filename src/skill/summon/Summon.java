package skill.summon;

import java.util.Collections;
import java.util.List;

import core.Action;
import core.Unit;
import decision.AiDecisionMakerFactory;
import view.View;

public class Summon extends Action {
	
	public Summon() {
		super("召喚", 150, 0);
	}
	
	
	@Override
	public List<Unit> getTargetCandidates() {
		return Collections.emptyList();
	}
	
	
	@Override
	public boolean isLegalAction(List<Unit> targets) {
		return super.isLegalAction(targets);
	}
	
	
	@Override
	protected void execute(Unit actor, List<Unit> targets) {
		View.displayActorPerformsSummon(this);
		// 不能用new AI的做法
		Unit slime = new Unit("Slime", 100, 0, 50, AiDecisionMakerFactory.build());
		actor.getTroop().addUnit(slime);
		slime.registerEventObserver(Unit.EventType.ON_DEAD, new SummonedUnitOnDeadEventObserver(actor));
	}

}
