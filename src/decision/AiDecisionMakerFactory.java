package decision;

import core.DecisionMaker;

public class AiDecisionMakerFactory {
	
	public enum Type{
		SIMPLE_AI
	}
	
	private static Type type;
	
	public static void init(Type aiType) {
		type = aiType;
	}
	
	public static DecisionMaker build() {
		if (type == Type.SIMPLE_AI) {
			return new SimpleAiDecisionMaker();
		}
		else {
			throw new UnsupportedOperationException();
		}
	}
	
}
