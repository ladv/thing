package com.ladv.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ThingServiceTest {

  @Test
  void testStartWithEmptyParameters() {
    String input = "add 3";
    ThingService thingService = new ThingService();
    String output = thingService.execute(input);
    assertEquals("added 1 numbers", output);

    input = "min";
    output = thingService.execute(input);
    assertEquals("3", output);

    input = "add 5";
    output = thingService.execute(input);
    assertEquals("added 1 numbers", output);

    input = "max";
    output = thingService.execute(input);
    assertEquals("5", output);

    input = "avg";
    output = thingService.execute(input);
    assertEquals("4.0", output);

    input = "add 2 6";
    output = thingService.execute(input);
    assertEquals("added 2 numbers", output);


    input = "min";
    output = thingService.execute(input);
    assertEquals("2", output);

    input = "max";
    output = thingService.execute(input);
    assertEquals("6", output);

    input = "avg";
    output = thingService.execute(input);
    assertEquals("4.0", output);

    input = "add 12 11 4a";
    output = thingService.execute(input);
    assertTrue(output.contains("Invalid input:"));

    // make sure that invalid input hadn't been accepted
    input = "avg";
    output = thingService.execute(input);
    assertEquals("4.0", output);

    input = "instructions";
    output = thingService.execute(input);
    assertEquals(output, Constants.INSTRUCTIONS);

  }
}