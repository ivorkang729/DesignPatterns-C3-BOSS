package state;

import core.State;
import core.Unit;

public class PetrochemicalState extends State {

	public PetrochemicalState(Unit owner, int countDown) {
		super("石化", owner);
		this.countDown = countDown;
	}
	
	
	@Override
	public void takeAction() {
		// 石化不能動
	}
	

}
