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
import skill.SelfExplosion;
import utils.TestdataInReader;
import utils.TestdataOutReader;

public class Main_SelfExplosion {
	
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
		TestdataOutReader.init(testfilePath + "self-explosion.out");
		TestdataInReader testdataInReader = new TestdataInReader(testfilePath + "self-explosion.in");
		DecisionMaker testDataDecisionMaker = new TestDataDecisionMaker(testdataInReader);
		
//		Troop1
		Troop troop1 = new Troop();
		
		Unit unit = new Unit("英雄", 999999, 500, 30, testDataDecisionMaker);
		unit.addSkill(new SelfExplosion());
		troop1.addUnit(unit);
		
		unit = new Unit("A", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("B", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("C", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("D", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("E", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("F", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("G", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("H", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		unit = new Unit("I", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop1.addUnit(unit);
		
		
//		Troop2
		Troop troop2 = new Troop();
		
		unit = new Unit("A", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("B", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("C", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("D", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("E", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("F", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("G", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("H", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		unit = new Unit("I", 100, 1000, 15, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		
		
		// Battle
		Battle rpg = new Battle(troop1, troop2);
		rpg.battleStart();
	}


}
