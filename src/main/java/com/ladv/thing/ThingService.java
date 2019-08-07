package com.ladv.thing;

import java.text.NumberFormat;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class ThingService {
  private final IntSummaryStatistics statistics;

  public ThingService() {
    this.statistics = IntStream.empty().summaryStatistics();
  }

  public String execute(String input) {
    try {
      String[] parts = input.split(" ");
      TerminalCommand command = getCommand(parts[0]);
      String output;
      switch (command) {
        case ADD:
          int addedCount = addNumbers(parts);
          output = String.format("added %d numbers", addedCount);
          break;
        case MIN:
          output = String.valueOf(statistics.getMin());
          break;
        case MAX:
          output = String.valueOf(statistics.getMax());
          break;
        case AVG:
          output = NumberFormat.getInstance().format(statistics.getAverage());
          break;
        case INSTRUCTIONS:
          output = Constants.INSTRUCTIONS;
          break;
        default:
          output = Constants.INVALID_INPUT;
      }
      return output;
    } catch (CommandException e) {
      return Constants.INVALID_INPUT + e.getMessage();
    }
  }

  private TerminalCommand getCommand(String part) {
    try {
      return TerminalCommand.valueOf(part.toUpperCase());
    } catch (IllegalArgumentException | NullPointerException e) {
      throw new CommandException("couldn't parse command");
    }
  }

  private int addNumbers(String[] parts) {
    int[] ints = parseInts(parts);
    IntStream.of(ints).forEachOrdered(statistics);
    return ints.length;
  }

  private int[] parseInts(String[] parts) {
    try {
      int[] numbers = new int[parts.length - 1];
      //exclude first([0] index) command name
      for (int i = 1; i < parts.length; i++) {
        numbers[i - 1] = Integer.parseInt(parts[i]);
      }
      return numbers;
    } catch (NumberFormatException e) {
      throw new CommandException(e.getMessage());
    }
  }
}
