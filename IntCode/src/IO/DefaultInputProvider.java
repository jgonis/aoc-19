package IO;

public class DefaultInputProvider implements InputProvider {
    private final int _inputValue;

    public DefaultInputProvider(int inputValue) {
        _inputValue = inputValue;
    }
    @Override
    public int getInput() {
        return _inputValue;
    }
}
