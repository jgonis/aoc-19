package OpCodes;

import java.util.List;

public class InputOp implements OpCode {
	private final InputProvider _provider;

	public InputOp(InputProvider provider) {
		_provider = provider;
	}

	@Override
	public void processOperation(List<Integer> parameterModes, List<Integer> program, int programCounter) {

	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 2;
	}
}
