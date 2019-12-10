package CPU;

import OpCodes.*;
import com.jgon.containers.Pair;

import java.util.ArrayList;
import java.util.List;

public class IntCodeComp {

	private final ArrayList<OpCode> _opCodes;

	public IntCodeComp() {
		_opCodes = new ArrayList<OpCode>(5);
		_opCodes.add(null);
		_opCodes.add(new AddOp());
		_opCodes.add(new MultOp());
		_opCodes.add(new InputOp(new DefaultInputProvider()));
		_opCodes.add(new OutputOp());
	}
	public List<Integer> runProgram(List<Integer> program) throws Exception {
		int programCounter = 0;
		while(true) {
			Integer ins = program.get(programCounter);
			Pair<List<Integer>, Integer> decodedInstruction = parseInstruction(ins.toString());
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

	private Pair<List<Integer>,Integer> parseInstruction(String instruction) {
			List<Integer> parameterModes = new ArrayList<>(3);
			parameterModes.add(0);
			parameterModes.add(0);
			parameterModes.add(0);
			Integer instructionValue;
			if(instruction.length() != 1) {
				int parameterModeIndex = 2;
				instructionValue = Integer.decode(instruction.substring(instruction.length() - 2));
				for(int i = (instruction.length() - 3); i >= 0; i--) {
					parameterModes.set(parameterModeIndex, Character.getNumericValue(instruction.charAt(i)));
					parameterModeIndex--;
				}
			} else {
				return Pair.of(parameterModes, Integer.decode(instruction));
			}
			return Pair.of(parameterModes, instructionValue);
	}
}
