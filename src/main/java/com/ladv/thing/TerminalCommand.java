package com.ladv.thing;

public enum TerminalCommand {
  INSTRUCTIONS("instructions"),
  ADD("add"),
  STOP("stop"),
  MAX("max"),
  MIN ("min"),
  AVG ("avg");

  private String name;


  TerminalCommand(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }



}
