package com.jgon.aoc;

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
}
