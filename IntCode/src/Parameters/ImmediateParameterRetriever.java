package Parameters;

import java.util.List;

public class ImmediateParameterRetriever implements ParameterRetriever {
    @Override
    public int retrieveParameter(List<String> program, int programCounter) {
        return Integer.parseInt(program.get(programCounter));
    }
}
