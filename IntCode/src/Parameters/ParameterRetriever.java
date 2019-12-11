package Parameters;

import java.util.List;

public interface ParameterRetriever {
    int retrieveParameter(List<String> program, int programCounter);
}
