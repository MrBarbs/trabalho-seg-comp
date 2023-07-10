package aes;

import aes.util.MixColumns;
import aes.util.ShiftRow;
import aes.util.SubBytes;

public interface AESRounds {
    public interface Encrypt {
        public static byte[] subBytes(byte[] key) {
            byte[] result = new byte[key.length];

            for (int i = 0; i < key.length; i++) {
                result[i] = SubBytes.SBOX[key[i]];
            }

            return result;
        } // ok

        public static byte[] shiftRows(byte[] key) {
            byte[][] rows = ShiftRow.convertKeyToRows(key);

            rows = ShiftRow.encryptRowShift(rows);

            return ShiftRow.convertRowsToKey(rows);
        } // ok

        public static byte[] mixColumns(byte[] key) {
            byte[][] rows = ShiftRow.convertKeyToRows(key);

            rows = MixColumns.columnMixer(rows);

            return ShiftRow.convertRowsToKey(rows);
        } // ok

        public static byte[] addRoundKeys(byte[] key) {
            // to be implemented
            return new byte[] {};
        }

    }
}
