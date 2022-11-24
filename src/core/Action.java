package core;

import java.util.List;


public abstract class Action {
	
	private String name;
	private int mpRequired;
	private int numberOfTargetRequired;
	private Unit owner;
	
	
	public Action(String name, int mpRequired, int numberOfTargetRequired) {
		this.name = name;
		this.mpRequired = mpRequired;
		this.numberOfTargetRequired = numberOfTargetRequired;
	}
	
	
	protected void setOwner(Unit owner) {
		this.owner = owner;
	}
	
	
	public String getName() {
		return name;
	}


	public Unit getOwner() {
		return owner;
	}


	public int getMpRequired() {
		return mpRequired;
	}

	
	public int getNumberOfTargetRequired() {
		return numberOfTargetRequired;
	}
		

	public List<Unit> getTargetCandidates() {
		return owner.getEnemyTroop().getAliveUnits();
	}
	
	
	public boolean isLegalAction(List<Unit> targets) {
		return owner.getMp() >= mpRequired;
	}
	
	
	public void perform(List<Unit> targets) {
		owner.consumeMp(mpRequired);
		execute(owner, targets);
	}
	
	
	protected abstract void execute(Unit actor, List<Unit> targets);
	

}
