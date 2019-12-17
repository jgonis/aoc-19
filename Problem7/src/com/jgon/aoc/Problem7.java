package com.jgon.aoc;

import CPU.IntCodeComputer;
import IO.Amplifier;
import IO.DefaultOutputReceiver;
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
		problem7_1(instructionList);
		//problem7_2(instructionList);
	}

	public static int problem7_1(List<String> instructionList) throws Exception {

		Collection<List<Integer>> phasePermutations = createPhasePermutations(List.of(0, 1, 2, 3, 4));
		ArrayList<Amplifier> amplifiers = createAmplifiers(false);

		int greatestValue = -1;
		for (List<Integer> permutation : phasePermutations) {
			int programValue = runProgramOnAmplifiers(instructionList,
					amplifiers,
					permutation);
			if (programValue > greatestValue) {
				greatestValue = programValue;
			}
		}
		return greatestValue;
	}

	public static int problem7_2(List<String> instructionList) throws Exception {
		Collection<List<Integer>> phasePermutations = createPhasePermutations(List.of(5, 6, 7, 8, 9));
		ArrayList<Amplifier> amplifiers = createAmplifiers(true);

		int greatestValue = -1;
		for (List<Integer> permutation : phasePermutations) {
			int programValue = runProgramOnAmplifiers(instructionList,
					amplifiers,
					permutation);
			if (programValue > greatestValue) {
				greatestValue = programValue;
			}
		}
		System.out.println(greatestValue);
		return greatestValue;
	}

	public static int runProgramOnAmplifiers(List<String> instructionList,
	                                         List<Amplifier> amplifiers,
	                                         List<Integer> permutation) throws Exception {
		setupAmplifiers(amplifiers, permutation);
		for (Amplifier amp : amplifiers) {
			System.out.println("start amp software");
			ArrayList<String> il = new ArrayList<>(instructionList);
			IntCodeComputer cpu = new IntCodeComputer(amp, amp);
			cpu.runProgram(il);
		}
		return amplifiers.get(4).getOutput();
	}

	private static void setupAmplifiers(List<Amplifier> amplifiers, List<Integer> permutation) {
		for (int i = 0; i < permutation.size(); i++) {
			amplifiers.get(i).reset();
			amplifiers.get(i).setPhase(permutation.get(i));
		}
	}

	private static Collection<List<Integer>> createPhasePermutations(List<Integer> phaseValues) {
		return Collections2.orderedPermutations(phaseValues);
	}

	public static ArrayList<Amplifier> createAmplifiers(boolean useFeedback) {
		ArrayList<Amplifier> amplifiers = new ArrayList<>();
		amplifiers.add(new Amplifier(new DefaultOutputReceiver()));
		amplifiers.add(new Amplifier(amplifiers.get(0)));
		amplifiers.add(new Amplifier(amplifiers.get(1)));
		amplifiers.add(new Amplifier(amplifiers.get(2)));
		amplifiers.add(new Amplifier(amplifiers.get(3)));
		if (useFeedback == true) {
			amplifiers.get(0).setPreviousAmplifier(amplifiers.get(4));
		}
		return amplifiers;
	}
}

