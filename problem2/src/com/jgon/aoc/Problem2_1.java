package com.jgon.aoc;

import CPU.IntCodeComputer;
import IO.DefaultInputProvider;
import IO.DefaultOutputReceiver;
import com.jgon.containers.Pair;

import java.util.List;

public class Problem2_1 {
    public int runProgram(List<String> opStream, List<Pair<Integer, String>> inputs) throws Exception {
        for (Pair<Integer, String> input : inputs) {
            opStream.set(input.getFirst(), input.getSecond());
        };
        IntCodeComputer cpu = new IntCodeComputer(new DefaultInputProvider(1),
                new DefaultOutputReceiver());
        Pair<List<String>, Integer> result = cpu.runProgram(opStream);
        return Integer.parseInt(result.getFirst().get(0));
    }
}
