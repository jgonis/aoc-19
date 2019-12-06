package CPU;

import OpCodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntCodeComp {

	private final ArrayList<OpCode> _opCodes;

	public IntCodeComp() {
		_opCodes = new ArrayList<OpCode>(5);
		_opCodes.add(null);
		_opCodes.add(new AddOp());
		_opCodes.add(new MultOp());
		_opCodes.add(new InputOp());
		_opCodes.add(new OutputOp());
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
