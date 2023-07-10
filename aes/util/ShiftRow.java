package aes.util;

public interface ShiftRow {

    static byte[][] rowShift(byte[][] rows) {
        byte[][] newRows = new byte[4][4];
        for (int i = 0; i < rows.length; i++) {
            newRows[i] = rows[i].clone();
        }

        for (int i = 1; i < 4; i++) {
            byte[] tmp = newRows[i].clone();

            for (int j = 0; j < 4; j++) {
                newRows[i][j] = tmp[(j + i) % 4];
            }
        }

        return newRows;
    } // ok

    static byte[][] convertKeyToRows(byte[] key) {
        byte[][] rows = new byte[4][4];
        for (int i = 0; i < key.length; i++) {
            rows[i % 4][i / 4] = key[i];
        }
        return rows;
    } // ok

    static byte[] convertRowsToKey(byte[][] rows) {
        byte[] key = new byte[16];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                key[i + 4 * j] = rows[i][j];
            }
        }
        return key;
    } // ok

}
