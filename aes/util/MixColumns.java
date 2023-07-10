package aes.util;

public interface MixColumns {
    public static final int[] MIX_COLUMN_MATRIX = {
            0x02, 0x03, 0x01, 0x01,
            0x01, 0x02, 0x03, 0x01,
            0x01, 0x01, 0x02, 0x03,
            0x03, 0x01, 0x01, 0x02
    };

    public static final int[] INVERSE_MIX_COLUMN_MATRIX = {
            0x0E, 0x0B, 0x0D, 0x09,
            0x09, 0x0E, 0x0B, 0x0D,
            0x0D, 0x09, 0x0E, 0x0B,
            0x0B, 0x0D, 0x09, 0x0E
    };

    public static void columnMixer(byte[][] state) {
        mixColumns(state, MIX_COLUMN_MATRIX);
    } // ok

    public static void inverseMixColumns(byte[][] state) {
        mixColumns(state, INVERSE_MIX_COLUMN_MATRIX);
    } // ok

    private static void mixColumns(byte[][] state, int[] matrix) {
        for (int col = 0; col < 4; col++) {
            byte[] column = getColumn(state, col);
            byte[] mixedColumn = mixColumn(column, matrix);
            setColumn(state, col, mixedColumn);
        }
    }

    private static byte[] getColumn(byte[][] matrix, int col) {
        byte[] column = new byte[4];
        for (int row = 0; row < 4; row++) {
            column[row] = matrix[row][col];
        }
        return column;
    }

    private static void setColumn(byte[][] matrix, int col, byte[] column) {
        for (int row = 0; row < 4; row++) {
            matrix[row][col] = column[row];
        }
    }

    private static byte[] mixColumn(byte[] column, int[] matrix) {
        byte[] mixedColumn = new byte[4];
        for (int row = 0; row < 4; row++) {
            mixedColumn[row] = (byte) (multiply(matrix[row * 4], column[0])
                    ^ multiply(matrix[row * 4 + 1], column[1])
                    ^ multiply(matrix[row * 4 + 2], column[2])
                    ^ multiply(matrix[row * 4 + 3], column[3]));
        }
        return mixedColumn;
    }

    private static byte multiply(int a, byte b) {
        int product = 0;
        for (int i = 0; i < 8; i++) {
            if ((a & 1) == 1) {
                product ^= b;
            }
            boolean carry = (b & 0x80) != 0;
            b <<= 1;
            if (carry) {
                b ^= 0x1B;
            }
            a >>= 1;
        }
        return (byte) product;
    }
}
