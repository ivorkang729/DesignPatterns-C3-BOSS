package decision;

import java.util.ArrayList;
import java.util.List;

import core.Action;
import core.DecisionMaker;
import core.Unit;

public class SimpleAiDecisionMaker extends DecisionMaker {
	
	private int seed = 0;

	@Override
	public Action decideAction(List<Action> actions) {
		int index = (seed % actions.size());
		seed++;
		return actions.get(index);
	}

	@Override
	public List<Unit> decideTargets(Action action) {
		List<Unit> result = new ArrayList<>();
		List<Unit> targetCandidates = action.getTargetCandidates();
		int n = targetCandidates.size();
		for (int m = 0; m < action.getNumberOfTargetRequired(); m++) {
			Unit unit = targetCandidates.get((seed + m) % n);
			result.add(unit);
		}
		seed++;
		return result;
	}

}
