package OpCodes;

import Parameters.ImmediateParameterRetriever;
import Parameters.ParameterRetriever;
import Parameters.PositionalParameterRetriever;

public class BaseOpCode {
    protected ParameterRetriever[] _retrievers = {
            new PositionalParameterRetriever(),
            new ImmediateParameterRetriever()
    };

    protected ParameterRetriever _outputRetriever = new ImmediateParameterRetriever();

}
