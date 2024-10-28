package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }

  @Test
  void exampleFailingTestWithRandomizedFuzzies() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }

  @Test
  void exampleFailingTestWithSortedFuzzies() {
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }

  @Test
  public void testLinearSearchOnSortedList() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    int index = finder.linearSearch(sortedFuzzies);
    assertEquals("gold", sortedFuzzies.get(index).color);
  }

  @Test
  public void testLinearSearchOnRandomList() {
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    int index = finder.linearSearch(randomFuzzies);
    assertEquals("gold", randomFuzzies.get(index).color);
  }

  @Test
  public void testBinarySearchOnSortedList() {
    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    int index = finder.binarySearch(sortedFuzzies);
    assertEquals("gold", sortedFuzzies.get(index).color);
  }

  @Test
  public void testBinarySearchOnRandomizedList() {
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
    int index = finder.binarySearch(randomFuzzies);
    assertEquals("gold", randomFuzzies.get(index).color);
  }

}
