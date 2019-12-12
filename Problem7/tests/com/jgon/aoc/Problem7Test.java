package com.jgon.aoc;

import CPU.IntCodeComputer;
import IO.DefaultOutputReceiver;
import IO.InputProvider;
import IO.OutputReceiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class Problem7Test {

    private InputProvider mockInputProvider = mock(InputProvider.class);
    //private OutputReceiver mockOutputReceiver = mock(OutputReceiver.class);
    private OutputReceiver mockOutputReceiver = new DefaultOutputReceiver();
    private IntCodeComputer _subject;
    @BeforeEach
    void setUp() {
        _subject = new IntCodeComputer(mockInputProvider, mockOutputReceiver);
    }

    @Test
    void main() throws Exception {
        when(mockInputProvider.getInput()).thenReturn(8);
        List<String> instructionList = List.of("3","15","3","16","1002","16","10","16","1","16","15","15",
                "4","15","99","0","0");
        ArrayList<String> il = new ArrayList<>(instructionList);
        _subject.runProgram(il);
        verify(mockOutputReceiver).receiveOutput(1);
    }
}