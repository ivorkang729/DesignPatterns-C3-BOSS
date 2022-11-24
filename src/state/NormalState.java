package state;

import core.State;
import core.Unit;

public class NormalState extends State {

	public NormalState(Unit owner) {
		super("正常", owner);
	}
	
	
	@Override
	public void onRoundBegin() {
		// do nothing
	}
	
	
	@Override
	public void onRoundEnd() {
		// do nothing
	}

}
