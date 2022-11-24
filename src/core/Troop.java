package core;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Troop {
	
	private Battle rpg;
	private int index;
	private List<Unit> units = new CopyOnWriteArrayList<>();
	
	public Troop() {
	}
	
	public void addUnit(Unit unit) {
		unit.setTroop(this);
		units.add(unit);
	}
	
	
	public Unit getUnit(int index) {
		return units.get(index);
	}
	
	
	public void setRpg(Battle rpg) {
		this.rpg = rpg;
	}


	void setIndex(int index) {
		this.index = index;
	}

	
	public List<Unit> getAllUnits() {
		return units;
	}

	
	public List<Unit> getAliveUnits() {
		return units.stream().filter(unit -> unit.isAlive()).collect(toList());
	}


	public Troop getEnemyTroop() {
		return rpg.getTroop(getEnemyIndex());
	}
	
	
	private int getEnemyIndex() {
		return (index + 1) % 2;
	}
	
	
	public int getNo() {
		return index + 1;
	}
	
	
	public boolean isMember(List<Unit> units) {
		return units.containsAll(units);
	}
	
	
	public boolean isAnnihilate() {
		return !units.stream().filter(unit -> unit.isAlive()).findAny().isPresent();
	}
}
