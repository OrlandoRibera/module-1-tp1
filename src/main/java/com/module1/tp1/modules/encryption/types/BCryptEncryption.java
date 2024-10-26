package com.module1.tp1.modules.encryption.types;

import com.module1.tp1.modules.encryption.Encryption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncryption extends Encryption {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public BCryptEncryption() {
    this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
  }

  @Override
  public String encrypt(String value) {
    return bCryptPasswordEncoder.encode(value);
  }

  @Override
  public boolean verify(String plainValue, String encryptedValue) {
    return bCryptPasswordEncoder.matches(plainValue, encryptedValue);
  }
}