package com.module1.tp1.modules.configuration.dto;

import com.module1.tp1.modules.encryption.EncryptionType;
import com.module1.tp1.modules.logging.LoggingType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ConfigurationRequest {
  @NotNull(message = "encryptionType is required.")
  private final EncryptionType encryptionType;
  @NotNull(message = "loggingType is required.")
  private final LoggingType loggingType;
}
