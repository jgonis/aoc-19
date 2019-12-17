package IO;

public class Amplifier implements OutputReceiver, InputProvider {
	private int _phase = -1;
	private OutputReceiver _previousAmplifier;
	private int _callCount = 0;
	private int _output = 0;

	public Amplifier(OutputReceiver previousAmplifier) {
		_previousAmplifier = previousAmplifier;
	}

	public void setPhase(int phase) {
		_phase = phase;
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
 }
