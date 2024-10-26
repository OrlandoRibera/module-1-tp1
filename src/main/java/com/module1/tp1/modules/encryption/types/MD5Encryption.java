package com.module1.tp1.modules.encryption.types;

import com.module1.tp1.modules.encryption.Encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Encryption extends Encryption {

  private static final String ALGORITHM = "MD5";

  @Override
  public String encrypt(String value) {
    try {
      MessageDigest md = MessageDigest.getInstance(ALGORITHM);
      byte[] hashBytes = md.digest(value.getBytes());
      return Base64.getEncoder().encodeToString(hashBytes);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error during MD5 encryption", e);
    }
  }

  @Override
  public boolean verify(String plainValue, String encryptedValue) {
    return encrypt(plainValue).equals(encryptedValue);
  }
}