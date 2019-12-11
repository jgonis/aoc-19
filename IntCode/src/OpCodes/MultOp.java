package OpCodes;

import java.util.List;

public class MultOp extends BaseOpCode implements OpCode {
	@Override
	public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) {
		int input1 = _retrievers[parameterModes.get(0)].retrieveParameter(program,
				(programCounter + 1));
		int input2 = _retrievers[parameterModes.get(1)].retrieveParameter(program, (programCounter + 2));
		if(parameterModes.get(2) != 0)
			throw new IllegalArgumentException();
		Integer storePosition = _retrievers[1].retrieveParameter(program, (programCounter + 3));
		program.set(storePosition, Integer.valueOf(input1 * input2).toString());
	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 4;
	}
}
