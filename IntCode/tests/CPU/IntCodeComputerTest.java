package CPU;

import IO.InputProvider;
import IO.OutputReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


class IntCodeComputerTest {
    private InputProvider mockInputProvider = mock(InputProvider.class);
    private OutputReceiver mockOutputReceiver = mock(OutputReceiver.class);
    private IntCodeComputer _subject;
    @BeforeEach
    void setUp() {
        _subject = new IntCodeComputer(mockInputProvider, mockOutputReceiver);
    }

    @Test
    void test1() {
    }
}