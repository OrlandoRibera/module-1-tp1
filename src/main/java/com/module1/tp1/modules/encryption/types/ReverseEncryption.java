package com.module1.tp1.modules.encryption.types;

import com.module1.tp1.modules.encryption.Encryption;

public class ReverseEncryption extends Encryption {

  @Override
  public String encrypt(String value) {
    return new StringBuilder(value).reverse().toString();
  }

  @Override
  public boolean verify(String plainValue, String encryptedValue) {
    return this.encrypt(plainValue).equals(encryptedValue);
  }
}
