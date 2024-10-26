package com.module1.tp1.modules.encryption;

import com.module1.tp1.modules.encryption.types.ReverseEncryption;
import org.springframework.stereotype.Service;

/**
 * This service will contain the Strategy to change the current Encryption mode
 */
@Service
public class EncryptionService {
  private Encryption encryption;

  public EncryptionService() {
    try {
      this.encryption = new ReverseEncryption();
      System.out.println("=== ENCRYPTION MODE === \n" + this.encryption.getClass());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String encrypt(String value) {
    return this.encryption.encrypt(value);
  }

  public boolean verify(String plainValue, String encryptedValue) {
    return this.encryption.verify(plainValue, encryptedValue);
  }

  public void changeEncryptionMode(Encryption encryption) {
    this.encryption = encryption;
  }
}
