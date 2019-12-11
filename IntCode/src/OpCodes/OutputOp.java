package OpCodes;

import java.util.List;

public class OutputOp implements OpCode {
	@Override
	public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) {

	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 2;
	}
}
