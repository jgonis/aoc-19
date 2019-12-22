package IO;

import CPU.IntCodeComputer;

import java.util.List;

public class Amplifier implements OutputReceiver, InputProvider {
	private int _phase = -1;
	private OutputReceiver _previousAmplifier;
	private int _callCount = 0;
	private int _output = 0;
	private IntCodeComputer _cpu;

	public Amplifier(OutputReceiver previousAmplifier,
	                 List<String> program,
	                 int phase) {
		_phase = phase;
		_previousAmplifier = previousAmplifier;
		_cpu = new IntCodeComputer(this,
				this,
				program,
				List.of());
	}

	public void setPreviousAmplifier(Amplifier previousAmplifier) {
		_previousAmplifier = previousAmplifier;
	}

	@Override
	public int getInput() {
		if(_callCount == 0) {
			_callCount++;
			return _phase;
		} else {
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

	public void reset() {
		_callCount = 0;
	}

	public void runProgram() throws Exception {
		_cpu.runProgram();
	}

	public boolean isHalted() {
		return _cpu.isHalted();
	}
}
