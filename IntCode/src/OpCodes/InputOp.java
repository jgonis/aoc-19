package OpCodes;

import IO.InputProvider;

import java.util.List;

public class InputOp extends BaseOpCode implements OpCode {
	private final InputProvider _provider;

	public InputOp(InputProvider provider) {
		_provider = provider;
	}

	@Override
	public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) {
//		System.out.println("input op");
		int storePosition = _outputRetriever.retrieveParameter(program, (programCounter + 1));
		String input = Integer.toString(_provider.getInput());
		program.set(storePosition, input);
	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 2;
	}
}
