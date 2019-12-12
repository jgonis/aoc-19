package com.jgon.containers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructionListFactory {
    public List<String> getInstructionList(InputStream input) throws IOException {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        List<String> opStream = new ArrayList<>();
        while (s != null) {
            opStream.add(s);
            s = br.readLine();
        }
        String[] split = opStream.get(0).split(",");
        return Arrays.asList(split);
    }
}
