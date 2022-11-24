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
import skill.Cheerup;
import skill.Petrochemical;
import skill.Poison;
import skill.onePunch.OnePunch;
import skill.onePunch.CoR.CheerupHandler;
import skill.onePunch.CoR.HpHandler;
import skill.onePunch.CoR.NormalHandler;
import skill.onePunch.CoR.PoisonedOrPetrochemicalHandler;
import utils.TestdataInReader;
import utils.TestdataOutReader;

public class Main_OnePunch {
	
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
		TestdataOutReader.init(testfilePath + "one-punch.out");
		TestdataInReader testdataInReader = new TestdataInReader(testfilePath + "one-punch.in");
		DecisionMaker testDataDecisionMaker = new TestDataDecisionMaker(testdataInReader);
		
//		Troop1
		Troop troop1 = new Troop();
		
		Unit unit = new Unit("英雄", 1000, 10000, 0, testDataDecisionMaker);
		unit.addSkill(new OnePunch(new HpHandler(new PoisonedOrPetrochemicalHandler(new CheerupHandler(new NormalHandler(null))))));
		unit.addSkill(new Poison());
		unit.addSkill(new Petrochemical());
		unit.addSkill(new Cheerup());
		troop1.addUnit(unit);
		
		
//		Troop2
		Troop troop2 = new Troop();
		
		unit = new Unit("Slime1", 601, 0, 0, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		
		unit = new Unit("Slime2", 241, 0, 0, new SimpleAiDecisionMaker());
		troop2.addUnit(unit);
		
		unit = new Unit("Slime3", 101, 999, 0, new SimpleAiDecisionMaker());
		unit.addSkill(new OnePunch(new HpHandler(new PoisonedOrPetrochemicalHandler(new CheerupHandler(new NormalHandler(null))))));
		unit.addSkill(new OnePunch(new HpHandler(new PoisonedOrPetrochemicalHandler(new CheerupHandler(new NormalHandler(null))))));
		unit.addSkill(new Cheerup());
		troop2.addUnit(unit);
		
		// Battle
		Battle rpg = new Battle(troop1, troop2);
		rpg.battleStart();
	}


}
