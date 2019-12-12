package com.jgon.aoc;

import CPU.IntCodeComputer;
import IO.DefaultInputProvider;
import IO.DefaultOutputReceiver;
import com.jgon.containers.InstructionListFactory;

import java.io.InputStream;
import java.util.List;

public class Problem5 {

    public static void main(String[] args) throws Exception {
        Problem5 app = new Problem5();
        InputStream input = app.getClass().getResourceAsStream("/p5input.txt");
        //problem5_1(input);
        problem5_2(input);
    }

    private static void problem5_1(InputStream input) throws Exception {
        InstructionListFactory isf = new InstructionListFactory();
        List<String> instructionList = isf.getInstructionList(input);
        IntCodeComputer cpu = new IntCodeComputer(new DefaultInputProvider(1),
                new DefaultOutputReceiver());
        List<String> result = cpu.runProgram(instructionList);
    }

    private static void problem5_2(InputStream input) throws Exception {
        InstructionListFactory isf = new InstructionListFactory();
        List<String> instructionList = isf.getInstructionList(input);
        IntCodeComputer cpu = new IntCodeComputer(new DefaultInputProvider(5),
                new DefaultOutputReceiver());
        List<String> result = cpu.runProgram(instructionList);
    }
}
