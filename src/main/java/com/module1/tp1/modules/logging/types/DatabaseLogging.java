package com.module1.tp1.modules.logging.types;

import com.module1.tp1.modules.logging.Log;
import com.module1.tp1.modules.logging.LogRepository;
import com.module1.tp1.modules.logging.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLogging extends Logging {
  @Autowired
  private LogRepository logRepository;

  @Override
  public void log(String message) {
    Log log = new Log(message);
    logRepository.save(log);
  }
}
