package core;

import java.util.List;

public abstract class DecisionMaker {
	
	public abstract Action decideAction(List<Action> actions);
	public abstract List<Unit> decideTargets(Action action);

}
