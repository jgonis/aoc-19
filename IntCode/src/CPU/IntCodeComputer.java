package CPU;

import IO.InputProvider;
import IO.OutputReceiver;
import OpCodes.*;
import com.jgon.containers.Pair;

import java.util.*;

public class IntCodeComputer {
	public static final int HALT_OP_CODE = 99;
	private final HashMap<Integer, OpCode> _opCodes;
	private final ArrayList<Integer> _parameterModes;
	private final InstructionDecoder _instructionDecoder = new InstructionDecoder();
	private final Set<Integer> _suspendOpCodes;
	private int _programCounter = 0;
	private final List<String> _program;

	public IntCodeComputer(InputProvider inputProvider,
	                       OutputReceiver outputReceiver,
	                       List<String> program) {
		_suspendOpCodes = new HashSet<>();
		_program = new ArrayList<>(program);
		_opCodes = new HashMap<>();

		_opCodes.put(OpCodeNumber.ADD_OP.toInt(), new AddOp());
		_opCodes.put(OpCodeNumber.MULT_OP.toInt(), new MultOp());
		_opCodes.put(OpCodeNumber.INPUT_OP.toInt(), new InputOp(inputProvider));
		_opCodes.put(OpCodeNumber.OUTPUT_OP.toInt(), new OutputOp(outputReceiver));
		_opCodes.put(OpCodeNumber.JUMP_IF_TRUE_OP.toInt(), new JumpIfTrueOp());
		_opCodes.put(OpCodeNumber.JUMP_IF_FALSE_OP.toInt(), new JumpIfFalseOp());
		_opCodes.put(OpCodeNumber.LESS_THAN_OP.toInt(), new LessThanOp());
		_opCodes.put(OpCodeNumber.EQUALS_OP.toInt(), new EqualsOp());
		_opCodes.put(OpCodeNumber.HALT_OP.toInt(), new HaltOpCode());

		_parameterModes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			_parameterModes.add(0);
		}

	}

	public IntCodeComputer(InputProvider inputProvider,
	                       OutputReceiver outputReceiver,
	                       List<String> program,
	                       List<Integer> suspendOpCodes) {
		this(inputProvider, outputReceiver, program);
		_suspendOpCodes.addAll(suspendOpCodes);
	}

	public void runProgram() throws Exception {
		boolean run = true;
		while (run) {
			Pair<List<Integer>, Integer> decodedInstruction = getDecodedInstruction(_program,
					_programCounter,
					_instructionDecoder,
					_parameterModes);
			OpCode op = _opCodes.get(decodedInstruction.getSecond());
			op.processOperation(decodedInstruction.getFirst(),
					_program,
					_programCounter);
			_programCounter = op.updateProgramCounter(_programCounter);
			if(_suspendOpCodes.contains(decodedInstruction.getSecond())
					|| decodedInstruction.getSecond() == HALT_OP_CODE) {
				run = false;
			}
		}
	}

	private Pair<List<Integer>, Integer> getDecodedInstruction(List<String> program,
	                         int programCounter,
	                         InstructionDecoder decoder,
	                         ArrayList<Integer> parameterModes) {
		Pair<List<Integer>, Integer> decodedInstruction = new Pair<>();
		String ins = program.get(programCounter);
		decoder.parseInstruction(parameterModes,
				ins,
				decodedInstruction);
		return decodedInstruction;
	}

	public List<String> getProgram() {
		return _program;
	}

	public int getProgramCounter() {
		return _programCounter;
	}

	public boolean isHalted() {
		return getDecodedInstruction(_program,
				_programCounter,
				_instructionDecoder,
				_parameterModes).getSecond() == HALT_OP_CODE;
	}
}
