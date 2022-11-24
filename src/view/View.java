package view;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import core.Action;
import core.Troop;
import core.Unit;
import utils.TestdataOutReader;
import utils.Utils;

public class View {
	
	
	// Troop ------------------------------------------------
	public static String str(Troop troop) {
		return String.format("[%s]", troop.getNo());
	}
	
	public static String strAllUnits(Troop troop) {
		StringBuilder sb = new StringBuilder();
		troop.getAllUnits().forEach(unit -> {
			sb.append(strDetails(unit) + System.lineSeparator());
		});
		return sb.toString();
	}
	
	
	// Unit -------------------------------------------------
	public static String str(Unit unit) {
		return String.format("%s%s", str(unit.getTroop()), unit.getName());
	}
	
	public static String strDetails(Unit unit) {
		return String.format("%s (HP: %s, MP: %s, STR: %s, State: %s)", str(unit), unit.getHp(), unit.getMp(), unit.getStr(), unit.getState().getName());
	}
	
	
	// Action ------------------------------------------------
	public static void displayAction(Action action) {
		System.err.println(action.getName());
	}
	
	
	// Standard output
	public static void displayTurnBegin(Unit unit) {
		String msg = String.format("輪到 %s。", strDetails(unit));
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	public static void displayChooseAction(Unit unit) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < unit.getActions().size(); i++) {
			sb.append(String.format("(%s) %s ", i, unit.getActions().get(i).getName()));
		}
		String msg = String.format("選擇行動：%s", sb.toString().trim());
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	public static void displayChooseTargets(Action action) {
		List<Unit> candidates = action.getTargetCandidates();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < candidates.size(); i++) {
			sb.append(String.format("(%s) %s ", i, str(candidates.get(i))));
		}
		String msg = String.format("選擇 %s 位目標: %s", action.getNumberOfTargetRequired(), sb.toString().trim());
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//[1]英雄 對 [2]Slime1, [2]Slime2 使用了 火球。
	public static void displayActorPerformsSkillsOnTargets(Action action, List<Unit> targets) {
		
		List<String> strTargets = targets.stream().map(target -> {
			return str(target);
		}).collect(Collectors.toList());
		String.join(", ", strTargets);
		
		String msg = String.format("%s %s使用了 %s。"
				, str(action.getOwner())
				, strTargets.size() == 0 ? "": String.format("對 %s ", String.join(", ", strTargets))
				, action.getName());
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
		
	}
	
	
	//[2]Slime1 使用了 自我治療。
	public static void displayActorPerformsSelfHealing(Action action) {
		String msg = String.format("%s 使用了 %s。", str(action.getOwner()), action.getName());
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//[2]Slime1 使用了 自我治療。
	public static void displayActorPerformsSummon(Action action) {
		String msg = String.format("%s 使用了 %s。", str(action.getOwner()), action.getName());
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//[1]英雄 對 [2]Slime1 造成 50 點傷害。
	public static void displayActorDamageOnTarget(Action action, Unit target, int damageAmount) {
		String msg = String.format("%s 對 %s 造成 %s 點傷害。", str(action.getOwner())
				, str(target)
				, damageAmount);
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//[1]英雄 對 [2]Slime1 造成 50 點傷害。
	public static void displayActorDamageOnTarget(Unit actor, Unit target, int damageAmount) {
		String msg = String.format("%s 對 %s 造成 %s 點傷害。", str(actor)
				, str(target)
				, damageAmount);
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//[2]Slime1 攻擊 [1]英雄。
	public static void displayBasicAttackPerformOnTarget(Action action, Unit target) {
		String msg = String.format("%s 攻擊 %s。", str(action.getOwner()), str(target));
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//[2]Slime2 死亡。
	public static void displayDead(Unit unit) {
		String msg = String.format("%s 死亡。", str(unit));
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//你缺乏 MP，不能進行此行動。
	public static void displayNotEnoughMP() {
		String msg = "你缺乏 MP，不能進行此行動。";
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//你獲勝了！
	public static void displayYouWin() {
		String msg = "你獲勝了！";
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	
	//你失敗了！
	public static void displayYouLoose() {
		String msg = "你失敗了！";
		Utils.println(msg);
		assertEquals(TestdataOutReader.getInstance().readLine(), msg);
	}
	
	

}
