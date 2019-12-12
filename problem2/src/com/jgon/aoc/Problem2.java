package com.jgon.aoc;

import com.jgon.containers.InstructionListFactory;
import com.jgon.containers.Pair;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	public static void main(String[] args) throws Exception {
		Problem2 app = new Problem2();
		InputStream input = app.getClass().getResourceAsStream("/p2input.txt");
		System.out.println("Problem 2-1: " + problem2_1(input, List.of(Pair.of(1, Integer.toString(12)),
				Pair.of(2,Integer.toString(2)))));
		System.out.println("Problem 2-2: " + problem2_2(input));
    }

	private static int problem2_2(InputStream input) throws Exception {
		InstructionListFactory isf = new InstructionListFactory();
		List<String> instructionList = isf.getInstructionList(input);
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				ArrayList<String> instructionListCopy = new ArrayList<>();
				for(String op : instructionList) {
					instructionListCopy.add(op);
				}
				Problem2_1 p22 = new Problem2_1();
				int result = p22.runProgram(instructionListCopy,
						List.of(Pair.of(1, Integer.toString(i)),
						Pair.of(2, Integer.toString(j))));
				if(result == 19690720) {
					return (100 * i) + j;
				}
			}
		}
		return -1;
	}

	static int problem2_1(InputStream input, List<Pair<Integer, String>> inputs) throws Exception {
		InstructionListFactory isf = new InstructionListFactory();
		List<String> instructionList = isf.getInstructionList(input);
		Problem2_1 p21 = new Problem2_1();
		int result = p21.runProgram(instructionList, inputs);
		return result;
	}
}
