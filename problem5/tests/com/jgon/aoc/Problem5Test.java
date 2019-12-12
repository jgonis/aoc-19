package com.jgon.aoc;

import CPU.IntCodeComputer;
import IO.InputProvider;
import IO.OutputReceiver;
import com.jgon.containers.InstructionListFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class Problem5Test {
    private InputProvider mockInputProvider = mock(InputProvider.class);
    private OutputReceiver mockOutputReceiver = mock(OutputReceiver.class);
    private IntCodeComputer _subject;
    @BeforeEach
    void setUp() {
        _subject = new IntCodeComputer(mockInputProvider, mockOutputReceiver);
    }

    @Test
    void testComparisonPositionModeEqualToEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(8);
        List<String> instructionList = List.of("3","9","8","9","10","9","4","9","99","-1","8");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }

    @Test
    void testComparisonPositionModeNotEqualToEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(7);
        List<String> instructionList = List.of("3","9","8","9","10","9","4","9","99","-1","8");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(0);
    }

    @Test
    void testComparisonPositionModeLessThanEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(7);
        List<String> instructionList = List.of("3","9","7","9","10","9","4","9","99","-1","8");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }

    @Test
    void testComparisonPositionModeNotLessThanEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(8);
        List<String> instructionList = List.of("3","9","7","9","10","9","4","9","99","-1","8");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(0);
    }

    @Test
    void testComparisonImmediateModeEqualToEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(8);
        List<String> instructionList = List.of("3","3","1108","-1","8","3","4","3","99");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }

    @Test
    void testComparisonImmediateModeNotEqualToEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(7);
        List<String> instructionList = List.of("3","3","1108","-1","8","3","4","3","99");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(0);
    }

    @Test
    void testComparisonImmediateModeNotLessThanEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(8);
        List<String> instructionList = List.of("3","3","1107","-1","8","3","4","3","99");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(0);
    }

    @Test
    void testComparisonImmediateModeLessThanEight() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(7);
        List<String> instructionList = List.of("3","3","1107","-1","8","3","4","3","99");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }

    @Test
    void testJumpPositionModeInputZeroOutputZero() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(0);
        List<String> instructionList = List.of("3","12","6","12","15","1","13","14","13","4",
                "13","99","-1","0","1","9");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(0);
    }

    @Test
    void testJumpPositionModeInputOneOutputOne() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(1);
        List<String> instructionList = List.of("3","12","6","12","15","1","13","14","13","4",
                "13","99","-1","0","1","9");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }

    @Test
    void testJumpImmediateModeInputZeroOutputZero() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(0);
        List<String> instructionList = List.of("3","3","1105","-1","9","1101","0","0","12",
                "4","12","99","1");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(0);
    }

    @Test
    void testJumpImmediateModeInputOneOutputOne() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(1);
        List<String> instructionList = List.of("3","3","1105","-1","9","1101","0","0","12",
                "4","12","99","1");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }

    @Test
    void testLargerProgramInputLessThan8() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(7);
        List<Integer> instructionList = List.of(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);
        ArrayList<String> program = new ArrayList<>();
        for(Integer op :instructionList) {
            program.add(op.toString());
        }
        _subject.runProgram(program);
        verify(mockOutputReceiver).receiveOutput(999);
    }

    @Test
    void testLargerProgramInputEqualTo8() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(8);
        List<Integer> instructionList = List.of(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);
        ArrayList<String> program = new ArrayList<>();
        for(Integer op :instructionList) {
            program.add(op.toString());
        }
        _subject.runProgram(program);
        verify(mockOutputReceiver).receiveOutput(1000);
    }

    @Test
    void testLargerProgramInputGreaterThan8() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(9);
        List<Integer> instructionList = List.of(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
                1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
                999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99);
        ArrayList<String> program = new ArrayList<>();
        for(Integer op :instructionList) {
            program.add(op.toString());
        }
        _subject.runProgram(program);
        verify(mockOutputReceiver).receiveOutput(1001);
    }

    @Test
    void testProblem51() throws Exception {
        try (InputStream stream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("p5input.txt")) {
            InstructionListFactory instructionListFactory = new InstructionListFactory();
            List<String> p5InstructionList = instructionListFactory.getInstructionList(stream);
            when(mockInputProvider.getInput()).thenReturn(1);
            _subject.runProgram(p5InstructionList);
            verify(mockOutputReceiver, times(9)).receiveOutput(0);
            verify(mockOutputReceiver, times(1)).receiveOutput(9654885);
        }
    }

    @Test
    void testProblem52() throws Exception {
//        try (InputStream stream = Thread.currentThread()
//                .getContextClassLoader()
//                .getResourceAsStream("p5input.txt")) {
//            InstructionListFactory instructionListFactory = new InstructionListFactory();
//            List<String> p5InstructionList = instructionListFactory.getInstructionList(stream);
//            when(mockInputProvider.getInput()).thenReturn(1);
//            _subject.runProgram(p5InstructionList);
//            verify(mockOutputReceiver, times(9)).receiveOutput(0);
//            verify(mockOutputReceiver, times(1)).receiveOutput(9654885);
//        }
    }
}