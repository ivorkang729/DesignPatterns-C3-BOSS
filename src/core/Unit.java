package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import state.NormalState;
import view.View;

public class Unit {
	
	private Troop troop;

	private String name;
	private int hp;
	private int mp;
	private int str;
	private State state;
	private List<Action> actions = new ArrayList<>();
	private DecisionMaker decisionMaker;
	private Map<EventType, Set<EventObserver>> eventRegistry = new HashMap<>();
	
	
	public static enum EventType{
		ON_DEAD
	}
	
	
	public Unit(String name, int hp, int mp, int str, DecisionMaker decisionMaker) {
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.str = str;
		this.state = new NormalState(this);
		this.state.onEntry();
		addSkill(new BasicAttack());
		this.decisionMaker = decisionMaker;
	}
	
	
	public void addSkill(Action skill) {
		skill.setOwner(this);
		this.actions.add(skill);
	}
	
	
	public void setTroop(Troop troop) {
		this.troop = troop;
	}
	
	
	public void onRoundBegin() {
		if (isAlive()) {
			state.onRoundBegin();
		}
	}
	
	
	public void onRoundEnd() {
		if (isAlive()) {
			state.onRoundEnd();
		}
	}
	
	
	public void takeAction() {
		if (isAlive()) {
			View.displayTurnBegin(this);
			state.takeAction();
		}
	}
	
	
	public boolean hasEnoughMp(Action action) {
		return mp >= action.getMpRequired();
	}


	public void consumeMp(int amount) {
		if (isAlive()) {
			if (mp < amount) {
				throw new IllegalStateException("MP不足");
			}
			mp -= amount;
		}
	}
	
	
	public int getAdditionalDamage() {
		return state.getAdditionalDamage();
	}
	
	
	public void damage(int amount) {
		if (isAlive()) {
			hp -= amount ;
			if (isDead()) {
				onDead();
			}
		}
	}
	
	
	public void suicide() {
		if (isAlive()) {
			hp = 0;
			onDead();
		}
	}
	
	
	public void heal(int amount) {
		if (isAlive()) {
			hp += amount;
		}
	}
	
	
	public boolean isAlive() {
		return hp > 0;
	}
	
	
	protected boolean isDead() {
		return !isAlive();
	}
	
	
	protected void onDead() {
		Set<EventObserver> eventObservers = eventRegistry.get(EventType.ON_DEAD);
		if (eventObservers != null) {
			eventObservers.forEach(observer -> observer.notified(this));
		}
		View.displayDead(this);
	}
	
	
	public Troop getEnemyTroop() {
		return troop.getEnemyTroop();
	}
	
	
	public void transState(State nextState) {
		state.onExit();
		state = nextState;
		state.onEntry();
	}
	
	
	public void registerEventObserver(EventType eventType, EventObserver observer) {
		Set<EventObserver> eventObservers = eventRegistry.get(eventType);
		if (eventObservers == null) {
			eventObservers = new HashSet<EventObserver>();
			eventObservers.add(observer);
			eventRegistry.put(eventType, eventObservers);
		}
		else {
			eventObservers.add(observer);
		}
	}
	
	// Getter、Setter ----------------------------------------------------------

	public String getName() {
		return name;
	}


	public int getHp() {
		return hp;
	}


	public int getMp() {
		return mp;
	}


	public int getStr() {
		return str;
	}


	public State getState() {
		return state;
	}
	
	
	public Troop getTroop() {
		return troop;
	}
	
	
	public List<Action> getActions(){
		return actions;
	}
	

	protected DecisionMaker getDecisionMaker() {
		return decisionMaker;
	}
	
	

}
