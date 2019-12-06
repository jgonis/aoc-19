package OpCodes;

import java.util.List;

public class InputOp implements OpCode {
	@Override
	public void processOperation(List<Integer> program, int programCounter) {

	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 2;
	}
}
