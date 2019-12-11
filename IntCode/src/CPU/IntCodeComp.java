package CPU;

import IO.DefaultInputProvider;
import OpCodes.*;
import com.jgon.containers.Pair;

import java.util.ArrayList;
import java.util.List;

public class IntCodeComp {

	private final ArrayList<OpCode> _opCodes;
	private final ArrayList<Integer> _parameterModes;
	private final InstructionDecoder _instructionDecoder = new InstructionDecoder();

	public IntCodeComp() {
		_opCodes = new ArrayList<OpCode>(5);
		_opCodes.add(null);
		_opCodes.add(new AddOp());
		_opCodes.add(new MultOp());
		_opCodes.add(new InputOp(new DefaultInputProvider()));
		_opCodes.add(new OutputOp());

		_parameterModes = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			_parameterModes.add(0);
		}
	}
	public List<String> runProgram(List<String> program) throws Exception {
		int programCounter = 0;
		Pair<List<Integer>, Integer> decodedInstruction = new Pair<>();
		while(true) {
			String ins = program.get(programCounter);
			_instructionDecoder.parseInstruction(_parameterModes,
					ins,
					decodedInstruction);
			if(decodedInstruction.getSecond() == 99) {
				break;
			} else {
				OpCode op = _opCodes.get(decodedInstruction.getSecond());
				if(op == null)
					throw new Exception("Found Invalid Op!");
				op.processOperation(decodedInstruction.getFirst(), program, programCounter);
				programCounter = op.updateProgramCounter(programCounter);
			}
		}
		return program;
	}
}
