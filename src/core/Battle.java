package core;

import view.View;

public class Battle {
	
	private Troop[] troops = new Troop[2];
	
	
	public Battle(Troop troop1, Troop troop2) {
		this.troops[0] = troop1;
		troop1.setIndex(0);
		troop1.setRpg(this);
		
		this.troops[1] = troop2;
		troop2.setIndex(1);
		troop2.setRpg(this);
	}
	
	
	public Troop getTroop(int index) {
		return troops[index];
	}
	
	
	public void battleStart() {
		nextRound();
		battleOver();
	}
	
	
	private void battleOver() {
		if (troops[0].getUnit(0).isAlive()) {
			View.displayYouWin();
		}
		else {
			View.displayYouLoose();
		}
	}
	
	
	private void nextRound() {
		// pre-condition
		for (int i = 0; i < 2; i++ ) {
			for (Unit unit : troops[i].getAliveUnits()) {
				unit.onRoundBegin();
				if (isGameOver()) {
					return;
				}
			}
		}
		
		// doAction
		for (int i = 0; i < 2; i++ ) {
			int p = 0;
			while (p < troops[i].getAllUnits().size()) {
				Unit unit = troops[i].getAllUnits().get(p++);
				unit.takeAction();
				if (isGameOver()) {
					return;
				}
			}
		}
		
		// post-condition
		for (int i = 0; i < 2; i++ ) {
			for (Unit unit : troops[i].getAliveUnits()) {
				unit.onRoundEnd();
				if (isGameOver()) {
					return;
				}
			}
		}
		
		nextRound();
		
	}
	
	
	private boolean isGameOver() {
		if (!troops[0].getUnit(0).isAlive()) {
			return true;
		}
		if (troops[0].isAnnihilate() || troops[1].isAnnihilate()) {
			return true;
		}
		return false;
	}

	

}
