package OpCodes;

import java.util.List;

public class HaltOpCode implements OpCode {
	@Override
	public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) throws Exception {
	}

	@Override
	public int updateProgramCounter(int programCounter) throws Exception {
		return programCounter;
	}
}
