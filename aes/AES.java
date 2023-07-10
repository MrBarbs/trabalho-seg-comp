package aes;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import aes.util.KeyExpansion;

public class AES {

  private int[] expandedKey;
  private byte[] key;
  private String message;
  private final int KEY_SIZE = 128;

  public AES(String message, String key) {
    this.key = key.getBytes();
    this.message = message;
  }

  public AES(String message, byte[] key) {
    this.key = key;
    this.message = message;
  }

  public AES(String message) {
    this.key = generateKey();
    this.message = message;
  }

  public byte[] generateKey() {
    byte[] key = new byte[KEY_SIZE / 8];
    Random random = new Random();

    for (int i = 0; i < KEY_SIZE / 8; i++) {
      random.nextBytes(key);
    }

    return key;
  }

  public String encrypt() {
    // 1. Key expansion
    this.expandedKey = KeyExpansion.expandKey(this.key);

    // 2. Initial Round
    // int[] step = AESRounds.Encrypt.initialRound(this.message, this.expandedKey);

    // 3. Rounds

    // 4. Final Round

    // 5. Output
    // byte[] output = AESRounds.Encrypt.rounds(step, this.expandedKey);

    // return new String(output, StandardCharsets.UTF_8);
    return "";
  }
}
