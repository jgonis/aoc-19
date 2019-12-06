package com.jgon.aoc;

import CPU.IntCodeComp;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2_1 {

    private List<Integer> _program;

    Problem2_1(List<String> opStream, List<List<Integer>> inputs) {
        String[] split = opStream.get(0).split(",");
        List<String> opsAsStrings = Arrays.asList(split);
        _program = opsAsStrings.stream()
                .map(Integer::decode)
                .collect(Collectors.toList());
        for (List<Integer> input : inputs) {
            _program.set(input.get(0), input.get(1));
        };
    }

    public int runProgram() throws Exception {
        IntCodeComp cpu = new IntCodeComp();
        _program = cpu.runProgram(_program);
        return _program.get(0);
    }
}
