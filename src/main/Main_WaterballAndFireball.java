package main;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import core.DecisionMaker;
import core.Battle;
import core.Troop;
import core.Unit;
import decision.AiDecisionMakerFactory;
import decision.SimpleAiDecisionMaker;
import decision.TestDataDecisionMaker;
import skill.Fireball;
import skill.Waterball;
import utils.TestdataInReader;
import utils.TestdataOutReader;

public class Main_WaterballAndFireball {
	
	String testfilePath = "D:\\Educations\\2022_水球潘_正式課程\\C3_魔王題：真RPG之對戰遊戲\\SRC_C3_BOSS_真RPG\\src\\testcases\\";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void main() throws URISyntaxException {
		
		AiDecisionMakerFactory.init(AiDecisionMakerFactory.Type.SIMPLE_AI);
		TestdataOutReader.init(testfilePath + "waterball-and-fireball-1v2.out");
		TestdataInReader testdataInReader = new TestdataInReader(testfilePath + "waterball-and-fireball-1v2.in");
		DecisionMaker testDataDecisionMaker = new TestDataDecisionMaker(testdataInReader);
		
//		Troop1
//		英雄 300 500 100 火球 水球
		Troop troop1 = new Troop();
		
		Unit unit = new Unit("英雄", 300, 500, 100, testDataDecisionMaker);
		unit.addSkill(new Fireball());
		unit.addSkill(new Waterball());
		troop1.addUnit(unit);
		
		
//		Troop2
//		Slime1 200 60 49 火球
//		Slime2 200 200 50 火球 水球
		Troop troop2 = new Troop();
		
		unit = new Unit("Slime1", 200, 60, 49, new SimpleAiDecisionMaker());
		unit.addSkill(new Fireball());
		troop2.addUnit(unit);
		
		unit = new Unit("Slime2", 200, 200, 50, new SimpleAiDecisionMaker());
		unit.addSkill(new Fireball());
		unit.addSkill(new Waterball());
		troop2.addUnit(unit);
		
		// Battle
		Battle rpg = new Battle(troop1, troop2);
		rpg.battleStart();
	}


}
