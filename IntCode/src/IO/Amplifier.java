package IO;

import CPU.IntCodeComputer;

import java.util.List;

public class Amplifier implements OutputReceiver, InputProvider {
	private int _phase;
	private OutputReceiver _previousAmplifier;
	private int _callCount = 0;
	private int _output = 0;
	private IntCodeComputer _cpu;
	private Integer _initialInput = null;

	public Amplifier(OutputReceiver previousAmplifier,
	                 List<String> program,
	                 List<Integer> suspendOpCodes,
	                 int phase) {
		_phase = phase;
		_previousAmplifier = previousAmplifier;
		_cpu = new IntCodeComputer(this,
				this,
				program,
				suspendOpCodes);
	}

	public void setPreviousAmplifier(Amplifier previousAmplifier) {
		_previousAmplifier = previousAmplifier;
	}

	@Override
	public int getInput() {
		if (_callCount == 0) {
			_callCount++;
			return _phase;
		} else {
			if (_initialInput != null) {
				int retVal = _initialInput;
				_initialInput = null;
				return retVal;
			}
			return _previousAmplifier.getOutput();
		}
	}

	@Override
	public void receiveOutput(int output) {
		_output = output;
	}

	@Override
	public int getOutput() {
		return _output;
	}

	public void setInitialInput(Integer initialInput) {
		_initialInput = initialInput;
	}

	public void runProgram() throws Exception {
		_cpu.runProgram();
	}

	public boolean isNotHalted() {
		return !_cpu.isHalted();
	}
}
