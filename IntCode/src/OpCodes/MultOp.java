package OpCodes;

import java.util.List;

public class MultOp implements OpCode {
	@Override
	public void processOperation(List<Integer> parameterModes, List<Integer> program, int programCounter) {
		int input1 = program.get(program.get(programCounter + 1));
		int input2 = program.get(program.get(programCounter + 2));
		Integer storePosition = program.get(programCounter + 3);
		program.set(storePosition, (input1 * input2));
	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 4;
	}
}
