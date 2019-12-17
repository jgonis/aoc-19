package IO;

public class DefaultOutputReceiver implements OutputReceiver {
    private int _output = 0;

    @Override
    public void receiveOutput(int output) {
        _output = output;
        //System.out.println("Output: " + output);
    }

    @Override
    public int getOutput() {
        return _output;
    }
}
