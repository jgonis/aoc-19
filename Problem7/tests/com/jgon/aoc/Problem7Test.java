package com.jgon.aoc;

import CPU.IntCodeComputer;
import IO.Amplifier;
import IO.DefaultOutputReceiver;
import com.jgon.containers.InstructionListFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem7Test {

    private IntCodeComputer _subject;
    private List<Amplifier> _amplifiers;

    @BeforeEach
    void setUp() {
        _amplifiers = new ArrayList<>();
        _amplifiers.add(new Amplifier(new DefaultOutputReceiver()));
        _amplifiers.add(new Amplifier(_amplifiers.get(0)));
        _amplifiers.add(new Amplifier(_amplifiers.get(1)));
        _amplifiers.add(new Amplifier(_amplifiers.get(2)));
        _amplifiers.add(new Amplifier(_amplifiers.get(3)));
    }

    private void setPhaseValues(List<Integer> phaseValues) {
        for(int i = 0; i < phaseValues.size(); i++) {
            _amplifiers.get(i).setPhase(phaseValues.get(i));
        }
    }

    @Test
    void p7_1testInput1() throws Exception {
        setPhaseValues(List.of(4,3,2,1,0));
        List<String> instructionList = List.of("3","15","3","16","1002","16","10","16","1","16","15","15",
                "4","15","99","0","0");

        for(Amplifier amp : _amplifiers) {
            ArrayList<String> il = new ArrayList<>(instructionList);
            _subject = new IntCodeComputer(amp, amp);
            _subject.runProgram(il);
        }
        assertEquals(43210, _amplifiers.get(4).getOutput());
    }

    @Test
    void p7_1testInput2() throws Exception {
        setPhaseValues(List.of(0,1,2,3,4));
        List<String> instructionList = List.of("3","23","3","24","1002","24","10","24","1002","23","-1","23",
                "101","5","23","23","1","24","23","23","4","23","99","0","0");

        for(Amplifier amp : _amplifiers) {
            ArrayList<String> il = new ArrayList<>(instructionList);
            _subject = new IntCodeComputer(amp, amp);
            _subject.runProgram(il);
        }
        assertEquals(54321, _amplifiers.get(4).getOutput());
    }

    @Test
    void p7_1testInput3() throws Exception {
        setPhaseValues(List.of(1,0,4,3,2));
        List<String> instructionList = List.of("3","31","3","32","1002","32","10","32","1001","31","-2","31","1007",
                "31","0","33","1002","33","7","33","1","33","31","31","1","32","31","31","4","31","99","0","0","0");

        for(Amplifier amp : _amplifiers) {
            ArrayList<String> il = new ArrayList<>(instructionList);
            _subject = new IntCodeComputer(amp, amp);
            _subject.runProgram(il);
        }
        assertEquals(65210, _amplifiers.get(4).getOutput());
    }

    @Test
    void testProblem7_1() throws Exception {
        try (InputStream stream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("p7input.txt")) {
            List<String> instructionList = new InstructionListFactory().getInstructionList(stream);
            assertEquals(21000, Problem7.problem7_1(instructionList));
        }
    }

    @Test
    void testProblem7_2input1() throws Exception {
        List<String> instructionList = List.of("3","26","1001","26","-4","26","3","27","1002","27","2","27","1","27",
                "26","27","4","27","1001","28","-1","28","1005","28","6","99","0","0","5");

        _amplifiers = Problem7.createAmplifiers(true);
        int programResult = Problem7.runProgramOnAmplifiers(instructionList, _amplifiers, List.of(9, 8, 7, 6, 5));
        System.out.println(programResult);
        //assertEquals(139629729, programResult);
    }
}