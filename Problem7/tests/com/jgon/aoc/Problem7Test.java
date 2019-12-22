package com.jgon.aoc;

import com.jgon.containers.InstructionListFactory;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem7Test {
	@Test
	void p7_1testInput1() throws Exception {

		List<String> instructionList = List.of("3", "15", "3", "16", "1002", "16", "10", "16", "1", "16", "15", "15",
				"4", "15", "99", "0", "0");
		assertEquals(43210, Problem7.runProgramOnAmplifiers(instructionList,
				List.of(4, 3, 2, 1, 0),
				false));
	}

	@Test
	void p7_1testInput2() throws Exception {
		List<String> instructionList = List.of("3", "23", "3", "24", "1002", "24", "10", "24", "1002", "23", "-1", "23",
				"101", "5", "23", "23", "1", "24", "23", "23", "4", "23", "99", "0", "0");
        assertEquals(54321, Problem7.runProgramOnAmplifiers(instructionList,
				List.of(0, 1, 2, 3, 4),
				false));
	}

	@Test
	void p7_1testInput3() throws Exception {
		List<String> instructionList = List.of("3", "31", "3", "32", "1002", "32", "10", "32", "1001", "31", "-2", "31", "1007",
				"31", "0", "33", "1002", "33", "7", "33", "1", "33", "31", "31", "1", "32", "31", "31", "4", "31", "99", "0", "0", "0");
        assertEquals(65210, Problem7.runProgramOnAmplifiers(instructionList,
				List.of(1, 0, 4, 3, 2),
				false));
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
		List<String> instructionList = List.of("3", "26", "1001", "26", "-4", "26", "3", "27", "1002", "27", "2", "27", "1", "27",
				"26", "27", "4", "27", "1001", "28", "-1", "28", "1005", "28", "6", "99", "0", "0", "5");

//		assertEquals(139629729, Problem7.runProgramOnAmplifiers(instructionList,
//				List.of(9, 8, 7, 6, 5),
//				true));
	}

	@Test
	void testProblem7_2input2() throws Exception {
		List<String> instructionList = List.of(3, 52, 1001, 52, -5, 52, 3, 53, 1, 52, 56, 54, 1007, 54, 5, 55, 1005, 55, 26, 1001, 54,
				-5, 54, 1105, 1, 12, 1, 53, 54, 53, 1008, 54, 0, 55, 1001, 55, 1, 55, 2, 53, 55, 53, 4,
				53, 1001, 56, -1, 56, 1005, 56, 6, 99, 0, 0, 0, 0, 10)
				.stream()
				.map(Object::toString)
				.collect(Collectors.toList());

//		assertEquals(18216, Problem7.runProgramOnAmplifiers(instructionList,
//				List.of(9,7,8,5,6),
//				true));
	}
}