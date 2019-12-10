package com.jgon.aoc;

import com.jgon.containers.Pair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {

    public static void main(String[] args) throws Exception {
        Problem5 app = new Problem5();
        InputStream input = app.getClass().getResourceAsStream("/p5input.txt");
        //System.out.println("Problem 2-1: " + problem2_1(input, List.of(List.of(1, 12), List.of(2,2))));
        problem5_1(input);
    }

    private static int problem5_1(InputStream input) throws Exception {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        List<String> opStream = new ArrayList<>();
        while (s != null) {
            opStream.add(s);
            s = br.readLine();
        }
        List<String> ops = Arrays.asList(opStream.get(0).split(","));
        return -1;
    }

    public static Pair<List<Integer>, Integer> parseInstruction(String instruction) {
        List<Integer> parameterModes = new ArrayList<>(3);
        parameterModes.add(0);
        parameterModes.add(0);
        parameterModes.add(0);
        Integer instructionValue;
        if(instruction.length() != 1) {
            int parameterModeIndex = 2;
            instructionValue = Integer.decode(instruction.substring(instruction.length() - 2));
            for(int i = (instruction.length() - 3); i >= 0; i--) {
                parameterModes.set(parameterModeIndex, Character.getNumericValue(instruction.charAt(i)));
                parameterModeIndex--;
            }
        } else {
            return Pair.of(parameterModes, Integer.decode(instruction));
        }
        return Pair.of(parameterModes, instructionValue);
    }
}
