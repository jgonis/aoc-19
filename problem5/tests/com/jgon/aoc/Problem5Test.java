package com.jgon.aoc;

import com.jgon.containers.Pair;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem5Test {

    @Test
    void parseInstruction() {
        assertEquals(Pair.of(List.of(0, 0, 0), 2), Problem5.parseInstruction("2"));
        assertEquals(Pair.of(List.of(0, 0, 1), 2), Problem5.parseInstruction("102"));
        assertEquals(Pair.of(List.of(0, 1, 0), 2), Problem5.parseInstruction("1002"));
        assertEquals(Pair.of(List.of(0, 1, 1), 2), Problem5.parseInstruction("1102"));
        assertEquals(Pair.of(List.of(1, 0, 0), 2), Problem5.parseInstruction("10002"));
        assertEquals(Pair.of(List.of(1, 0, 1), 2), Problem5.parseInstruction("10102"));
        assertEquals(Pair.of(List.of(1, 1, 0), 2), Problem5.parseInstruction("11002"));
        assertEquals(Pair.of(List.of(1, 1, 1), 2), Problem5.parseInstruction("11102"));
    }
}