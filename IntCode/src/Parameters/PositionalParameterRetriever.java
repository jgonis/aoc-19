package Parameters;

import java.util.List;

public class PositionalParameterRetriever implements ParameterRetriever {
    @Override
    public int retrieveParameter(List<String> program, int programCounter) {
        return Integer.parseInt(program.get(Integer.parseInt(program.get(programCounter))));
    }
}
