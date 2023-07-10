import java.util.Arrays;

import aes.AES;
import aes.AESHandler;

public class App {
    public static void main(String[] args) {
        AES aes = new AES();

        var tmp1 = new byte[][] { new byte[] { 1, 2, 3, 4 }, new byte[] { 5, 6, 7, 8 },
                new byte[] { 9, 10, 11, 12 }, new byte[] { 13, 14, 15, 16 } };

        var tmp2 = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

        // print2D(tmp1);
        // System.out.println();

        byte[][] tmp = AESHandler.Encrypt.convertKeyToRows(tmp2);
        var tmp3 = AESHandler.Encrypt.rowShift(tmp);

        var tmp4 = AESHandler.Encrypt.convertRowsToKey(tmp3);

        System.out.println(Arrays.toString(tmp4));
        // print2D(tmp);
        System.out.println();
    }

    public static void print2D(byte mat[][]) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++)

            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
                if (j % 4 == 3) {
                    System.out.println();
                }
            }
    }
}
