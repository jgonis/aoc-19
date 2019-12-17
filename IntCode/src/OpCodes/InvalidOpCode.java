package OpCodes;

import java.util.List;

public class InvalidOpCode implements OpCode {
	@Override
	public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) throws Exception {
		throw new Exception("Invalid Op Code");
	}

	@Override
	public int updateProgramCounter(int programCounter) throws Exception {
		throw new Exception("Invalid Op Code");
	}
}
