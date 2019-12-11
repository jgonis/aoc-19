package IO;

public class DefaultOutputReceiver implements OutputReceiver {
    @Override
    public void receiveOutput(int output) {
        System.out.println("Output: " + output);
    }
}
