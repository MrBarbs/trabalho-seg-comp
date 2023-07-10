import aes.AES;

public class App {
    public static void main(String[] args) {
        AES aes = new AES();

        var tmp1 = new byte[][] { new byte[] { 1, 2, 3, 4 }, new byte[] { 5, 6, 7, 8 },
                new byte[] { 9, 10, 11, 12 }, new byte[] { 13, 14, 15, 16 } };

        var tmp2 = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
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
