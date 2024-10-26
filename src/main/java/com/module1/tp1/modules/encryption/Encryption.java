package com.module1.tp1.modules.encryption;

public abstract class Encryption {
  public abstract String encrypt(String value);

  public abstract boolean verify(String plainValue, String encryptedValue);
}
