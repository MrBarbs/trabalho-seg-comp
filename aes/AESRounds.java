package aes;

import aes.util.KeyExpansion;
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

        public static int[] initialRound(String message, int[] expandedKey) {
            byte[] paddedMessage = messagePadding(message);

            int[] initialRoundResponse = new int[paddedMessage.length / 4];

            for (int i = 0; i < initialRoundResponse.length; i++) {
                KeyExpansion.bytesToInt(paddedMessage, i);
            }

            for (int i = 0; i < initialRoundResponse.length; i++) {
                initialRoundResponse[i] ^= expandedKey[i % 4];
            }

            return initialRoundResponse;
        }

        public static byte[] rounds(int[] firstStep, int[] expandedKey) {
            byte[] step = intArrayToByteArray(firstStep);
            for (int i = 1; i < 11; i++) {
                step = subBytes(step);
                step = shiftRows(step);
                if (i != 10) {
                    step = mixColumns(step);
                }
                // int[] roundKey = Arrays.copyOfRange(expandedKey, 4 * i, 4 * i + 4);
                // step = AddRoundKey.addRoundKey(ShiftRow.convertKeyToRows(step),
                // ShiftRow.convertKeyToRows(intArrayToByteArray(roundKey)), i);
            }
            return step;
        }

        private static byte[] messagePadding(String message) {
            String paddedMessage = message + Byte.toString((byte) 0x80);

            int size = 16 - paddedMessage.length() % 16;

            for (int i = 0; i < size; i++) {
                paddedMessage += Byte.toString((byte) 0x00);
            }

            return paddedMessage.getBytes();
        }

        private static byte[] intArrayToByteArray(int[] array) {
            byte[][] aux = new byte[array.length][4];
            for (int i = 0; i < array.length; i++) {
                aux[i] = intToByteArray(array[i]);
            }

            byte[] result = new byte[array.length * 4];
            for (int i = 0; i < result.length; i++) {
                result[i] = aux[i / 4][i % 4];
            }

            return result;
        }

        public static byte[] intToByteArray(int i) {
            {
                byte[] result = new byte[4];

                result[0] = (byte) (i >> 24);
                result[1] = (byte) (i >> 16);
                result[2] = (byte) (i >> 8);
                result[3] = (byte) (i /* >> 0 */);

                return result;
            }
        }
    }
}
