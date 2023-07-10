package aes.util;

import java.util.HexFormat;

public class KeyExpansion {
    public static final byte[] RCON = HexFormat.of().parseHex("0001020408102040801B366C");

    public static int[] expandKey(byte[] key) {
        int[] expandedKey = new int[44];
        int temp = 0;

        for (int i = 0; i < 4; i++) {
            expandedKey[i] = bytesToInt(key, i);
        }

        for (int i = 4; i < 44; i++) {
            temp = expandedKey[i - 1];

            if (i % 4 == 0) {
                temp = Integer.rotateRight(temp, 8);
                temp ^= RCON[i / 4];
            }

            expandedKey[i] = expandedKey[i - 4] ^ temp;
        }

        return expandedKey;
    }

    public static int bytesToInt(byte[] key, int i) {
        return ((0xFF & key[4 * i]) << 24) | ((0xFF & key[4 * i + 1]) << 16) |
                ((0xFF & key[4 * i + 2]) << 8) | (0xFF & key[4 * i + 3]);
    }
}
