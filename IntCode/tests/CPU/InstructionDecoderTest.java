package CPU;

import com.jgon.containers.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstructionDecoderTest {

    InstructionDecoder _subject;
    List<Pair<Pair<List<Integer>, Integer>, String>> _inputs;

    @BeforeEach
    void setUp() {
        _subject = new InstructionDecoder();
        _inputs = List.of(Pair.of(Pair.of(List.of(0, 0, 0), 2), "2"),
                Pair.of(Pair.of(List.of(1, 0, 0), 2),"102"),
                Pair.of(Pair.of(List.of(0, 1, 0), 2), "1002"),
                Pair.of(Pair.of(List.of(1, 1, 0), 2),"1102"),
                Pair.of(Pair.of(List.of(0, 0, 1), 2),"10002"),
                Pair.of(Pair.of(List.of(1, 0, 1), 2),"10102"),
                Pair.of(Pair.of(List.of(0, 1, 1), 2),"11002"),
                Pair.of(Pair.of(List.of(1, 1, 1), 2),"11102"));
    }

    @Test
    void parseInstruction() {
        ArrayList<Integer> parameterModes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            parameterModes.add(0);
        }
        Pair<List<Integer>, Integer> decodedInstruction = new Pair<>();
        for(Pair<Pair<List<Integer>, Integer>, String> input : _inputs) {
            _subject.parseInstruction(parameterModes,
                    input.getSecond(),
                    decodedInstruction);
            assertEquals(input.getFirst(), decodedInstruction);
        }
    }
}