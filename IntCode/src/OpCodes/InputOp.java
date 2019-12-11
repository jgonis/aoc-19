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
		int storePosition = _outputRetriever.retrieveParameter(program, (programCounter + 1));
		program.set(storePosition, Integer.toString(_provider.getInput()));
	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 2;
	}
}
