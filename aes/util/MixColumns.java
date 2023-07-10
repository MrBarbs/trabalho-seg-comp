package aes.util;

public interface MixColumns {

    static byte[][] convertKeyToColumns(byte[] key) {
        byte[][] columns = new byte[4][4];

        for (int i = 0; i < key.length; i++) {
            columns[i / 4][i % 4] = key[i];
        }

        return columns;
    }

    static byte[] convertColumnsToKey(byte[][] columns) {
        byte[] key = new byte[16];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                key[4 * i + j] = columns[i][j];
            }
        }

        return key;
    }

}
