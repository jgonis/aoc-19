package OpCodes;

import IO.OutputReceiver;

import java.util.List;

public class OutputOp extends BaseOpCode implements OpCode {
	private final OutputReceiver _receiver;

	public OutputOp(OutputReceiver receiver) {
		 _receiver = receiver;
	}
	@Override
	public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) {
		int input = _retrievers[parameterModes.get(0)].retrieveParameter(program, (programCounter + 1));
		//System.out.println("output " + input);
		_receiver.receiveOutput(input);
	}

	@Override
	public int updateProgramCounter(int programCounter) {
		return programCounter + 2;
	}
}
