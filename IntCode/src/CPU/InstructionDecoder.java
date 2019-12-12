package CPU;

import com.jgon.containers.Pair;

import java.util.List;

public class InstructionDecoder {
    public InstructionDecoder() {
    }

    void parseInstruction(List<Integer> parameterModes,
                          String instruction,
                          Pair<List<Integer>, Integer> decodedInstruction) {
        parameterModes.set(0, 0);
        parameterModes.set(1, 0);
        parameterModes.set(2, 0);

        Integer instructionValue = Integer.parseInt(instruction.substring(Math.max(0, instruction.length() - 2)));
        int insertIndex = 0;
        for (int i = (instruction.length() - 3); i >= 0; i--) {
            parameterModes.set(insertIndex, Character.getNumericValue(instruction.charAt(i)));
            insertIndex++;
        }
        decodedInstruction.setFirst(parameterModes);
        decodedInstruction.setSecond(instructionValue);
    }
}