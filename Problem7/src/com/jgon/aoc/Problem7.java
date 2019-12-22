package com.jgon.aoc;

import IO.Amplifier;
import IO.DefaultOutputReceiver;
import OpCodes.OpCodeNumber;
import com.google.common.collect.Collections2;
import com.jgon.containers.InstructionListFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Problem7 {
	public static void main(String[] args) throws Exception {
		Problem7 app = new Problem7();
		InputStream input = app.getClass().getResourceAsStream("/p7input.txt");
		InstructionListFactory isf = new InstructionListFactory();
		List<String> instructionList = isf.getInstructionList(input);
		System.out.println("Problem 7_1: " + problem7_1(instructionList));
		System.out.println("Problem 7_2: " + problem7_2(instructionList));
	}

	public static int problem7_1(List<String> instructionList) throws Exception {
		Collection<List<Integer>> phasePermutations = createPhasePermutations(List.of(0, 1, 2, 3, 4));

		int greatestValue = -1;
		for (List<Integer> permutation : phasePermutations) {
			int programValue = runProgramOnAmplifiers(instructionList,
					permutation);
			if (programValue > greatestValue) {
				greatestValue = programValue;
			}
		}
		return greatestValue;
	}

	public static int problem7_2(List<String> instructionList) throws Exception {
		Collection<List<Integer>> phasePermutations = createPhasePermutations(List.of(5, 6, 7, 8, 9));

		int greatestValue = -1;
		for (List<Integer> permutation : phasePermutations) {
			int programValue = runProgramOnAmplifiers(instructionList,
					permutation,
					List.of(OpCodeNumber.OUTPUT_OP.toInt()),
					true);
			if (greatestValue < programValue) {
				greatestValue = programValue;
			}
		}
		System.out.println(greatestValue);
		return greatestValue;
	}

	public static int runProgramOnAmplifiers(List<String> instructionList,
	                                         List<Integer> permutation) throws Exception {
		return runProgramOnAmplifiers(instructionList,
				permutation,
				List.of(),
				false);
	}

	public static int runProgramOnAmplifiers(List<String> instructionList,
	                                         List<Integer> permutation,
	                                         List<Integer> suspendOpCodes,
	                                         boolean useFeedback) throws Exception {
		ArrayList<Amplifier> amplifiers = createAmplifiers(instructionList,
				permutation,
				suspendOpCodes,
				useFeedback);
		int index = 0;
		while (amplifiers.get(4).isNotHalted()) {
			Amplifier amp = amplifiers.get(index);
			amp.runProgram();
			index++;
			if (index >= amplifiers.size()) {
				index = 0;
			}
		}
		return amplifiers.get(4).getOutput();
	}

	@SuppressWarnings("UnstableApiUsage")
	private static Collection<List<Integer>> createPhasePermutations(List<Integer> phaseValues) {
		return Collections2.orderedPermutations(phaseValues);
	}

	private static ArrayList<Amplifier> createAmplifiers(List<String> instructionList,
	                                                     List<Integer> permutation,
	                                                     List<Integer> suspendOpCodes,
	                                                     boolean useFeedback) {
		ArrayList<Amplifier> amplifiers = new ArrayList<>();
		amplifiers.add(new Amplifier(new DefaultOutputReceiver(),
				instructionList,
				suspendOpCodes,
				permutation.get(0)));
		amplifiers.add(new Amplifier(amplifiers.get(0),
				instructionList,
				suspendOpCodes,
				permutation.get(1)));
		amplifiers.add(new Amplifier(amplifiers.get(1),
				instructionList,
				suspendOpCodes,
				permutation.get(2)));
		amplifiers.add(new Amplifier(amplifiers.get(2),
				instructionList,
				suspendOpCodes,
				permutation.get(3)));
		amplifiers.add(new Amplifier(amplifiers.get(3),
				instructionList,
				suspendOpCodes,
				permutation.get(4)));
		if (useFeedback) {
			amplifiers.get(0).setPreviousAmplifier(amplifiers.get(4));
			amplifiers.get(0).setInitialInput(0);
		}
		return amplifiers;
	}
}

