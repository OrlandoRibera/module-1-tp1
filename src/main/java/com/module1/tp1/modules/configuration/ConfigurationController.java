package com.module1.tp1.modules.configuration;

import com.module1.tp1.modules.configuration.dto.ConfigurationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config")
public class ConfigurationController {

  @Autowired
  private ConfigurationService configurationService;


  @PostMapping("/modify")
  public ResponseEntity<String> modify(@Valid @RequestBody ConfigurationRequest configurationRequest) {
    try {
      this.configurationService.changeEncryptionMode(configurationRequest.getEncryptionType());
      this.configurationService.changeLoggingService(configurationRequest.getLoggingType());
      return new ResponseEntity<>("Encryption type and logging type modified successfully.", HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity<>("Cannot change encryption and logging types now, please try later.", HttpStatus.BAD_REQUEST);
    }
  }
}
