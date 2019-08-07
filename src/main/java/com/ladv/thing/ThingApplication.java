package com.ladv.thing;


import java.util.Scanner;

public class ThingApplication {

  public static void main(String[] args) {
    ThingService thingService = new ThingService();
    Scanner scanner = new Scanner(System.in);
    String input;
    System.out.println(Constants.INSTRUCTIONS);
    for (input = scanner.nextLine(); !input.equalsIgnoreCase("stop"); input = scanner.nextLine()) {
      System.out.println(thingService.execute(input));
    }
  }

}
