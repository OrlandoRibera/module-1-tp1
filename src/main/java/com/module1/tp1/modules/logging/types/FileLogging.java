package com.module1.tp1.modules.logging.types;

import com.module1.tp1.modules.logging.Logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogging extends Logging {

  private static final String FILE_PATH = "tp1.log";

  @Override
  public void log(String message) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
      writer.write(message);
      writer.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
