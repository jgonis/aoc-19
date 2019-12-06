package CPU;

import OpCodes.AddOp;
import OpCodes.MultOp;
import OpCodes.OpCode;

import java.util.HashMap;
import java.util.List;

public class IntCodeComp {

	private final HashMap<Integer, OpCode> _opCodes;

	public IntCodeComp() {
		_opCodes = new HashMap<Integer, OpCode>();
		_opCodes.put(1, new AddOp());
		_opCodes.put(2, new MultOp());
	}
	public List<Integer> runProgram(List<Integer> program) throws Exception {
		int programCounter = 0;
		while(true) {
			Integer cell = program.get(programCounter);
			if(cell == 99) {
				break;
			} else {
				OpCode op = _opCodes.get(cell);
				if(op == null)
					throw new Exception("Found Invalid Op!");
				op.processOperation(program, programCounter);
				programCounter = op.updateProgramCounter(programCounter);
			}
		}
		return program;
	}
}
