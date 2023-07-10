package aes.util;

import java.util.HexFormat;

public interface AddRoundKey {
    public static final byte[] RCON = HexFormat.of().parseHex("0001020408102040801B366C");

    public static byte[] addRoundKey(byte[][] state, byte[][] roundKey, int round) {
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                state[row][col] ^= roundKey[row][col];
            }
        }
        state[0][0] ^= RCON[round];

        return ShiftRow.convertRowsToKey(state);
    }

    public static void inverseAddRoundKey(byte[][] state, byte[][] roundKey, int round) {
        state[0][0] ^= RCON[round];
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                state[row][col] ^= roundKey[row][col];
            }
        }
    }
}
