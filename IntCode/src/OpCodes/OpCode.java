package OpCodes;

import java.util.List;

public interface OpCode {
	public void processOperation(List<Integer> program, int programCounter);
	public int updateProgramCounter(int programCounter);
}
