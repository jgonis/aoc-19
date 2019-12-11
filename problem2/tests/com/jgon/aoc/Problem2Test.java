package com.jgon.aoc;

import com.jgon.containers.Pair;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

	@Test
	void processTestInput1() throws Exception {
		try (InputStream stream = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("p2testinput1.txt")) {

			assertEquals(2, Problem2.problem2_1(stream, List.of()));
		}
	}

	@Test
	void processTestInput2() throws Exception {
		try (InputStream stream = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("p2testinput2.txt")) {

			assertEquals(30, Problem2.problem2_1(stream, List.of()));
		}
	}

	@Test
	void processFullInput() throws Exception {
		try (InputStream stream = Thread.currentThread()
				.getContextClassLoader()
				.getResourceAsStream("p2input.txt")) {

			assertEquals(5866663, Problem2.problem2_1(stream, List.of(Pair.of(1, Integer.toString(12)),
					Pair.of(2, Integer.toString(2)))));
		}
	}
}