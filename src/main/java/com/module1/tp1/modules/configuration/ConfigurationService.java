package com.module1.tp1.modules.configuration;

import com.module1.tp1.modules.encryption.*;
import com.module1.tp1.modules.encryption.types.BCryptEncryption;
import com.module1.tp1.modules.encryption.types.MD5Encryption;
import com.module1.tp1.modules.encryption.types.ReverseEncryption;
import com.module1.tp1.modules.logging.*;
import com.module1.tp1.modules.logging.types.ApiLogging;
import com.module1.tp1.modules.logging.types.ConsoleLogging;
import com.module1.tp1.modules.logging.types.DatabaseLogging;
import com.module1.tp1.modules.logging.types.FileLogging;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ConfigurationService {
  @Autowired
  private final EncryptionService encryptionService;
  @Autowired
  private final LoggingService loggingService;
  @Autowired
  private DatabaseLogging databaseLogging;

  public ConfigurationService(EncryptionService encryptionService, LoggingService loggingService) {
    this.encryptionService = encryptionService;
    this.loggingService = loggingService;
  }

  public void changeEncryptionMode(EncryptionType encryptionType) {
    this.loggingService.log("ConfigurationService: changing encryption mode to: " + encryptionType + ".");
    try {
      switch (encryptionType) {
        case REVERSE:
          this.encryptionService.changeEncryptionMode(new ReverseEncryption());
          break;
        case MD5:
          this.encryptionService.changeEncryptionMode(new MD5Encryption());
          break;
        case BCRYPT:
          this.encryptionService.changeEncryptionMode(new BCryptEncryption());
          break;
        default:
          throw new Exception("Unsupported encryption type: " + encryptionType);
      }
      this.loggingService.log("ConfigurationService: Encryption mode changed successfully.");
    } catch (Exception e) {
      throw new RuntimeException("Cannot change encryption to" + encryptionType + " now.");
    }
  }

  public void changeLoggingService(LoggingType loggingType) {
    this.loggingService.log("ConfigurationService: changing logging mode to: " + loggingType + ".");
    try {
      switch (loggingType) {
        case SERVICE:
          this.loggingService.changeLoggingMode(new ApiLogging());
          break;
        case CONSOLE:
          this.loggingService.changeLoggingMode(new ConsoleLogging());
          break;
        case FILE:
          this.loggingService.changeLoggingMode(new FileLogging());
          break;
        case DB:
          this.loggingService.changeLoggingMode(databaseLogging);
          break;
        default:
          throw new IllegalArgumentException("Unsupported loggingType type: " + loggingType);
      }
      this.loggingService.log("ConfigurationService: Logging mode changed successfully.");
    } catch (Exception e) {
      throw new RuntimeException("Cannot change logging to" + loggingType + " now.");
    }
  }

}
