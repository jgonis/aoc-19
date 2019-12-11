package OpCodes;

import java.util.List;

public interface OpCode {
	void processOperation(List<Integer> parameterModes, List<String> program, int programCounter);
	int updateProgramCounter(int programCounter);
}
