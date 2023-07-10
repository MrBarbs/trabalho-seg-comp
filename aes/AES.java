package aes;

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

  public String encrypt() {
    // 1. Key expansion
    this.expandedKey = KeyExpansion.expandKey(this.key);
    // 2. Initial Round

    // 3. Rounds
    // 4. Final Round
    // 5. Output

    return "";
  }
}
