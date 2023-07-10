package aes;

import java.util.Random;

public class AES {

  private byte[] key;
  private final int KEY_SIZE = 128;

  public byte[] generateKey() {
    byte[] key = new byte[KEY_SIZE / 8];
    Random random = new Random();

    for (int i = 0; i < KEY_SIZE / 8; i++) {
      random.nextBytes(key);
    }

    return key;
  }

  public AES() {
    this.key = generateKey();
  }

}
