package core;

import java.util.List;

import state.NormalState;
import view.View;

public abstract class State {
	
	private String name;
	private Unit owner;
	protected int countDown;
	
	
	public State(String name, Unit owner) {
		this.name = name;
		this.owner = owner;
		this.countDown = Integer.MAX_VALUE;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	protected Unit getOwner() {
		return owner;
	}


	public void onEntry() {
		// do nothing
	}
	
	
	public void onExit() {
		// do nothing
	}
	
	
	public void onRoundBegin() {
		if (this.countDown <= 0) {
			getOwner().transState(new NormalState(getOwner()));
		}
	}
	
	
	public void onRoundEnd() {
		countDown -= 1;
	}
	
	
	public void takeAction() {
		Action action = s1();
		List<Unit> targets = s2(action);
		s3(action, targets);
	}
	
	
	protected Action s1() {
		View.displayChooseAction(owner);
		Action action = owner.getDecisionMaker().decideAction(owner.getActions());
		View.displayAction(action);
		if (!owner.hasEnoughMp(action)) {
			View.displayNotEnoughMP();
			action = s1();
		}
		return action;
	}
	
	
	protected List<Unit> s2(Action action){
		List<Unit> targetCandidates = action.getTargetCandidates();
		int n = targetCandidates.size();
		int m = action.getNumberOfTargetRequired();
		
		if (m == 0 || n <= m) {
			return targetCandidates;
		}
		return owner.getDecisionMaker().decideTargets(action);
	}
	
	
	protected void s3(Action action, List<Unit> targets) {
		if (!action.isLegalAction(targets)) {
			throw new IllegalStateException("行動不合法");
		}
		action.perform(targets);
	}
	
	
	public int getAdditionalDamage() {
		return 0;
	}
	
}
