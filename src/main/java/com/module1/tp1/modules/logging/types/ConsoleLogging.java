package com.module1.tp1.modules.logging.types;

import com.module1.tp1.modules.logging.Logging;

import java.util.Date;

public class ConsoleLogging extends Logging {

  @Override
  public void log(String message) {
    System.out.println("=== " + message + " Time: " + new Date().getTime() + " ===");
  }
}
