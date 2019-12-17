package OpCodes;

import java.util.List;

public class JumpIfTrueOp extends BaseOpCode implements OpCode{
    private int _newPC;

    @Override
    public void processOperation(List<Integer> parameterModes, List<String> program, int programCounter) {
//        System.out.println("jump if true");
        int input1 = _retrievers[parameterModes.get(0)].retrieveParameter(program,
                (programCounter + 1));
        int input2 = _retrievers[parameterModes.get(1)].retrieveParameter(program, (programCounter + 2));
        if(input1 != 0) {
            _newPC = input2;
        } else {
            _newPC = programCounter + 3;
        }
    }

    @Override
    public int updateProgramCounter(int programCounter) {
        return _newPC;
    }
}
