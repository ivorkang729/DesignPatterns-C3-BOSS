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
import skill.curse.Curse;
import utils.TestdataInReader;
import utils.TestdataOutReader;

public class Main_Curse {
	
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
		TestdataOutReader.init(testfilePath + "curse.out");
		TestdataInReader testdataInReader = new TestdataInReader(testfilePath + "curse.in");
		DecisionMaker testDataDecisionMaker = new TestDataDecisionMaker(testdataInReader);
		
//		Troop1
		Troop troop1 = new Troop();
		
		Unit unit = new Unit("英雄", 300, 10000, 100, testDataDecisionMaker);
		unit.addSkill(new Curse());
		troop1.addUnit(unit);
		
		unit = new Unit("Ally", 600, 100, 30, new SimpleAiDecisionMaker());
		unit.addSkill(new Curse());
		unit.addSkill(new Curse());
		troop1.addUnit(unit);
		
		
//		Troop2
		Troop troop2 = new Troop();
		
		unit = new Unit("Slime1", 200, 999, 50, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		
		unit = new Unit("Slime2", 200, 999, 100, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		
		// Battle
		Battle rpg = new Battle(troop1, troop2);
		rpg.battleStart();
	}


}
