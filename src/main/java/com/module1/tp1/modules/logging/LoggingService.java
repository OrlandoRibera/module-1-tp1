package com.module1.tp1.modules.logging;

import com.module1.tp1.modules.logging.types.ConsoleLogging;
import org.springframework.stereotype.Service;

/**
 * This service will contain the Strategy to change the current Logging mode
 */
@Service
public class LoggingService {
  private Logging logging;

  public LoggingService() {
    this.logging = new ConsoleLogging();
    System.out.println("=== LOGGING MODE === \n" + this.logging.getClass());
  }

  public void log(String message) {
    this.logging.log(message);
  }

  public void changeLoggingMode(Logging logging) {
    this.logging = logging;
  }
}
