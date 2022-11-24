package decision;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import core.Action;
import core.DecisionMaker;
import core.Unit;
import utils.TestdataInReader;
import view.View;

public class TestDataDecisionMaker extends DecisionMaker {
	
	private TestdataInReader testDataReader;
	

	public TestDataDecisionMaker(TestdataInReader testDataReader) {
		this.testDataReader = testDataReader;
	}


	@Override
	public Action decideAction(List<Action> actions) {
		String in = testDataReader.readLine();
		return actions.get(Integer.valueOf(in.trim()));
	}
	
	
	@Override
	public List<Unit> decideTargets(Action action) {
		List<Unit> targetCandidates = action.getTargetCandidates();
		View.displayChooseTargets(action);
		
		String in = testDataReader.readLine();
		
		return Arrays.stream(in.split(",")).map(s -> Integer.valueOf(s.trim()))
				.map(i -> targetCandidates.get(i)).collect(Collectors.toList());
	}

}
