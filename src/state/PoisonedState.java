package state;

import core.State;
import core.Unit;

public class PoisonedState extends State {

	public PoisonedState(Unit owner, int countDown) {
		super("中毒", owner);
		this.countDown = countDown;
	}
	
	
	@Override
	public void takeAction() {
		getOwner().damage(30);
		if(getOwner().isAlive()) {
			super.takeAction();
		}
	}
	

}
