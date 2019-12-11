package com.jgon.aoc;

import CPU.IntCodeComp;
import com.jgon.containers.Pair;

import java.util.Arrays;
import java.util.List;

public class Problem2_1 {

    private List<String> _program;

    Problem2_1(List<String> opStream, List<Pair<Integer, String>> inputs) {
        String[] split = opStream.get(0).split(",");
        _program = Arrays.asList(split);
        for (Pair<Integer, String> input : inputs) {
            _program.set(input.getFirst(), input.getSecond());
        };
    }

    public int runProgram() throws Exception {
        IntCodeComp cpu = new IntCodeComp();
        _program = cpu.runProgram(_program);
        return Integer.parseInt(_program.get(0));
    }
}
