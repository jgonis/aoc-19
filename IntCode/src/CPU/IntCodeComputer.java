package CPU;

import IO.InputProvider;
import IO.OutputReceiver;
import OpCodes.*;
import com.jgon.containers.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IntCodeComputer {
	private final ArrayList<OpCode> _opCodes;
	private final ArrayList<Integer> _parameterModes;
	private final InstructionDecoder _instructionDecoder = new InstructionDecoder();
	private final Map<Integer, OpCode> _haltOpCodes;
	private int _programCounter;

	public IntCodeComputer(InputProvider inputProvider,
	                       OutputReceiver outputReceiver) {
		this(inputProvider, outputReceiver, Map.of(99, new HaltOpCode()));
	}

	public IntCodeComputer(InputProvider inputProvider,
	                       OutputReceiver outputReceiver,
	                       Map<Integer, OpCode> haltOpCodes) {
		_haltOpCodes = haltOpCodes;
		_opCodes = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			_opCodes.add(new InvalidOpCode());
		}
		_opCodes.set(1, new AddOp());
		_opCodes.set(2, new MultOp());
		_opCodes.set(3, new InputOp(inputProvider));
		_opCodes.set(4, new OutputOp(outputReceiver));
		_opCodes.set(5, new JumpIfTrueOp());
		_opCodes.set(6, new JumpIfFalseOp());
		_opCodes.set(7, new LessThanOp());
		_opCodes.set(8, new EqualsOp());
		_opCodes.set(99, new HaltOpCode());

		_parameterModes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			_parameterModes.add(0);
		}
	}

	public Pair<List<String>, Integer> runProgram(List<String> program) throws Exception {
		return runProgram(program, 0);
	}

	public Pair<List<String>, Integer> runProgram(List<String> program, int programCounter) throws Exception {
		_programCounter = programCounter;
		int instructionCount = 1;
		Pair<List<Integer>, Integer> decodedInstruction = new Pair<>();
		while (true) {
			String ins = program.get(_programCounter);
			_instructionDecoder.parseInstruction(_parameterModes,
					ins,
					decodedInstruction);
//				System.out.println("executing instruction: " + instructionCount + " opcode: " + decodedInstruction.getSecond());
			OpCode op = _opCodes.get(decodedInstruction.getSecond());
			if (op == null)
				throw new Exception("Found Invalid Op!");
			op.processOperation(decodedInstruction.getFirst(), program, _programCounter);
			_programCounter = op.updateProgramCounter(_programCounter);
			if (_haltOpCodes.containsKey(decodedInstruction.getSecond())) {
				return Pair.of(program, _programCounter);
			}
			instructionCount++;
		}
	}
}
