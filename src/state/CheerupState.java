package state;

import core.State;
import core.Unit;

public class CheerupState extends State {

	public CheerupState(Unit owner, int countDown) {
		super("εε°ιΌθ", owner);
		this.countDown = countDown;
	}
	
	
	@Override
	public int getAdditionalDamage() {
		return 50;
	}
	
	

}
